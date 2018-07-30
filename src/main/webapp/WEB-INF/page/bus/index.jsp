<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30 0030
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/baseJsp.jsp" %>
    <%@include file="/common/commonCSS.jsp" %>
    <title>Title</title>
</head>
<body>
<div class="text-center ">
<form class="form-horizontal" id="busInfo" action="<%=basePath%>/bus/current/info/concrete" method="POST">
    <fieldset>
        <div id="legend" class="">
            <legend class="">表单名</legend>
        </div>
        <div class="control-group">
            <!-- Text input-->
            <label class="input-label" for="busNo">公交路线：</label>
            <input id="busNo" name="busNo" type="text" placeholder="placeholder" class="input-xlarge">
        </div>
        <div class="control-group">
            <!-- Select Basic -->
            <label class="select-label">方向：</label>
            <div>
                <select id="lineType" name="lineType" class="input-large">
                    <option value="1">正向</option>
                    <option value="2">反向</option>
                    <option value="3">循环</option>
                </select>
            </div>

        </div>
        <div class="control-group">
            <label class="control-label">查询</label>

            <!-- Button -->
            <div class="submit">
                <button type="submit" class="btn btn-success">查询</button>
            </div>
        </div>


    </fieldset>
</form>

</div>
</body>
</html>
