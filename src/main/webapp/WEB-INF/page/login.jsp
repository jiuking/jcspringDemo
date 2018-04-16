<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/24 0024
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/baseJsp.jsp" %>
    <%@include file="/common/commonCSS.jsp" %>
    <title>Login</title>
    <style>
        body{
            margin-left:auto;
            margin-right:auto;
            margin-TOP:100PX;
            width:20em;
        }
    </style>
</head>
<body>
<form action="enter" method="post">
<div class="input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input id="username" name="username" type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
</div>
<br>
<!--下面是密码输入框-->
<div class="input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input id="password" name="password" type="password" class="form-control" placeholder="密码Test" aria-describedby="basic-addon1">
</div>
<br>
<!--下面是登陆按钮,包括颜色控制-->
<button style="width:280px;" id="login" class="btn btn-default">登 录</button>
</form>
</body>
<script type="text/javascript">
    $("#login1").click(function () {
        console.log($("#username").val())
        var data = {username:$("#username").val(),password:$("#password").val()};
        console.log(data)
        $.ajax({
            type:"post",
            url:"enter",
            data:data,
            success:function (data) {
                $('#body').html(data)
            }
        });
    })
</script>
</html>
