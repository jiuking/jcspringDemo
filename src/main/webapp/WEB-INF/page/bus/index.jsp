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

<form class="form-horizontal" action="/bus/current/info/concrete">
    <fieldset>
        <div id="legend" class="">
            <legend class="">表单名</legend>
        </div>
        <div class="control-group">

            <!-- Text input-->
            <label id="busNo" class="control-label" for="busNo">公交路线：</label>
            <div class="controls">
                <input type="text" placeholder="placeholder" class="input-xlarge">
                <p class="help-block">Supporting help text</p>
            </div>
        </div>
        <div class="control-group">

            <!-- Select Basic -->
            <label class="control-label">方向：</label>
            <div class="lineType">
                <select class="input-xlarge">
                    <option value="1">正向</option>
                    <option value="2">反向</option>
                    <option value="3">循环</option>
                </select>
            </div>

        </div>
        <div class="control-group">
            <label class="control-label">查询</label>

            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">查询</button>
            </div>
        </div>


    </fieldset>
</form>


</body>
</html>
