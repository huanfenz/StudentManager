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
    <title>学生审批</title>
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
        <%--隐藏域，aid--%>
        <input type="hidden" id="aid" name="aid" class="layui-input" value="null">
        <%--隐藏域，sid--%>
        <input type="hidden" id="aid" name="sid" class="layui-input" value="null">
        <!--审批名-->
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block">
                <input type="text" id="title" name="title" value="" lay-verify="required" lay-reqtext="审批名不能为空" placeholder="请输入姓名" class="layui-input">
            </div>
        </div>
        <%--原因--%>
        <div class="layui-form-item">
            <label class="layui-form-label">原因</label>
            <div class="layui-input-block">
                <textarea id="reason" name="reason" lay-verify="required" lay-reqtext="原因不能为空" placeholder="请输入原因" class="layui-textarea"></textarea>
            </div>
        </div>
        <!--类型-->
        <div class="layui-form-item">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <select name="type" id="edit_type" lay-search="">
                    <option value="请假">请假</option>
                    <option value="休学">休学</option>
                    <option value="辍学">辍学</option>
                    <option value="复学">复学</option>
                    <option value="转学">转学</option>
                </select>
            </div>
        </div>
        <!--开始日期-->
        <div class="layui-form-item">
            <label class="layui-form-label">开始日期</label>
            <div class="layui-input-block">
                <input type="text" id="sDate" name="sDate" value="" lay-verify="date" placeholder="请输入开始日期" class="layui-input">
            </div>
        </div>
        <%--结束日期--%>
        <div class="layui-form-item">
            <label class="layui-form-label">结束日期</label>
            <div class="layui-input-block">
                <input type="text" id="eDate" name="eDate" value="" lay-verify="date" placeholder="请输入结束日期" class="layui-input">
            </div>
        </div>

        <%--附件上传--%>
        <div class="layui-form-item">
            <label class="layui-form-label">附件</label>
            <div class="layui-input-block">
                <button type="button" class="layui-btn" id="att_upload"><i class="layui-icon"></i>上传文件</button>
                <span id="fileName"></span>
            </div>
        </div>
        <%--隐藏域,附件上传的地址--%>
        <input type="hidden" id="att" name="att" class="layui-input" value="null">
        <%--隐藏域,附件上传的名称--%>
        <input type="hidden" id="attName" name="attName" class="layui-input" value="null">
        <%--隐藏域,审批情况--%>
        <input type="hidden" id="status" name="status" class="layui-input" value="null">
    </div>
</div>
<%--数据表格布局--%>
<div class="layuimini-container">
    <div class="layuimini-main">
        <%--头部工具栏--%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加审批 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 撤销审批 </button>
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
    layui.use(['form', 'table','laydate','upload'], function () {
        var $ = layui.jquery, form = layui.form, table = layui.table, laydate=layui.laydate, upload=layui.upload;

        //上传附件
        upload.render({
            elem: '#att_upload',
            url: 'upload/student/uploadAttachment.do',
            accept: 'file', //普通文件
            done: function(res){
                layer.msg('上传成功');
                console.log(res);
                $("#att").val(res.data.src);
                $("#attName").val(res.data.fileName);
                $("#fileName").html(res.data.fileName);
            }
        });

        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'approval/student/queryApprovalsBySid.do',
            toolbar: '#toolbarDemo',
            cols: [[
                {type: "checkbox"},
                /*{field: 'aid', title: '序号', sort: true},*/
                {field: 'title', title: '标题'},
                {field: 'reason', width: 200, title: '原因'},
                {field: 'type', title: '类型'},
                {field: 'sDate', title: '开始日期', sort: true},
                {field: 'eDate', title: '结束日期', sort: true},
                {field: 'attName', title: '附件(点击打开)',templet: '#urlTpl' },
                {field: 'status', title: '审批情况', sort: true},
                {field: 'msg', width: 200, title: '回复'}
            ]],
            limits: [5, 10, 15, 20, 25, 50, 100],
            limit: 10,
            page: {
                prev: '上一页',
                next: '下一页',
            },
        });

        laydate.render({
            elem: '#sDate'
        });
        laydate.render({
            elem: '#eDate'
        });

        //toolbar监听事件
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                layer.open({
                    title:"新增",
                    type: 1,
                    maxmin:true,
                    shadeClose: true,
                    area:['550px','500px'],
                    btn: ['确定', '取消'],
                    content: $("#edit_window"),
                    success: function () {  //弹出框成功回调
                        var nowDate = new Date();
                        var year = nowDate.getFullYear();
                        var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1)
                            : nowDate.getMonth() + 1;
                        var day = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate
                            .getDate();
                        var dateStr = year + "-" + month + "-" + day;

                        $("#fileName").html("");
                        //给表单赋值
                        form.val("editForm", {
                            "aid": null,
                            "sid": ${sessionScope.loginObj.sid},
                            "reason": null,
                            "title": '本人要请假',
                            "type": '请假',
                            "sDate": dateStr,
                            "eDate": dateStr,
                            "status": '等待审批',
                            "att": null,
                            "attName": null,
                            "msg":null
                        });
                    },
                    yes: function(index,layero){ //确认的回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');
                        //向服务器请求
                        $.getJSON({
                            url: 'approval/student/addApproval.do',
                            data: {json:JSON.stringify(mdata)},    //发json
                            success:function (res) {
                                layer.msg("添加"+res+"行成功！",{time:800});
                                //获得最后一页的页码并重载
                                $.getJSON({
                                    url: 'approval/student/getAmount.do',
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
                        url: 'approval/student/deleteApprovals.do',
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