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
    <div class="layui-form" style="width: 400px; float: left" lay-filter="editForm">
        <%--隐藏域，tid--%>
        <input type="hidden" id="tid" name="tid" class="layui-input" value="null">
        <%--隐藏域，pic（头像地址）--%>
        <input type="hidden" id="pic" name="pic" class="layui-input" value="null">
        <!--姓名-->
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" id="tname" name="tname" value="" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名" class="layui-input">
            </div>
        </div>
        <!--职工号-->
        <div class="layui-form-item">
            <label class="layui-form-label">职工号</label>
            <div class="layui-input-block">
                <input type="number" id="tnum" name="tnum" value="" lay-verify="required" lay-reqtext="职工号不能为空" placeholder="请输入职工号" class="layui-input">
            </div>
        </div>
        <!--性别-->
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="tsex" value="男" title="男" checked="checked">
                <input type="radio" name="tsex" value="女" title="女">
            </div>
        </div>
        <!--年龄-->
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="number" id="tage" name="tage" value="" placeholder="请输入年龄" class="layui-input">
            </div>
        </div>
        <!--状态-->
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="text" id="tstatus" name="tstatus" value="" placeholder="请输入状态" class="layui-input">
            </div>
        </div>
        <!--备注-->
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" id="tremark" name="tremark" value="" placeholder="请输入备注" class="layui-input">
            </div>
        </div>
        <!--身份证-->
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-block">
                <input type="number" id="idcard" name="idcard" value="" placeholder="请输入身份证号" class="layui-input">
            </div>
        </div>
        <!--手机号码-->
        <div class="layui-form-item">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-block">
                <input type="tel" id="phone" name="phone" value="" placeholder="请输入手机号码" class="layui-input">
            </div>
        </div>
        <!--地址-->
        <div class="layui-form-item">
            <label class="layui-form-label">家庭地址</label>
            <div class="layui-input-block">
                <input type="text" id="address" name="address" value="" placeholder="请输入家庭地址" class="layui-input">
            </div>
        </div>
        <!--入学时间-->
        <div class="layui-form-item">
            <label class="layui-form-label">入学时间</label>
            <div class="layui-input-block">
                <input type="text" id="entime" name="entime" value="" lay-verify="date" placeholder="请选择入学时间" class="layui-input">
            </div>
        </div>
        <!--登录密码-->
        <div class="layui-form-item">
            <label class="layui-form-label">登录密码</label>
            <div class="layui-input-block">
                <input type="text" id="pswd" name="pswd" value="" placeholder="请输入登录密码" class="layui-input">
            </div>
        </div>
    </div>

    <div style="float:right;">
        <p>上传头像</p>
        <div style="margin-top: 20px"></div>
        <div class="layui-upload">
            <button type="button" class="layui-btn" id="test1">上传图片</button>
            <div class="layui-upload-list">
                <img width="200px" class="layui-upload-img" id="demo1" />
                <p id="demoText"></p>
            </div>
            <div style="width: 95px">
                <div
                        class="layui-progress layui-progress-big"
                        lay-showpercent="yes"
                        lay-filter="demo"
                >
                    <div class="layui-progress-bar" lay-percent=""></div>
                </div>
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
                            <label class="layui-form-label">姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="tname" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">职工号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="tnum" autocomplete="off" class="layui-input">
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
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加教师 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除选中行 </button>
                <button class="layui-btn layui-btn-sm data-plan-btn" lay-event="seeInfo"> 查看教师信息 </button>
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
    layui.use(['form', 'table','laydate', "upload", "element", "layer"], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table,
            date = layui.laydate,
            upload = layui.upload,
            element = layui.element,
            layer = layui.layer;

        //上传图片
        var uploadInst = upload.render({
            elem: "#test1",
            url: "update/updateImg.do", //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
            before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    console.log(result);
                    $("#demo1").attr("src", result); //图片链接（base64）
                });

                element.progress("demo", "0%"); //进度条复位
                layer.msg("上传中", { icon: 16, time: 0 });
            },
            done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg("上传失败");
                }
                //上传成功的一些操作
                //把地址写到表单的隐藏域中
                $("#pic").val(res.data.src);
                //图片链接替换
                $("#demo1").attr("src", res.data.src);

                $("#demoText").html(""); //置空上传失败的状态
            },
            error: function () {
                //演示失败状态，并实现重传
                var demoText = $("#demoText");
                demoText.html(
                    '<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>'
                );
                demoText.find(".demo-reload").on("click", function () {
                    uploadInst.upload();
                });
            },
            //进度条
            progress: function (n, elem, e) {
                element.progress("demo", n + "%"); //可配合 layui 进度条元素使用
                if (n == 100) {
                    layer.msg("上传完毕", { icon: 1 });
                }
            },
        });

        //加载数据表格
        table.render({
            elem: '#currentTableId',
            url: 'teacher/queryTeachers.do',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            cols: [[
                {type: "checkbox"},
                {field: 'tid', title: '序号', sort: true},
                {field: 'tname', title: '姓名'},
                {field: 'tnum', title: '职工号', sort: true},
                {field: 'tsex', title: '性别'},
                {field: 'tage', title: '年龄', sort: true},
                {field: 'tstatus', title: '状态'},
                {field: 'tremark', title: '备注'},
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
                url: 'teacher/searchTeachers.do',
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
                'tname':null,
                'tnum':null,
                'sclass':null
            });
            //执行搜索重载
            table.reload('currentTableId', {
                url: 'teacher/queryTeachers.do',
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
                    area:['800px','90%'],
                    btn: ['确定', '取消'],
                    content: $("#edit_window"),
                    success: function () {  //弹出框成功回调
                        //给表单赋值
                        form.val("editForm", {
                            "tid": null,
                            "tname": '王守仁',
                            "tnum": '2020710050',
                            "tsex": '男',
                            "tage": 20,
                            "tstatus":'正常',
                            "tremark":'无',
                            "idcard":'320282200002181243',
                            "phone":'13912345678',
                            "address":'浙江省宁波市余姚市王府',
                            "entime":'2020-09-01',
                            "pswd":'123456',
                            "pic": 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010200811.jpg'
                        });
                        $("#demo1").attr("src", "http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010200811.jpg");
                    },
                    yes: function(index,layero){ //确认的回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');
                        //向服务器请求
                        $.getJSON({
                            url: 'teacher/addTeacher.do',
                            data: {json:JSON.stringify(mdata)},    //发json
                            success:function (res) {
                                layer.msg("添加"+res+"行成功！",{time:800});
                                //获得最后一页的页码并重载
                                $.getJSON({
                                    url: 'teacher/getAmount.do',
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
                        url: 'teacher/deleteTeachers.do',
                        data: {json:JSON.stringify(data)},   //发json过去
                        success:function (res) {
                            layer.msg("删除"+res+"行成功！",{time:800});
                            //重载表格
                            table.reload('currentTableId',{page:{curr:1}});
                        }
                    });
                });
            } else if (obj.event === 'seeInfo') {  //监听查看信息操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;

                console.log(data);
                if (data.length != 1) {
                    layer.msg("请选择一行记录！", {time: 1000});
                    return false;
                }

                layer.open({
                    title: "查看教师信息",
                    type: 2,    //iframe
                    maxmin: true,
                    shadeClose: true,
                    area: ['90%', '90%'],
                    btn: ['确定'],
                    content: 'manager/manager_teacher_information.jsp?tid=' + data[0].tid,
                    yes: function (index, layero) { //确认的回调
                        layer.close(index); //关闭弹出框
                    }
                })
            }
        });

        table.on('tool(currentTableFilter)', function (obj) {
            if (obj.event === 'edit') { //监听编辑按钮
                var index = layer.open({
                    title: '编辑用户',
                    type: 1,    //界面层
                    maxmin:true,
                    shadeClose: true,
                    area: ['800px', '90%'],
                    btn: ['确定', '取消'],
                    content: $("#edit_window"),
                    success: function () {
                        var mdata = obj.data;   //获取该行的数据
                        console.log(mdata);
                        //给表单赋值
                        form.val("editForm", {
                            "tid": mdata.tid,
                            "tname": mdata.tname,
                            "tnum": mdata.tnum,
                            "tsex": mdata.tsex,
                            "tage": mdata.tage,
                            "tstatus": mdata.tstatus,
                            "tremark": mdata.tremark,
                            "idcard": mdata.idcard,
                            "phone": mdata.phone,
                            "address": mdata.address,
                            "entime": mdata.entime,
                            "pswd": mdata.pswd,
                            "pic": mdata.pic
                        });
                        $("#demo1").attr("src", mdata.pic);
                    },
                    yes: function () {  //确认回调
                        layer.close(index); //关闭弹出框
                        var mdata = form.val('editForm');   //获取表单的数据
                        $.getJSON({
                            url: 'teacher/updateTeacher.do',
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
                        url: 'teacher/deleteTeachers.do',
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