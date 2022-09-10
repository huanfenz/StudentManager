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
    <title>教室管理</title>
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
        <%--隐藏域，sid--%>
        <input type="hidden" id="rid" name="rid" class="layui-input" value="null">
        <!--教室名-->
        <div class="layui-form-item">
            <label class="layui-form-label">教室名</label>
            <div class="layui-input-block">
                <input type="text" id="rname" name="rname" value="" lay-verify="required" lay-reqtext="教室名不能为空" placeholder="请输入姓名" class="layui-input">
            </div>
        </div>
        <!--容量-->
        <div class="layui-form-item">
            <label class="layui-form-label">容量</label>
            <div class="layui-input-block">
                <input type="text" id="capacity" name="capacity" value="" placeholder="请输入容量" class="layui-input">
            </div>
        </div>
        <!--备注-->
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" id="remark" name="remark" value="" placeholder="请输入备注" class="layui-input">
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
                        <div class="layui-inline">
                            <label class="layui-form-label">教室名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="rname" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">容量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="capacity" autocomplete="off" class="layui-input">
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
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加教室 </button>
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
        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'room/queryRooms.do',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            cols: [[
                {type: "checkbox"},
                {field: 'rid', title: '序号', sort: true},
                {field: 'rname', title: '教室名'},
                {field: 'capacity', title: '容量'},
                {field: 'remark', title: '备注'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
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

            //执行搜索重载
            table.reload('currentTableId', {
                url: 'room/searchRooms.do',
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
                'rname':null,
                'capacity':null,
            });
            //执行搜索重载
            table.reload('currentTableId', {
                url: 'room/queryRooms.do',
                page: {curr: 1}, //重新从第 1 页开始
                done: null
            });

            return false;   //不跳转
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
                            "rid": null,
                            "rname": '崇1-301',
                            "capacity": '70',
                            "remark": '普通教室',
                        });
                    },
                    yes: function(index,layero){ //确认的回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');
                        //向服务器请求
                        $.getJSON({
                            url: 'room/addRoom.do',
                            data: {json:JSON.stringify(mdata)},    //发json
                            success:function (res) {
                                layer.msg("添加"+res+"行成功！",{time:800});
                                //获得最后一页的页码并重载
                                $.getJSON({
                                    url: 'room/getAmount.do',
                                    success: function (res) {
                                        //数据长度
                                        var len = res;
                                        //每页大小
                                        var size = $('.layui-laypage-limits').find('select').val();
                                        //页码: 上取整（len/size）
                                        var pageNum = Math.ceil(len / size);
                                        //重载页面
                                        table.reload('currentTableId',{page : {curr : pageNum}});
                                    }
                                });
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
                        url: 'room/deleteRooms.do',
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
                            "rid": mdata.rid,
                            "rname": mdata.rname,
                            "capacity": mdata.capacity,
                            "remark": mdata.remark,
                        });
                    },
                    yes: function () {  //确认回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');   //获取表单的数据
                        $.getJSON({
                            url: 'room/updateRoom.do',
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
                        url: 'room/deleteRooms.do',
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