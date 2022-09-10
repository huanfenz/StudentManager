<%@ page contentType="text/html;charset=UTF-8" language="java" %>   <%--jsp--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <%--jstl--%>
<%
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>  <%--取base--%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>" />
    <meta charset="utf-8">
    <title>学生分数</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
</head>
<body>
<%--数据表格布局--%>
<div class="layuimini-container">
    <div class="layuimini-main">
        <%--表格容器--%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
    </div>
</div>
<%--js代码--%>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery, form = layui.form, table = layui.table;

        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'openCourse/student/queryOpenCoursesByStudent.do',
            cols: [[
                {field: 'year', title: '学年'},
                {field: 'term', title: '学期'},
                {field: 'tname', title: '教师名'},
                {field: 'courseName', title: '课程名'},
                {field: 'remark', title: '备注'},
                {field: 'score', title: '分数'}
            ]],
        });

    });
</script>

</body>
</html>