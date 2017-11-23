<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
  <%--  <link rel="stylesheet" href="<%=basePath%>asset/js/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />

    <link rel="stylesheet" href="<%=basePath%>asset/js/bootstrap-fileinput-master/css/fileinput.css"/>

    &lt;%&ndash;<link rel="stylesheet" href="<%=basePath%>asset/css/font-awesome.min.css" media="all"/>&ndash;%&gt;

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="<%=basePath%>asset/js/bootstrap-fileinput-master/themes/explorer-fa/theme.css"/>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="<%=basePath%>asset/js/jquery-3.2.1.min.js"></script>

    <script src="<%=basePath%>asset/js/bootstrap-fileinput-master/js/plugins/sortable.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/js/bootstrap-fileinput-master/js/fileinput.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/js/bootstrap-fileinput-master/js/locales/fr.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/js/bootstrap-fileinput-master/js/locales/es.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/js/bootstrap-fileinput-master/themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/js/bootstrap-fileinput-master/themes/fa/theme.js" type="text/javascript"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="<%=basePath%>asset/js/bootstrap-4.0.0-beta.2-dist/js/bootstrap.js"></script>

    <script src="<%=basePath%>asset/js/select2.min.js"></script>--%>

<script src="<%=basePath%>asset/js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath%>asset/js/jquery-1.10.2.min.js"></script>
<script src="<%=basePath%>asset/js/ace-extra.min.js"></script>
<script src="<%=basePath%>asset/js/html5shiv.js"></script>
<script src="<%=basePath%>asset/js/respond.min.js"></script>
<script src="<%=basePath%>asset/js/bootstrap.min.js"></script>
<script src="<%=basePath%>asset/js/typeahead-bs2.min.js"></script>
<script src="<%=basePath%>asset/js/excanvas.min.js"></script>
<script src="<%=basePath%>asset/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=basePath%>asset/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=basePath%>asset/js/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>asset/js/jquery.easy-pie-chart.min.js"></script>
<script src="<%=basePath%>asset/js/jquery.sparkline.min.js"></script>
<script src="<%=basePath%>asset/js/flot/jquery.flot.min.js"></script>
<script src="<%=basePath%>asset/js/flot/jquery.flot.pie.min.js"></script>
<script src="<%=basePath%>asset/js/flot/jquery.flot.resize.min.js"></script>
<script src="<%=basePath%>asset/js/ace-elements.min.js"></script>
<script src="<%=basePath%>asset/js/ace.min.js"></script>
<script src="<%=basePath%>asset/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=basePath%>asset/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="<%=basePath%>asset/js/jqGrid/i18n/grid.locale-en.js"></script>
<script src="<%=basePath%>asset/js/sys/sys.js" ></script>
<script src="<%=basePath%>asset/js/WdatePicker.js"></script>
<script src="<%=basePath%>asset/js/chosen.jquery.min.js"></script>
<script src="<%=basePath%>asset/js/select2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>asset/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>asset/js/layer/extend/layer.ext.js"></script>
<script type="text/javascript" src="<%=basePath%>asset/js/layer/mylayer.js"></script>
<script type="text/javascript" src="<%=basePath%>asset/js/validator/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="<%=basePath%>asset/js/validator/js/bootstrapValidator_zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>asset/js/validator/js/myBootstrapValidator.js"></script>
<script src="<%=basePath%>asset/js/jquery.serializejson.min.js"></script>
