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
    <div class="layui-form">
        <table class="layui-table">

            <colgroup>
                <col width="200">
                <col>
            </colgroup>
            
            <tbody>
                <tr>
                    <td>姓名:</td>
                    <td>${sessionScope.loginObj.tname}</td>
                </tr>
                <tr>
                    <td>职工号:</td>
                    <td>${sessionScope.loginObj.tnum}</td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>${sessionScope.loginObj.tsex}</td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td>${sessionScope.loginObj.tage}</td>
                </tr>
                <tr>
                    <td>状态:</td>
                    <td>${sessionScope.loginObj.tstatus}</td>
                </tr>
                <tr>
                    <td>备注:</td>
                    <td>${sessionScope.loginObj.tremark}</td>
                </tr>
                <tr>
                    <td>身份证号码:</td>
                    <td>${sessionScope.loginObj.idcard}</td>
                </tr>
                <tr>
                    <td>手机号码:</td>
                    <td>${sessionScope.loginObj.phone}</td>
                </tr>
                <tr>
                    <td>家庭住址:</td>
                    <td>${sessionScope.loginObj.address}</td>
                </tr>
                <tr>
                    <td>进校时间:</td>
                    <td>${sessionScope.loginObj.entime}</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
