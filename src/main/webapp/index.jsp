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
    <meta charset="UTF-8">
    <title>学生信息管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jq-module/jquery.particleground.min.js" charset="utf-8"></script>
    <script src="lib/jquery.cookie.js" charset="utf-8"></script>
    <script src="lib/jquery.base64.js" charset="utf-8"></script>

    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        html, body {width: 100%;height: 100%;overflow: hidden}
        /*body {background: #1E9FFF;}*/
        body{background: url("http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211012164441.jpg");background-size: 100%;}
        body:after {content:'';background-repeat:no-repeat;background-size:cover;-webkit-filter:blur(3px);-moz-filter:blur(3px);-o-filter:blur(3px);-ms-filter:blur(3px);filter:blur(3px);position:absolute;top:0;left:0;right:0;bottom:0;z-index:-1;}
        .layui-container {width: 100%;height: 100%;overflow: hidden}
        .admin-login-background {width:360px;height:300px;position:absolute;left:50%;top:40%;margin-left:-180px;margin-top:-100px;}
        .logo-title {text-align:center;letter-spacing:2px;padding:14px 0;}
        .logo-title h1 {color:#1E9FFF;font-size:25px;font-weight:bold;}
        .login-form {background-color:#fff;border:1px solid #fff;border-radius:3px;padding:14px 20px;box-shadow:0 0 8px #eeeeee;}
        .login-form .layui-form-item {position:relative;}
        .login-form .layui-form-item label {position:absolute;left:1px;top:1px;width:38px;line-height:36px;text-align:center;color:#d2d2d2;}
        .login-form .layui-form-item input {padding-left:36px;}
        .captcha {width:60%;display:inline-block;}
        .captcha-img {display:inline-block;width:34%;float:right;}
        .captcha-img img {height:34px;border:1px solid #e6e6e6;height:36px;width:100%;}
    </style>
</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form" action="" lay-filter="loginForm">
                <div class="layui-form-item logo-title">
                    <h1>学生信息管理系统登录</h1>
                </div>
                <%--用户名--%>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" id="username" name="username" lay-verify="required|account" placeholder="学号、职工号、管理员用户名" autocomplete="off" class="layui-input" value="admin">
                </div>
                <%--密码--%>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" id="password" name="password" lay-verify="required|password" placeholder="密码" autocomplete="off" class="layui-input" value="admin">
                </div>
                <%--权限authority--%>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="authority"></label>
                    <select name="authority" id="authority">
                        <option value="manager" selected="selected">管理员</option>
                        <option value="teacher">教师</option>
                        <option value="student">学生</option>
                    </select>
                </div>
                <%--验证码--%>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-vercode" for="captcha"></label>
                    <input type="text" id="captcha" name="captcha" lay-verify="required|captcha" placeholder="图形验证码" autocomplete="off" class="layui-input verification captcha" value="">
                    <div class="captcha-img">
                        <img id="code_pic" alt="" src="kaptcha.jpg">
                    </div>
                </div>
                <div class="layui-form-item">
                    <input type="checkbox" id="rememberMe" name="rememberMe" value="true" lay-skin="primary" title="记住密码（一周有效）"> <%--选中为true，没选中没有--%>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn layui-btn-normal layui-btn-fluid" lay-submit="" lay-filter="login">登 入</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    //点击验证码
    $("#code_pic").click(function () {
        this.src = "kaptcha.jpg?d=" + new Date().getTime();
    });

    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer;

        var username = $.cookie("username");
        var password = $.cookie("password");
        var authority = $.cookie("authority");
        var rememberMe = $.cookie("rememberMe");

        console.log(username);
        console.log(password);
        console.log(authority);
        console.log(rememberMe);

        if(password !== undefined) password = $.base64.decode(password);

        //给表单赋值
        if(username !== undefined) {
            form.val("loginForm", {
                "username":username,
                "password":password,
                "authority":authority,
                "rememberMe":rememberMe
            });
        }

        // 登录过期的时候，跳出ifram框架
        if (top.location != self.location) top.location = self.location;

        // 进行登录操作
        form.on('submit(login)', function (data) {
            data = data.field;
            console.log(data);
            if (data.username === '') {
                layer.msg('用户名不能为空',{time:1000});
                return false;
            } else if (data.password === '') {
                layer.msg('密码不能为空',{time:1000});
                return false;
            } else if (data.captcha === '') {
                layer.msg('验证码不能为空',{time:1000});
                return false;
            }

            $.ajax({
                url: "login/login.do",
                data: {
                    'username':data.username,
                    'password':data.password,
                    'authority':data.authority,
                    'captcha':data.captcha
                },
                type: 'post',
                datatype: 'json',
                success: function (res) {
                    /*
                    * return: 0验证码错误，1账号密码错误，2成功
                    * */
                    switch (res) {
                        case 3:
                            layer.msg("验证码失效，请重新输入!",{time:1000});
                            $("#code_pic").prop("src","kaptcha.jpg?d=" + new Date().getTime());
                            break;
                        case 0:
                            layer.msg("验证码错误!",{time:1000});
                            $("#code_pic").prop("src","kaptcha.jpg?d=" + new Date().getTime());
                            break;
                        case 1:
                            layer.msg("账号或密码错误!",{time:1000});
                            $("#code_pic").prop("src","kaptcha.jpg?d=" + new Date().getTime());
                            break;
                        case 2: //登录成功

                            if(data.rememberMe == "true") {   //记住密码了
                                //设置cookie的过期时间7天
                                var date = new Date();
                                date.setTime(date.getTime() + 1000*60*60*24*7);
                                //设置cookie
                                $.cookie("username",data.username,{ expires: date, path: '/' });
                                $.cookie("password",$.base64.encode(data.password),{ expires: date, path: '/' });
                                $.cookie("authority",data.authority,{ expires: date, path: '/' });
                                $.cookie("rememberMe",data.rememberMe,{ expires: date, path: '/' });
                            } else {    //没有记住密码
                                //清空cookie
                                $.removeCookie("username", { path: '/' });
                                $.removeCookie("password", { path: '/' });
                                $.removeCookie("authority", { path: '/' });
                                $.removeCookie("rememberMe", { path: '/' });
                            }

                            layer.msg("登录成功",{time:1000},function () {
                                if(data.authority === "manager") {
                                    location.href="manager/manager_index.jsp";
                                } else if(data.authority === "teacher") {
                                    location.href="teacher/teacher_index.jsp";
                                } else if(data.authority === "student") {
                                    location.href="student/student_index.jsp";
                                }
                            });
                            break;
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>