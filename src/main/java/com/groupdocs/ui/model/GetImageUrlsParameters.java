package com.groupdocs.ui.model;

public class GetImageUrlsParameters extends WatermarkedDocumentParameters {
	public Integer width = null;
	public int firstPage;
	public Integer pageCount = null;
	public Integer quality = null;
	public Boolean usePdf;
	public Boolean ignoreDocumentAbsence;
	public Boolean useHtmlBasedEngine;
	public Boolean supportPageRotation;
	public String instanceIdToken;
	public String locale;
	public String callBack;
	private String userId;
	private String privateKey;
	private String docVersion;

	public String getDocVersion() {
		return docVersion;
	}

	public void setDocVersion(String docVersion) {
		this.docVersion = docVersion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public int getFirstPage() {
		return firstPage;

	}

	public void serFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Boolean getUsePdf() {
		return usePdf;

	}

	public void setUsePdf(Boolean usePdf) {
		this.usePdf = usePdf;

	}
	////////////

	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

	public String getCallBack() {
		return callBack;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLocale() {
		return locale;
	}

	public void setInstanceIdToken(String instanceIdToken) {
		this.instanceIdToken = instanceIdToken;
	}

	public String getInstanceIdToken() {
		return instanceIdToken;
	}

	public void setSupportPageRotation(Boolean supportPageRotation) {
		this.supportPageRotation = supportPageRotation;
	}

	public Boolean getSupportPageRotation() {
		return supportPageRotation;
	}

	public void setUseHtmlBasedEngine(Boolean useHtmlBasedEngine) {
		this.useHtmlBasedEngine = useHtmlBasedEngine;
	}

	public Boolean getUseHtmlBasedEngine() {
		if(useHtmlBasedEngine == null)
			return false;
		return useHtmlBasedEngine;
	}

	public void setIgnoreDocumentAbsence(Boolean ignoreDocumentAbsence) {
		this.ignoreDocumentAbsence = ignoreDocumentAbsence;
	}

	public Boolean getIgnoreDocumentAbsence() {
		return false;
	}

}