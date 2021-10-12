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
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
</head>
<body>
<%--编辑弹出框--%>
<div class="site-text" style="margin: 5%; display: none" id="edit_window">
    <div class="layui-form" style="width: 400px;" lay-filter="editForm">
        <%--隐藏域，oid--%>
        <input type="hidden" id="oid" name="oid" class="layui-input" value="null">
        <!--学年-->
        <div class="layui-form-item">
            <label class="layui-form-label">学年</label>
            <div class="layui-input-block">
                <input type="text" id="year" name="year" value="" lay-verify="required" lay-reqtext="开课名不能为空" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <!--学期-->
        <div class="layui-form-item">
            <label class="layui-form-label">学期</label>
            <div class="layui-input-block">
                <input type="text" id="term" name="term" value="" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <%--班级--%>
        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
            <div class="layui-input-block">
                <select name="cid" id="edit_cid" lay-search="">
                    <option value="">请选择班级</option>
                </select>
            </div>
        </div>
        <%--教师--%>
        <div class="layui-form-item">
            <label class="layui-form-label">教师</label>
            <div class="layui-input-block">
                <select name="tid" id="edit_tid" lay-search="">
                    <option value="">请选择教师</option>
                </select>
            </div>
        </div>
        <%--课程--%>
        <div class="layui-form-item">
            <label class="layui-form-label">课程</label>
            <div class="layui-input-block">
                <select name="courseId" id="edit_courseId" lay-search="">
                    <option value="">请选择课程</option>
                </select>
            </div>
        </div>
        <!--备注-->
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" id="remark" name="remark" value="" placeholder="请输入" class="layui-input">
            </div>
        </div>

    </div>
</div>
<%--数据表格布局--%>
<div class="layuimini-container">
    <div class="layuimini-main">
        <%--搜索信息--%>
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="" lay-filter="searchForm">
                    <div class="layui-form-item">
                        <!--学年-->
                        <div class="layui-inline">
                            <label class="layui-form-label">学年</label>
                            <div class="layui-input-inline">
                                <input type="text" name="year" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <!--学期-->
                        <div class="layui-inline">
                            <label class="layui-form-label">学期</label>
                            <div class="layui-input-inline">
                                <input type="text" name="term" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 查询 </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
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
            url: 'openCourse/queryOpenCoursesByStudent.do',
            cols: [[
                {field: 'year', title: '学年'},
                {field: 'term', title: '学期'},
                {field: 'tname', title: '教师名'},
                {field: 'courseName', title: '课程名'},
                {field: 'remark', title: '备注'},
                {field: 'score', title: '分数'}
            ]],
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);

            //执行搜索重载
            table.reload('currentTableId', {
                url: 'openCourse/searchOpenCourses.do',
                where: {json:result},   //把json传过去
                page: {curr: 1}, //重新从第 1 页开始
                done: function (res) {
                    layer.msg("搜索到"+res.count+"个结果", {time:800});
                    return res;
                }
            });

            return false;   //不跳转
        });

    });
</script>

</body>
</html>