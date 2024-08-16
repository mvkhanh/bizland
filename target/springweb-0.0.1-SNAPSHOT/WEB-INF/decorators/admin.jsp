<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title><sitemesh:write property="title"/></title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <script src="../../static/assets/js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
</head>
<body class="no-skin">
    <%@include file="../../common/admin/header.jsp"%>
    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
            try{ace.settings.loadState('main-container')}catch(e){}
        </script>
        <%@include file="../../common/admin/menu.jsp"%>
        <div class="main-content" style="font-family: 'Times New Roman', Times, serif;">
            <sitemesh:write property="body"/>
        </div>

        <%@include file="../../common/admin/footer.jsp"%>
    </div>

    <!-- basic scripts -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../../static/assets/js/alert.js"></script>
<%--    --------%>
    <script src="../../static/assets/js/bootstrap.min.js"></script>

    <!-- page specific plugin scripts -->

    <script src="../../static/assets/js/jquery-ui.custom.min.js"></script>
    <script src="../../static/assets/js/jquery.ui.touch-punch.min.js"></script>
    <script src="../../static/assets/js/jquery.easypiechart.min.js"></script>
    <script src="../../static/assets/js/jquery.sparkline.index.min.js"></script>
    <script src="../../static/assets/js/jquery.flot.min.js"></script>
    <script src="../../static/assets/js/jquery.flot.pie.min.js"></script>
    <script src="../../static/assets/js/jquery.flot.resize.min.js"></script>

    <!-- ace scripts -->
    <script src="../../static/assets/js/ace-elements.min.js"></script>
    <script src="../../static/assets/js/ace.min.js"></script>

    <!-- inline scripts related to this page -->


    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="../../static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../static/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="../../static/assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="../../static/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <link rel="stylesheet" href="../../static/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="../../static/assets/css/ace-rtl.min.css" />

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="../../static/assets/js/ace-extra.min.js"></script>
</body>
</html>
