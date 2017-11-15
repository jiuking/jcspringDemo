<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/14 0014
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=basePath%>asset/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="<%=basePath%>asset/js/jquery-3.2.1.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="<%=basePath%>asset/bootstrap-4.0.0-beta.2-dist/js/bootstrap.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Welcome, this is SpringMVC Bootstrap WebApp</h1>
</div>
</body>
</html>
