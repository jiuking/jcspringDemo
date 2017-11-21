<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <link rel="stylesheet" href="<%=basePath%>asset/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />

    <link rel="stylesheet" href="<%=basePath%>asset/bootstrap-fileinput-master/css/fileinput.css"/>

    <%--<link rel="stylesheet" href="<%=basePath%>asset/css/font-awesome.min.css" media="all"/>--%>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="<%=basePath%>asset/bootstrap-fileinput-master/themes/explorer-fa/theme.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<%=basePath%>asset/css/jquery-ui.theme.min.css" />
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="<%=basePath%>asset/js/jquery-3.2.1.min.js"></script>

    <script src="<%=basePath%>asset/bootstrap-fileinput-master/js/plugins/sortable.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/bootstrap-fileinput-master/js/fileinput.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/bootstrap-fileinput-master/js/locales/fr.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/bootstrap-fileinput-master/js/locales/es.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/bootstrap-fileinput-master/themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="<%=basePath%>asset/bootstrap-fileinput-master/themes/fa/theme.js" type="text/javascript"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="<%=basePath%>asset/bootstrap-4.0.0-beta.2-dist/js/bootstrap.js"></script>

    <script type="text/javascript" src="<%=basePath%>asset/js/jquery-3.2.1.min.js"></script>

</head>
<body>

</body>
</html>
