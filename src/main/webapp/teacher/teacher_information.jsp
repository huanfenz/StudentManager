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

<%--            <thead>
            <tr>
                <th>key</th>
                <th>value</th>
            </tr>
            </thead>--%>

            <tbody>
                <tr>
                    <th>姓名:</th>
                    <th>${sessionScope.loginObj.tname}</th>
                </tr>
                <tr>
                    <th>职工号:</th>
                    <th>${sessionScope.loginObj.tnum}</th>
                </tr>
                <tr>
                    <th>性别:</th>
                    <th>${sessionScope.loginObj.tsex}</th>
                </tr>
                <tr>
                    <th>年龄:</th>
                    <th>${sessionScope.loginObj.tage}</th>
                </tr>
                <tr>
                    <th>状态:</th>
                    <th>${sessionScope.loginObj.tstatus}</th>
                </tr>
                <tr>
                    <th>备注:</th>
                    <th>${sessionScope.loginObj.tremark}</th>
                </tr>
                <tr>
                    <th>身份证号码:</th>
                    <th>${sessionScope.loginObj.idcard}</th>
                </tr>
                <tr>
                    <th>手机号码:</th>
                    <th>${sessionScope.loginObj.phone}</th>
                </tr>
                <tr>
                    <th>家庭住址:</th>
                    <th>${sessionScope.loginObj.address}</th>
                </tr>
                <tr>
                    <th>进校时间:</th>
                    <th>${sessionScope.loginObj.entime}</th>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
