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
    <title>教师开课</title>
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
        <%--头部工具栏--%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm layui-btn-warm data-plan-btn" lay-event="plan"> 查看排课 </button>
                <button class="layui-btn layui-btn-sm layui-btn-normal data-plan-btn" lay-event="score"> 录入成绩 </button>
            </div>
        </script>
        <%--表格容器--%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
    </div>
</div>
<%--js代码--%>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery, form = layui.form, table = layui.table;

        $(function () {
            //获取所有的班级、教师、课程信息
            $.getJSON({
                url: 'clazz/teacher/queryAllClazzsByTeacher.do',
                success: function (data) {
                    $("#search_cid").html();
                    $.each(data,function (i,n) {
                        $("#search_cid")
                            .append("<option value=\""+n.cid+"\">"+n.cname+"</option>")
                    });
                    $("#edit_cid").html();
                    $.each(data,function (i,n) {
                        $("#edit_cid")
                            .append("<option value=\""+n.cid+"\">"+n.cname+"</option>")
                    });
                    form.render('select','searchForm'); //刷新select选择框渲染
                    form.render('select','editForm'); //刷新select选择框渲染
                }
            });
            $.getJSON({
                url: 'course/teacher/queryAllCoursesByTeacher.do',
                success: function (data) {
                    $("#search_courseId").html();
                    $.each(data,function (i,n) {
                        $("#search_courseId")
                            .append("<option value=\""+n.courseId+"\">"+n.courseName+"</option>")
                    });
                    $("#edit_courseId").html();
                    $.each(data,function (i,n) {
                        $("#edit_courseId")
                            .append("<option value=\""+n.courseId+"\">"+n.courseName+"</option>")
                    });
                    form.render('select','searchForm'); //刷新select选择框渲染
                    form.render('select','editForm'); //刷新select选择框渲染
                }
            });
        });

        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'openCourse/teacher/queryOpenCoursesByTeacher.do',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox"},
                {field: 'oid', title: '序号', sort: true},
                {field: 'year', title: '学年'},
                {field: 'term', title: '学期'},
                {field: 'cname', title: '班级名'},
                {field: 'tname', title: '教师名'},
                {field: 'remark', title: '备注'},
                {field: 'courseName', title: '课程名'}
            ]],
            limits: [5, 10, 15, 20, 25, 50, 100],
            limit: 10,
            page: {
                prev: '上一页',
                next: '下一页',
            },
        });

        //toolbar监听事件
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'plan') {  //监听查看排课操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;

                console.log(data);
                if(data.length !== 1) {
                    layer.msg("请选择一行记录！",{time:1000});
                    return false;
                }

                layer.open({
                    title: "查看排课",
                    type: 2,    //iframe
                    maxmin: true,
                    shadeClose: true,
                    area: ['90%', '90%'],
                    btn: ['确定'],
                    content: 'teacher/teacher_arrange_course_list.jsp?oid=' + data[0].oid,
                    yes: function (index, layero) { //确认的回调
                        layer.close(index); //关闭弹出框
                    }
                })
            } else if(obj.event === 'score') {
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                console.log(data);
                if(data.length !== 1) {
                    layer.msg("请选择一行记录！",{time:1000});
                    return false;
                }
                layer.open({
                    title: "录入成绩",
                    type: 2,    //iframe
                    maxmin: true,
                    shadeClose: true,
                    area: ['500px', '90%'],
                    content: 'teacher/teacher_score.jsp?oid=' + data[0].oid,
                })
            }
        });
    });
</script>

</body>
</html>