<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/common/baseJsp.jsp" %>
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>合医证号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>地址</th>
        <th>就诊时间</th>
        <th>发票号码</th>
        <th>补偿金额</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.result}" var="cooperate" varStatus="i">
            <td>${cooperate.cooperativeNo}</td>
            <td>${cooperate.name}</td>
            <td>${cooperate.gender}</td>
            <td>${cooperate.age}</td>
            <td>${cooperate.address}</td>
            <td>${cooperate.visitorDate}</td>
            <td></td>
            <td>${cooperate.compensateAmount}</td>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
