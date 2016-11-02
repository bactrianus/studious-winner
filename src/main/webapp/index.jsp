<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GroupDocs.Annotation for Java</title>

    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"/>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/turn.js/3/turn.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.min.css"/>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type='text/javascript' src='//ajax.aspnetcdn.com/ajax/signalr/jquery.signalr-2.2.1.min.js'></script>

    <script type='text/javascript' src='js/installableViewer.js'></script>
    <script type='text/javascript'>$.ui.groupdocsViewer.prototype.applicationPath = '';</script>
    <script type='text/javascript'>$.ui.groupdocsViewer.prototype.useHttpHandlers = false;</script>
    <script type='text/javascript' src='js/libs/GroupdocsViewer.all.js'></script>
    <script type='text/javascript' src='js/libs/jquery.tinyscrollbar.min.js'></script>
    <script type='text/javascript' src='js/libs/jquery.custom-scrollbar.js'></script>
    <script type='text/javascript' src='js/libs/jquery.ui.touch-punch.min.js'></script>
    <script type='text/javascript' src='js/libs/mousetrap.js'></script>
    <script type='text/javascript' src='js/RaphaelJS/raphael-min.js'></script>
    <script type='text/javascript' src='js/jGroupDocs.Undo.js'></script>
    <script type='text/javascript' src='js/jGroupDocs.Utils.js'></script>
    <script type='text/javascript' src='js/jGroupDocs.Printable.js'></script>
    <script type='text/javascript' src='js/AnnotationService.js'></script>
    <script type='text/javascript' src='js/AnnotationCommands.js'></script>
    <script type='text/javascript' src='js/Annotation2Legacy.js'></script>
    <script type='text/javascript' src='js/AreaAnnotation.js'></script>
    <script type='text/javascript' src='js/PointAnnotation.js'></script>
    <script type='text/javascript' src='js/TextStrikeout.js'></script>
    <script type='text/javascript' src='js/PolylineAnnotation.js'></script>
    <script type='text/javascript' src='js/TextStrikeout.js'></script>
    <script type='text/javascript' src='js/TextField.js'></script>
    <script type='text/javascript' src='js/Watermark.js'></script>
    <script type='text/javascript' src='js/TextReplacement.js'></script>
    <script type='text/javascript' src='js/TextRedaction.js'></script>
    <script type='text/javascript' src='js/GraphicsAnnotation.js'></script>
    <script type='text/javascript' src='js/MeasurementAnnotation.js'></script>
    <script type='text/javascript' src='js/AnnotationWidget.js'></script>
    <script type='text/javascript' src='js/AnnotationInitControls.js'></script>
    <link rel="stylesheet" type="text/css" href="css/Annotation.css" />
    <link rel="stylesheet" type="text/css" href="css/Annotation.Toolbox.css" />
    <link rel="stylesheet" type="text/css" href="css/groupdocsViewer.all.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.dialog.min.css" />
    <script type='text/javascript'>
        var container = window.Container || new JsInject.Container();
        container.Register('PathProvider', function (c) { return jSaaspose.utils; }, true);
        window.Container = container;
    </script>

    <style>
        html, body, #annotation-widget {
            width: 100%;
            height: 100%;
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#annotation-widget').groupdocsAnnotation({
                localizedStrings: null, width: 0,
                height: 0,
                fileId: 'demo.docx',
                docViewerId: 'annotation-widget-doc-viewer',
                quality: 90,
                enableRightClickMenu: true,
                showHeader: true,
                showZoom: true,
                showPaging: true,
                showFileExplorer: true,
                showThumbnails: true,
                showToolbar: true,
                openThumbnails: false,
                zoomToFitWidth: false,
                zoomToFitHeight: false,
                initialZoom: 100,
                preloadPagesCount: 3,
                enableSidePanel: true,
                scrollOnFocus: true,
                enabledTools: 8191,
                connectorPosition: 0,
                saveReplyOnFocusLoss: false,
                clickableAnnotations: true,
                disconnectUncommented: false,
                enableStandardErrorHandling: true,
                undoEnabled: true,
                anyToolSelection: true,
                tabNavigationEnabled: false,
                tooltipsEnabled: true,
                textSelectionEnabled: false,
                textSelectionByCharModeEnabled: false,
                toolDeactivationMode: 0,
                sideboarContainerSelector: 'div.comments_sidebar_wrapper',
                usePageNumberInUrlHash: false,
                textSelectionSynchronousCalculation: true,
                variableHeightPageSupport: true,
                useJavaScriptDocumentDescription: true,
                isRightPanelEnabled: true,
                createMarkup: true,
                use_pdf: 'true',
                _mode: 'annotatedDocument',
                selectionContainerSelector: "[name='selection-content']",

                graphicsContainerSelector: '.annotationsContainer',

                searchForSeparateWords: false,
                userName: 'GroupDocs@GroupDocs.com', userId: '52ced024-26e0-4b59-a510-ca8f5368e315'

            });
        });
    </script>
</head>
<body>

<div id="annotation-widget" class="GroupDocs_viewer_wrapper grpdx"></div>

</body>
</html>
