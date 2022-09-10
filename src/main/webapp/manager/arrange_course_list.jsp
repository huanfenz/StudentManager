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
    <title>排课管理</title>
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
        <%--隐藏域，ctid--%>
        <input type="hidden" id="ctid" name="ctid" class="layui-input" value="null">
        <%--隐藏域，oid--%>
        <input type="hidden" id="oid" name="oid" class="layui-input" value="${param.oid}">
        <%--教室--%>
        <div class="layui-form-item">
            <label class="layui-form-label">教室</label>
            <div class="layui-input-block">
                <select name="rid" id="edit_rid" lay-search="">
                    <option value="">请选择教室</option>
                </select>
            </div>
        </div>
        <!--周数-->
        <div class="layui-form-item">
            <label class="layui-form-label">周数</label>
            <div class="layui-input-block">
                <input type="text" id="weekno" name="weekno" value="" lay-verify="required" lay-reqtext="不能为空" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <!--星期-->
        <div class="layui-form-item">
            <label class="layui-form-label">星期</label>
            <div class="layui-input-block">
                <input type="text" id="week" name="week" value="" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <!--开始节数-->
        <div class="layui-form-item">
            <label class="layui-form-label">开始节数</label>
            <div class="layui-input-block">
                <input type="text" id="start" name="start" value="" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <!--课长-->
        <div class="layui-form-item">
            <label class="layui-form-label">课长</label>
            <div class="layui-input-block">
                <input type="text" id="size" name="size" value="" placeholder="请输入" class="layui-input">
            </div>
        </div>
    </div>
</div>
<%--数据表格布局--%>
<div class="layuimini-container">
    <div class="layuimini-main">
        <%--头部工具栏--%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加课表 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除选中行 </button>
            </div>
        </script>
        <%--表格容器--%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <%--行工具栏--%>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>
<%--js代码--%>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery, form = layui.form, table = layui.table;

        $(function () {
            $.getJSON({
                url: 'room/queryAllRooms.do',
                success: function (data) {
                    $("#edit_rid").html();
                    $.each(data,function (i,n) {
                        $("#edit_rid")
                            .append("<option value=\""+n.rid+"\">"+n.rname+"</option>")
                    });
                    form.render('select','editForm'); //刷新select选择框渲染
                }
            });
        });

        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'arrangeCourse/queryArrangeCoursesByOid.do?oid=' + ${param.oid},
            toolbar: '#toolbarDemo',
            defaultToolbar: null,
            cols: [[
                {type: "checkbox"},
                /*{field: 'ctid', title: '序号', sort: true},*/
                /*{field: 'oid', title: '开课id'},*/
                {field: 'rname', title: '教室'},
                {field: 'weekno', title: '周数',minWidth: 300},
                {field: 'week', title: '星期'},
                {field: 'start', title: '开始节数'},
                {field: 'size', title: '课长'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
        });

        //toolbar监听事件
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                layer.open({
                    title:"新增",
                    type: 1,
                    maxmin:true,
                    shadeClose: true,
                    area:['500px','450px'],
                    btn: ['确定', '取消'],
                    content: $("#edit_window"),
                    success: function () {  //弹出框成功回调
                        //给表单赋值
                        form.val("editForm", {
                            "ctid": null,
                            "oid": ${param.oid},
                            "rid": 5,
                            "weekno": '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16',
                            "week": 1,
                            "start": 1,
                            "size": 2
                        });
                    },
                    yes: function(index,layero){ //确认的回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');
                        //向服务器请求
                        $.getJSON({
                            url: 'arrangeCourse/addArrangeCourse.do',
                            data: {json:JSON.stringify(mdata)},    //发json
                            success:function (res) {
                                layer.msg("添加"+res+"行成功！",{time:800});
                                //重载表格
                                table.reload('currentTableId',{page : 1});
                            }
                        });
                    }
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                layer.confirm('确定要删除选中行吗？', function(index){
                    var checkStatus = table.checkStatus('currentTableId')
                        , data = checkStatus.data;
                    layer.close(index); //关闭提示框
                    //向服务器请求
                    $.getJSON({
                        url: 'arrangeCourse/deleteArrangeCourses.do',
                        data: {json:JSON.stringify(data)},   //发json过去
                        success:function (res) {
                            layer.msg("删除"+res+"行成功！",{time:800});
                            //重载表格
                            table.reload('currentTableId',{page:{curr:1}});
                        }
                    });
                });
            }
        });

        table.on('tool(currentTableFilter)', function (obj) {
            if (obj.event === 'edit') { //监听编辑按钮
                var index = layer.open({
                    title: '编辑用户',
                    type: 1,    //界面层
                    maxmin:true,
                    shadeClose: true,
                    area: ['500px', '450px'],
                    btn: ['确定', '取消'],
                    content: $("#edit_window"),
                    success: function () {
                        var mdata = obj.data;   //获取该行的数据
                        //给表单赋值
                        form.val("editForm", {
                            "ctid": mdata.ctid,
                            "oid": mdata.oid,
                            "rid": mdata.rid,
                            "weekno": mdata.weekno,
                            "week": mdata.week,
                            "start": mdata.start,
                            "size": mdata.size
                        });
                    },
                    yes: function () {  //确认回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');   //获取表单的数据
                        $.getJSON({
                            url: 'arrangeCourse/updateArrangeCourse.do',
                            data: {json:JSON.stringify(mdata)},   //发json过去
                            success:function (res) {
                                layer.msg("修改"+res+"行成功!",{time:800});
                                //重载表格
                                table.reload('currentTableId');
                            }
                        });
                    }
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {    //监听删除按钮
                layer.confirm('确定要删除该行吗？', function (index) {
                    var mdata = obj.data;    //获取该行的数据
                    obj.del();  //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index); //关闭窗口
                    //向服务器请求
                    $.getJSON({
                        url: 'arrangeCourse/deleteArrangeCourses.do',
                        data: {json:JSON.stringify(mdata)},   //发json过去
                        success:function (res) {
                            layer.msg("删除"+res+"行成功！",{time:800});
                        }
                    });
                });
            }
        });

    });
</script>

</body>
</html>