<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <%@include file="/common/baseJsp.jsp" %>
    <%@include file="/common/commonCSS.jsp" %>
    <link href="<%=basePath%>/asset/css/bootstrap-table.css"/>
    <link href="<%=basePath%>/asset/js/bootstrap3-editable/css/bootstrap-editable.css"/>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <script src="<%=basePath%>/asset/js/bootstrap-table.min.js"></script>
    <script src="<%=basePath%>/asset/js/bootstrap3-editable/js/bootstrap-editable.js"> </script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/editable/bootstrap-table-editable.min.js" > </script>
    <link href="<%=basePath%>/asset/css/viewer.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=basePath%>/asset/js/uploadify/uploadify.css"/>
    <link rel="stylesheet" href="<%=basePath%>/asset/css/colorbox.css"/>
    <script src="<%=basePath%>/asset/js/viewer-jquery.min.js"></script>
    <script src="<%=basePath%>/asset/js/viewer.min.js"></script>

    <title>Title</title>
</head>
<body>
    <div class="container-fluid">
        <form class="form-horizontal">
            <div class="form-group">

            </div>
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">名字</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="firstname"
                           placeholder="请输入名字">
                </div>
                <label for="lastname" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="lastname"
                           placeholder="请输入姓名">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-9 col-sm-8">
                    <button type="submit" class="btn btn-default">搜索</button>
                </div>
            </div>
        </form>
        <table id="otherContactsTable" class="table table-bordered table-hover"/>
    </div>
</body>
<script type="text/javascript">
    $(function () {


    $("#otherContactsTable").bootstrapTable({
        //初始化表格
        method: 'get',
        url:"listTable",
        editable:true,//开启编辑模式
        clickToSelect: true,
        cache: false,
        toolbar: '#toolbar',
        pagination: true,
        pageNumber: 1,                 //初始化加载第一页，默认第一页
//        queryParams: oTableInit.queryParams,//传递参数（*）
        queryParams:queryParams,
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        columns: [
            [
                {checkbox: true,field:"ids"},
                {field:"index",title:"序号",align:"center",edit:false,formatter:function(value, row, index){
                    return row.index=index ; //返回行号
                }
                },
                {field:"cooperativeNo",title:"合医证号",align:"center"},
                {field:"name",title:"姓名",align:"center",editable:true},
                {field:"gender",title:"性别",align:"center",formatter:function(value, row, index){
                    if (value == 0)
                        return '女'
                    return '男'
                }},
                {field:"age",title:"年龄",align:"center",editable:true},
                {field:"address",title:"地址",align:"center"},
                {field:"visitorDate",title:"就诊时间",align:"center"},
                {field:"invoiceNo",title:"发票号码",align:"center"},
                {field:"compensateAmount",title:"补偿金额",align:"center"}
            ]
        ]
    });
    })
    function queryParams(params){
        return params
    }

</script>
</html>
