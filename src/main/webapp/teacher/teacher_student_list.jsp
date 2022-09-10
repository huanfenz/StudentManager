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
    <title>学生列表</title>
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
        <%--搜索信息--%>
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="" lay-filter="searchForm">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sname" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">学号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="snum" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">所属班级</label>
                            <div class="layui-input-inline">
                                <select name="cid" id="search_cid" lay-search="">
                                    <option value="">请选择所属班级</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜　　索 </button>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-all-btn"><i class="layui-icon"></i> 显示全部 </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
        <%--头部工具栏--%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm layui-btn-normal data-plan-btn" lay-event="seeInfo"> 查看学生信息 </button>
            </div>
        </script>
        <%--表格容器--%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
    </div>
</div>
<%--js代码--%>
<script>
    layui.use(['form', 'table','laydate'], function () {
        var $ = layui.jquery, form = layui.form, table = layui.table, date=layui.laydate;

        $(function () {
            //获取所有的班级信息
            $.getJSON({
                url: 'clazz/teacher/queryAllClazzsByTeacher.do',
                success: function (data) {
                    $("#search_cid").html();
                    $.each(data,function (i,n) {
                        $("#search_cid")
                            .append("<option value=\""+n.cid+"\">"+n.cname+"</option>")
                    });
                    form.render('select','searchForm'); //刷新select选择框渲染
                    $("#edit_cid").html();
                    $.each(data,function (i,n) {
                        $("#edit_cid")
                            .append("<option value=\""+n.cid+"\">"+n.cname+"</option>")
                    });
                    form.render('select','editForm'); //刷新select选择框渲染
                }
            });
        });

        date.render({
            elem: '#entime'
        });

        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'student/teacher/queryStudentsByTeacher.do',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips',
            }],
            cols: [[
                {type: "checkbox"},
                {field: 'sid', title: '序号', sort: true},
                {field: 'sname', title: '姓名'},
                {field: 'snum', title: '学号', sort: true},
                {field: 'ssex', title: '性别'},
                {field: 'sage', title: '年龄', sort: true},
                {field: 'cname', title: '所属班级'},
                {field: 'sstatus', title: '状态'},
                {field: 'sremark', title: '备注'},
            ]],
            limits: [5, 10, 15, 20, 25, 50, 100],
            limit: 10,
            page: {
                prev: '上一页',
                next: '下一页',
            },
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            console.log(result);
            //执行搜索重载
            table.reload('currentTableId', {
                url: 'student/teacher/searchStudentsByTeacher.do',
                where: {json:result},   //把json传过去
                page: {curr: 1}, //重新从第 1 页开始
                done: function (res) {
                    layer.msg("搜索到"+res.count+"个结果", {time:800});
                    return res;
                }
            });

            return false;   //不跳转
        });

        // 监听显示全部操作
        form.on('submit(data-all-btn)', function (data) {
            form.val("searchForm", {
                'sname':null,
                'snum':null,
                'cid':null
            });
            //执行搜索重载
            table.reload('currentTableId', {
                url: 'student/teacher/queryStudentsByTeacher.do',
                page: {curr: 1}, //重新从第 1 页开始
                done: null
            });

            return false;   //不跳转
        });

        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'seeInfo') {  //监听查看信息操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;

                console.log(data);
                if (data.length != 1) {
                    layer.msg("请选择一行记录！", {time: 1000});
                    return false;
                }

                layer.open({
                    title: "查看学生信息",
                    type: 2,    //iframe
                    maxmin: true,
                    shadeClose: true,
                    area: ['90%', '90%'],
                    btn: ['确定'],
                    content: 'teacher/teacher_student_information.jsp?sid=' + data[0].sid,
                    yes: function (index, layero) { //确认的回调
                        layer.close(index); //关闭弹出框
                    }
                })
            }
        });


    });
</script>

</body>
</html>
