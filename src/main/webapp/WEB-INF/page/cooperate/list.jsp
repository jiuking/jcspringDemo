<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/common/baseJsp.jsp" %>
    <link href="<%=basePath%>/asset/css/bootstrap-table.css"/>
    <link href="<%=basePath%>/asset/js/bootstrap3-editable/css/bootstrap-editable.css"/>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"/>
    <script src="<%=basePath%>/asset/js/bootstrap3-editable/js/bootstrap-editable.js"/>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/editable/bootstrap-table-editable.min.js" />
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.js"></script>
    <script src="<%=basePath%>/asset/js/bootstrap-table.min.js"></script>
    <link href="<%=basePath%>/asset/css/viewer.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=basePath%>/asset/js/uploadify/uploadify.css"/>
    <link rel="stylesheet" href="<%=basePath%>/asset/css/colorbox.css"/>
    <script src="<%=basePath%>/asset/js/viewer-jquery.min.js"></script>
    <script src="<%=basePath%>/asset/js/viewer.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>

    <title>Title</title>
</head>
<body>
    <div class="container-fluid">
        <table id="otherContactsTable" class="table table-bordered table-hover"/>
    </div>
</body>
<script type="text/javascript">
    $("#otherContactsTable").bootstrapTable({
        //初始化表格
        method: 'get',
        url:"listTable",
        toolbar: '#toolbar',
        editable:true,//开启编辑模式
        clickToSelect: true,
        cache: false,
        showPaginationSwitch:true, //显示分页切换按钮
        pagination: true,
        pageList: [10,25,50,100],
        pageSize:10,
        pageNumber:1,
        striped: true,
        showRefresh: true,
        minimumCountColumns: 2,
        smartDisplay:true,
        columns: [
            [
                {field:"cooperativeNo",title:"合医证号",align:"center"},
                {field:"name",title:"姓名",align:"center"},
                {field:"gender",title:"性别",align:"center",formatter:function(value, row, index){
                    if (value == 0)
                        return '女'
                    return '男'
                }},
                {field:"age",title:"年龄",align:"center"},
                {field:"address",title:"地址",align:"center"},
                {field:"visitorDate",title:"就诊时间",align:"center"},
                {field:"invoiceNo",title:"发票号码",align:"center"},
                {field:"compensateAmount",title:"补偿金额",align:"center"}
            ]
        ]
    });

</script>
</html>
