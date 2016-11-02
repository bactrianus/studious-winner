package com.groupdocs.ui.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.html.HtmlResource;
import com.groupdocs.viewer.domain.html.HtmlResourceType;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.ui.ViewerUtils;
import com.groupdocs.ui.model.GetDocumentPageHtmlParameters;
import com.groupdocs.ui.model.Utils;
import com.groupdocs.ui.model.helper.DotNetToJavaStringHelper;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/GetDocumentPageHtml")
public class GetDocumentPageHtml extends HttpServlet {
    List<String> temp_cssList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.addHeader("Content-Type", "application/json");
        GetDocumentPageHtmlParameters parameters = new ObjectMapper().readValue(request.getInputStream(), GetDocumentPageHtmlParameters.class);

        if (DotNetToJavaStringHelper.isNullOrWhiteSpace(parameters.getPath())) {
            System.out.println("A document path must be specified path");
        }

        String[] cssList = null;
        int pageNumber = parameters.getPageIndex() + 1;

        HtmlOptions htmlOptions = new HtmlOptions();
        htmlOptions.setPageNumber(parameters.getPageIndex() + 1);
        htmlOptions.setCountPagesToConvert(1);
        htmlOptions.setResourcesEmbedded(true);
        htmlOptions.setHtmlResourcePrefix(
                "/GetResourceForHtml?documentPath=" + parameters.getPath() + "&pageNumber={page-number}&resourceName=");

        List<PageHtml> htmlPages = null;
        try {
            htmlPages = GetHtmlPages(parameters.getPath(), htmlOptions);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }


        String pageHtml = htmlPages.size() > 0 ? htmlPages.get(0).getHtmlContent() : null;
        String[] pageCss = temp_cssList.size() > 0 ? new String[]{String.join(" ", temp_cssList)} : null;

        Map<String, Object> a = new HashMap<String, Object>();
        a.put("pageHtml", pageHtml);
        a.put("pageCss", pageCss);

        String result = String.join(pageHtml, pageCss);
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
///////////////////////

    private List<PageHtml> GetHtmlPages(String filePath, HtmlOptions htmlOptions) throws Exception {

        List<PageHtml> htmlPages = ViewerUtils.getViewerHtmlHandler().getPages(filePath, htmlOptions);
        temp_cssList = new ArrayList<String>();

        for (PageHtml page : htmlPages) {

            int indexOfBodyOpenTag = page.getHtmlContent().indexOf("<body>");

            if (indexOfBodyOpenTag > 0) {
                page.setHtmlContent(page.getHtmlContent().substring(indexOfBodyOpenTag + "<body>".length()));
            }

            int indexOfBodyCloseTag = page.getHtmlContent().indexOf("</body>");

            if (indexOfBodyCloseTag > 0) {
                page.setHtmlContent(page.getHtmlContent().substring(0, indexOfBodyCloseTag));
            }

            /////////////////////////

            List<HtmlResource> test = page.getHtmlResources();

            for (HtmlResource resource : page.getHtmlResources()) {

                if (resource.getResourceType() == HtmlResourceType.Style) {
                    InputStream cssStream = ViewerUtils.getViewerHtmlHandler().getResource(filePath, resource);
                    String text = IOUtils.toString(cssStream, "UTF-8");

                    boolean needResave = false;
                    if (text.indexOf("url(\"") >= 0 && text.indexOf("url(\"/GetResourceForHtml?documentPath=") < 0) {
                        needResave = true;
                        text = text.replace("url(\"", "url(\"/GetResourceForHtml?documentPath=" + filePath
                                + "&pageNumber=" + resource.getDocumentPageNumber() + "&resourceName=");
                    }

                    if (text.indexOf("url('") >= 0 && text.indexOf("url('/GetResourceForHtml?documentPath=") < 0) {
                        needResave = true;
                        text = text.replace("url('", String.format("url(\'/GetResourceForHtml?documentPath=" + filePath
                                + "&pageNumber=" + resource.getDocumentPageNumber() + "&resourceName="));
                    }

                    temp_cssList.add(text);

                    if (needResave) {

                        String fullPath = ViewerUtils.TEMP_PATH + filePath + "/" + "html" + "/" + "resources" + "/" + "page"
                                + page.getPageNumber() + "/" + resource.getResourceName();
                        File file = new File(fullPath);

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(text);
                        bw.close();

                    }
                }
                /////////////////////////
            }
            ArrayList<String> cssClasses = Utils.GetCssClasses(page.getHtmlContent());
            for (String cssClass : cssClasses) {
                String newCssClass = "page-" + page.getPageNumber() + "-" + cssClass;

                page.setHtmlContent(page.getHtmlContent().replace(cssClass, newCssClass));
                for (int i = 0; i < temp_cssList.size(); i++) {
                    temp_cssList.set(i, temp_cssList.get(i).replace(cssClass, newCssClass));
                }
            }
        }
        return htmlPages;

    }
}
