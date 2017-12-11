<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/12
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/baseJsp.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a>ASdfdsasdfasdfasdfasdfasdfasdfasdfasjfdowenfa;osdfjiasodfiznxlkdcjfapoifjwaeakfn</a>
    <a>${user.userName}</a>
    <div id="msg" />
    <button type="button" id="test" value="测试" />
</body>
<script type="application/javascript">
    $("#test").click(function () {
        console.log("Adsd");
        $.post("/spring/json",{email:$('#email').val(),address:$('#address').val()},
            function(data){
                //$('#msg').html("please enter the email!");
                //alert(data);
                console.log(data)
                console.log(data.name)
                console.log(data.status)
                if(data.status == 'S'){
                    console.log("成功");
                }
                if(data.status1 == 'F'){
                    console.log("失败");
                }
            },"json");//这里返回的类型有：json,html,xml,text
    });

</script>
</html>
