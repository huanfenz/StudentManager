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
    <title>公告管理</title>
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
        <%--隐藏域，id--%>
        <input type="hidden" id="id" name="id" class="layui-input" value="null">
        <!--专业名-->
        <div class="layui-form-item">
            <label class="layui-form-label">文章标题</label>
            <div class="layui-input-block">
                <input type="text" id="title" name="title" value="" lay-verify="required" lay-reqtext="文章标题不能为空" placeholder="请输入文章标题" class="layui-input">
            </div>
        </div>
        <!--院系-->
        <div class="layui-form-item">
            <label class="layui-form-label">添加人</label>
            <div class="layui-input-block">
                <input type="text" id="people" name="people" value="" placeholder="请输入添加人" class="layui-input">
            </div>
        </div>
        <!--备注-->
        <div class="layui-form-item">
            <label class="layui-form-label">日期</label>
            <div class="layui-input-block">
                <input type="text" id="date" name="date" value="" placeholder="请输入日期" class="layui-input">
            </div>
        </div>
        <%--文章上传--%>
        <div class="layui-form-item">
            <label class="layui-form-label">上传文章</label>
            <div class="layui-input-block">
                <button type="button" class="layui-btn" id="article_upload"><i class="layui-icon"></i>上传HTML格式文档</button>
                <span id="fileName"></span>
            </div>
        </div>
        <%--隐藏域,附件上传的地址--%>
        <input type="hidden" id="url" name="url" class="layui-input" value="null">

    </div>
</div>

<%--数据表格布局--%>
<div class="layuimini-container">
    <div class="layuimini-main">
        <%--搜索信息--%>
        <fieldset class="table-search-fieldset">
                <legend>搜索公告</legend>
                <div style="margin: 10px 10px 10px 10px">
                    <form class="layui-form layui-form-pane" action="" lay-filter="searchForm">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">文章名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="title" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">日期</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="search_date" name="date" autocomplete="off" placeholder="yyyy-MM-dd" class="layui-input">
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
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加公告 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除选中行 </button>
            </div>
        </script>
        <%--表格容器--%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
    </div>
</div>
<%--js代码--%>
<script>
    layui.use(['form', 'table','laydate', "upload", "element", "layer"], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table,
            date = layui.laydate,
            upload = layui.upload,
            layer = layui.layer;

        //上传文章
        upload.render({
            elem: '#article_upload',
            url: 'upload/uploadArticle.do',
            accept: 'file', //普通文件
            exts: 'html|htm', //只允许上传html和htm
            done: function(res){
                layer.msg('上传成功');
                console.log(res);
                $("#url").val(res.data.src);    //放url隐藏域
                $("#fileName").html(res.data.fileName);  //放文件名显示
            }
        });

        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'article/queryArticles.do',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            cols: [[
                {type: "checkbox"},
                {field: 'id', title: '序号', width: 100},
                {field: 'title', width: 600, title: '文章标题', event: 'show', style:'cursor: pointer;'}, /*手形状*/
                {field: 'people', title: '添加人'},
                {field: 'date', title: '日期', sort: true}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: {
                prev: '上一页',
                next: '下一页',
            }
        });

        date.render({
            elem: '#search_date',
        });

        date.render({
            elem: '#date',
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            console.log(result);
            //执行搜索重载
            table.reload('currentTableId', {
                url: 'article/searchArticles.do',
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
                'title':null,
                'date':null
            });
            //执行搜索重载
            table.reload('currentTableId', {
                url: 'article/queryArticles.do',
                page: {curr: 1}, //重新从第 1 页开始
                done: null
            });

            return false;   //不跳转
        });

        function getToday() {
            var nowDate = new Date();
            var year = nowDate.getFullYear();
            var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1)
                : nowDate.getMonth() + 1;
            var day = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate
                .getDate();
            var dateStr = year + "-" + month + "-" + day;
            return dateStr;
        }

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
                        //文件名显示空白
                        $("#fileName").html("");
                        //给表单赋值
                        form.val("editForm", {
                            "id": null,
                            "title": null,
                            "people": null,
                            "date": getToday(),
                            "url": null
                        });
                    },
                    yes: function(index,layero){ //确认的回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');
                        //向服务器请求
                        $.getJSON({
                            url: 'article/addArticle.do',
                            data: {json:JSON.stringify(mdata)},    //发json
                            success:function (res) {
                                layer.msg("添加"+res+"行成功！",{time:800});
                                //重载表格
                                table.reload('currentTableId',{page:{curr:1}});
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
                        url: 'article/deleteArticles.do',
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

        //监听单元格事件
        table.on('tool(currentTableFilter)', function(obj){
            if(obj.event === 'show') {
                var mdata = obj.data;
                layer.open({
                    title: mdata.title,
                    type: 2,    //iframe
                    shadeClose: true,
                    area: ['95%', '95%'],
                    content: mdata.url
                })
            }
        });

    });
</script>

</body>
</html>