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
    <title>教师信息</title>
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
</head>
<body>
    <h1 align="center">个人信息档案</h1>
    <div class="layui-container" style="width: 60%;" align="center">
        <table class="layui-table">
            <colgroup>
                <col width="100px">
                <col>
                <col width="100px">
            </colgroup>

            <tr>
                <td>姓名:</td>
                <td>${sessionScope.loginObj.sname}</td>
                <td rowspan="3"><img src="http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223500.jpg"></td>
            </tr>
            <tr>
                <td>学号:</td>
                <td>${sessionScope.loginObj.snum}</td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>${sessionScope.loginObj.ssex}</td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td colspan="2">${sessionScope.loginObj.sage}</td>
            </tr>
            <tr>
                <td>班级:</td>
                <td colspan="2">${sessionScope.loginObj.cname}</td>
            </tr>
            <tr>
                <td>状态:</td>
                <td colspan="2">${sessionScope.loginObj.sstatus}</td>
            </tr>
            <tr>
                <td>备注:</td>
                <td colspan="2">${sessionScope.loginObj.sremark}</td>
            </tr>
            <tr>
                <td>身份证号码:</td>
                <td colspan="2">${sessionScope.loginObj.idcard}</td>
            </tr>
            <tr>
                <td>手机号码:</td>
                <td colspan="2">${sessionScope.loginObj.phone}</td>
            </tr>
            <tr>
                <td>家庭住址:</td>
                <td colspan="2">${sessionScope.loginObj.address}</td>
            </tr>
            <tr>
                <td>进校时间:</td>
                <td colspan="2">${sessionScope.loginObj.entime}</td>
            </tr>

        </table>
    </div>

</body>
</html>
