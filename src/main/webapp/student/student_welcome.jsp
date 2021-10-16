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
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>学生首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/js/lay-config.js?v=1.0.4" charset="utf-8"></script>

    <style>
        .layui-card {border:1px solid #f2f2f2;border-radius:5px;}
        .icon {margin-right:10px;color:#1aa094;}
        .icon-cray {color:#ffb800!important;}
        .icon-blue {color:#1e9fff!important;}
        .icon-tip {color:#ff5722!important;}
        .layuimini-qiuck-module {text-align:center;margin-top: 10px}
        .layuimini-qiuck-module a i {display:inline-block;width:100%;height:60px;line-height:60px;text-align:center;border-radius:2px;font-size:30px;background-color:#F8F8F8;color:#333;transition:all .3s;-webkit-transition:all .3s;}
        .layuimini-qiuck-module a cite {position:relative;top:2px;display:block;color:#666;text-overflow:ellipsis;overflow:hidden;white-space:nowrap;font-size:14px;}
        .welcome-module {width:100%;height:210px;}
        .panel {background-color:#fff;border:1px solid transparent;border-radius:3px;-webkit-box-shadow:0 1px 1px rgba(0,0,0,.05);box-shadow:0 1px 1px rgba(0,0,0,.05)}
        .panel-body {padding:10px}
        .panel-title {margin-top:0;margin-bottom:0;font-size:12px;color:inherit}
        .label {display:inline;padding:.2em .6em .3em;font-size:75%;font-weight:700;line-height:1;color:#fff;text-align:center;white-space:nowrap;vertical-align:baseline;border-radius:.25em;margin-top: .3em;}
        .layui-red {color:red}
        .main_btn > p {height:40px;}
        .layui-bg-number {background-color:#F8F8F8;}
        .layuimini-notice:hover {background:#f6f6f6;}
        .layuimini-notice {padding:7px 16px;clear:both;font-size:12px !important;cursor:pointer;position:relative;transition:background 0.2s ease-in-out;}
        .layuimini-notice-title,.layuimini-notice-label {
            padding-right: 70px !important;text-overflow:ellipsis!important;overflow:hidden!important;white-space:nowrap!important;}
        .layuimini-notice-title {line-height:28px;font-size:14px;}
        .layuimini-notice-extra {position:absolute;top:50%;margin-top:-8px;right:16px;display:inline-block;height:16px;color:#999;}
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md8">
                <div class="layui-row layui-col-space15">

                    <div class="layui-col-md12">
                        <!-- 系统公告 -->
                        <div class="layui-card" style="height: 860px;">
                            <div class="layui-card-header"><i class="fa fa-bullhorn icon icon-tip"></i>系统公告</div>
                            <div style="margin: 15px;">
                                <fieldset class="table-search-fieldset">
                                    <legend>搜索公告</legend>
                                    <div style="margin: 10px 10px 10px 10px">
                                        <form class="layui-form layui-form-pane" action="">
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

                                <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="layui-col-md4">
                <!-- 数据统计 -->
                <div class="layui-card" style="height: 170px;">
                    <div class="layui-card-header"><i class="fa fa-warning icon"></i>数据统计</div>
                    <div class="layui-card-body">
                        <div class="welcome-module">
                            <div class="layui-row layui-col-space10">
                                <div class="layui-col-xs6">
                                    <div class="panel layui-bg-number">
                                        <div class="panel-body">
                                            <div class="panel-title">
                                                <span class="label pull-right layui-bg-blue">实时</span>
                                                <h5>开课统计</h5>
                                            </div>
                                            <div class="panel-content">
                                                <h1 class="no-margins">17</h1>
                                                <small>开课总数</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-xs6">
                                    <div class="panel layui-bg-number">
                                        <div class="panel-body">
                                            <div class="panel-title">
                                                <span class="label pull-right layui-bg-cyan">实时</span>
                                                <h5>审批统计</h5>
                                            </div>
                                            <div class="panel-content">
                                                <h1 class="no-margins">12</h1>
                                                <small>审批总数</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 快捷入口 -->
                <div class="layui-card" style="height: 170px">
                    <div class="layui-card-header"><i class="fa fa-credit-card icon icon-blue"></i>快捷入口</div>
                    <div class="layui-card-body">
                        <div class="welcome-module">
                            <div class="layui-row layui-col-space10 layuimini-qiuck">
                                <div class="layui-col-xs3 layuimini-qiuck-module">
                                    <a href="javascript:;" layuimini-content-href="student/student_information.jsp" data-title="个人信息" data-icon="fa fa-pencil">
                                        <i class="fa fa-pencil"></i>
                                        <cite>学生信息</cite>
                                    </a>
                                </div>
                                <div class="layui-col-xs3 layuimini-qiuck-module">
                                    <a href="javascript:;" layuimini-content-href="student/student_table_show.jsp" data-title="课表查看" data-icon="fa fa-table">
                                        <i class="fa fa-table"></i>
                                        <cite>课表查看</cite>
                                    </a>
                                </div>
                                <div class="layui-col-xs3 layuimini-qiuck-module">
                                    <a href="javascript:;" layuimini-content-href="student/student_score.jsp" data-title="成绩查询" data-icon="fa fa-graduation-cap">
                                        <i class="fa fa-graduation-cap"></i>
                                        <cite>成绩查询</cite>
                                    </a>
                                </div>
                                <div class="layui-col-xs3 layuimini-qiuck-module">
                                    <a href="javascript:;" layuimini-content-href="student/student_approval_list.jsp" data-title="申请审批" data-icon="fa fa-book">
                                        <i class="fa fa-book"></i>
                                        <cite>申请审批</cite>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 版本信息 -->
                <div class="layui-card">
                    <div class="layui-card-header"><i class="fa fa-fire icon"></i>版本信息</div>
                    <div class="layui-card-body layui-text">
                        <table class="layui-table">
                            <colgroup>
                                <col width="100">
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <td>项目名称</td>
                                <td>
                                    StudentManager学生信息管理系统 V1.0.1
                                </td>
                            </tr>
                            <tr>
                                <td>作者</td>
                                <td>江苏第二师范学院 数学与信息技术学院 王鹏</td>
                            </tr>
                            <tr>
                                <td>演示地址</td>
                                <td>
                                    在线演示：<a href="http://47.97.104.230:8080/StudentManager/index.jsp" target="_blank">点击查看</a><br>
                                    管理员账号：admin       密码：admin<br>
                                    教师端账号：15001       密码：123456<br>
                                    学生端账号：2020710001  密码：123456<br>
                                </td>
                            </tr>
                            <tr>
                                <td>下载地址</td>
                                <td>
                                    <a href="https://github.com/huanfenz/StudentManager" target="_blank">github</a> / <a href="https://gitee.com/huanfenz/StudentManager" target="_blank">gitee</a><br>
                                    喜欢此项目的可以给我的GitHub和Gitee加个Star支持一下
                                </td>
                            </tr>
                            <tr>
                                <td>联系方式</td>
                                <td>
                                    QQ 894176237
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script>
    layui.use(['layer', 'miniTab', 'form', 'table','laydate'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            miniTab = layui.miniTab,
            form = layui.form,
            date = layui.laydate,
            table = layui.table;

        miniTab.listen();

        table.render({
            elem: '#currentTableId',
            url: 'article/queryArticles.do',
            cols: [[
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
            elem: '#search_date'
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
                'sname':null,
                'snum':null,
                'cid':null
            });
            //执行搜索重载
            table.reload('currentTableId', {
                url: 'article/queryArticles.do',
                page: {curr: 1}, //重新从第 1 页开始
                done: null
            });

            return false;   //不跳转
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
