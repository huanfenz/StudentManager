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
    <title>审批管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
</head>
<body>
<div class="site-text" style="margin: 5%; display: none" id="edit_window">
    <div class="layui-form" style="width: 400px;" lay-filter="editForm">
        <%--隐藏域，aid--%>
        <input type="hidden" id="aid" name="aid" class="layui-input" value="null">
        <%--隐藏域，sid--%>
        <input type="hidden" id="sid" name="sid" class="layui-input" value="null">
        <%--隐藏域，title--%>
        <input type="hidden" id="title" name="title" class="layui-input" value="null">
        <%--隐藏域，reason--%>
        <input type="hidden" id="reason" name="reason" class="layui-input" value="null">
        <%--隐藏域，type--%>
        <input type="hidden" id="type" name="type" class="layui-input" value="null">
        <%--隐藏域，sDate--%>
        <input type="hidden" id="sDate" name="sDate" class="layui-input" value="null">
        <%--隐藏域，eDate--%>
        <input type="hidden" id="eDate" name="eDate" class="layui-input" value="null">
        <%--隐藏域，attName--%>
        <input type="hidden" id="attName" name="attName" class="layui-input" value="null">
        <%--隐藏域，att--%>
        <input type="hidden" id="att" name="att" class="layui-input" value="null">

        <!--状态-->
        <div class="layui-form-item">
            <label class="layui-form-label">选择</label>
            <div class="layui-input-block">
                <select name="status" id="edit_cid" lay-search="">
                    <option value="审批通过">审批通过</option>
                    <option value="审批驳回">审批驳回</option>
                </select>
            </div>
        </div>
        <%--回复--%>
        <div class="layui-form-item">
            <label class="layui-form-label">回复</label>
            <div class="layui-input-block">
                <textarea id="msg" name="msg" lay-verify="required" lay-reqtext="回复不能为空" placeholder="请输入回复" class="layui-textarea"></textarea>
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
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="dispose"> 处理审批 </button>
                <button class="layui-btn layui-btn-danger layui-btn-sm data-add-btn" lay-event="delete"> 删除审批 </button>
            </div>
        </script>
        <%--表格容器--%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
    </div>
</div>
<%--js代码--%>
<%--自定义数据表格模板：url--%>
<script type="text/html" id="urlTpl">
    <a href="{{d.att}}" class="layui-table-link" target="_blank">{{ d.attName }}</a>
</script>

<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery, form = layui.form, table = layui.table;
        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'approval/queryApprovals.do',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            cols: [[
                {type: "checkbox"},
                {field: 'aid', title: '序号', sort: true},
                {field: 'sname', title: '学生姓名'},
                {field: 'title', title: '标题'},
                {field: 'reason', width: 200, title: '原因'},
                {field: 'type', title: '类型'},
                {field: 'sDate', title: '开始日期', sort: true},
                {field: 'eDate', title: '结束日期', sort: true},
                {field: 'attName', title: '附件(点击打开)',templet: '#urlTpl' },
                {field: 'status', title: '审批情况', sort: true},
                {field: 'msg', title: '回复'},
            ]],
            initSort: {
                field: 'status' //排序字段，对应 cols 设定的各字段名
                ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            },
            limits: [5, 10, 15, 20, 25, 50, 100],
            limit: 10,
            page: {
                prev: '上一页',
                next: '下一页',
            },
            skin: 'line'
        });

        //toolbar监听事件
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'dispose') {  // 监听添加操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;

                console.log(data);
                if (data.length != 1) {
                    layer.msg("请选择一行记录！", {time: 1000});
                    return false;
                }

                layer.open({
                    title: "处理",
                    type: 1,
                    maxmin: true,
                    shadeClose: true,
                    area: ['500px', '400px'],
                    btn: ['确定', '取消'],
                    content: $("#edit_window"),
                    success: function () {  //弹出框成功回调
                        var mdata = data[0];   //获取该行的数据
                        console.log(mdata);
                        //给表单赋值
                        form.val("editForm", {
                            "aid": mdata.aid,
                            "sid": mdata.sid,
                            "title": mdata.title,
                            "reason": mdata.reason,
                            "type": mdata.type,
                            "sDate": mdata.sDate,
                            "eDate": mdata.eDate,
                            "status": mdata.status,
                            "attName": mdata.attName,
                            "att": mdata.att,
                            "msg": mdata.msg
                        });
                    },
                    yes: function (index,layero) {  //确认回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');   //获取表单的数据
                        console.log(mdata);
                        $.getJSON({
                            url: 'approval/updateApproval.do',
                            data: {json:JSON.stringify(mdata)},   //发json过去
                            success:function (res) {
                                layer.msg("修改"+res+"行成功!",{time:800});
                                //重载表格
                                table.reload('currentTableId');
                            }
                        });
                    }
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                layer.confirm('如果删除，学生端也将无法显示！\n确定要删除选中行吗？', function(index){
                    var checkStatus = table.checkStatus('currentTableId')
                        , data = checkStatus.data;
                    layer.close(index); //关闭提示框
                    //向服务器请求
                    $.getJSON({
                        url: 'approval/deleteApprovals.do',
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
    });
</script>

</body>
</html>