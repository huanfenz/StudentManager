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
    <title>教师信息</title>
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>

    <style>
        body {background: #F2F2F2;}
        #my_table{
            margin: 0px auto; /*居中*/
            width: 60%;
            background-color: #FFFFFF;  /*设置背景颜色*/
            border: 1px solid #EEEEEE;  /*设置边框*/
            border-collapse: collapse;  /*边框合并*/
        }
        #my_table td,th {
            border: 1px solid #EEEEEE;  /*设置边框*/
            height: 30px; /*设置高度*/
            /*设置内边距*/
            padding: 10px;
        }
    </style>

</head>
<body>

    <script type="text/javascript">
        $.ajax({
            url: 'teacher/queryTeacher.do',
            data: {tid:${param.tid}},
            type: 'post',
            datatype: 'json',
            success: function (teacher) {
                $("#tname").html(teacher.tname);
                $("#tnum").html(teacher.tnum);
                $("#tsex").html(teacher.tsex);
                $("#tage").html(teacher.tage);
                $("#tstatus").html(teacher.tstatus);
                $("#tremark").html(teacher.tremark);
                $("#idcard").html(teacher.idcard);
                $("#phone").html(teacher.phone);
                $("#address").html(teacher.address);
                $("#entime").html(teacher.entime);
                $("#pic").attr("src",teacher.pic);
            }
        });
    </script>

    <div>
        <h1 align="center">个人信息档案</h1>
        <div  style="margin-top: 20px">
            <table id="my_table">
                <colgroup>
                    <col width="15%">
                    <col>
                    <col width="15%">
                </colgroup>

                <tbody>
                <tr>
                    <td>姓名:</td>
                    <td id="tname"></td>
                    <td rowspan="6"><img id="pic" width="200px" src=""></td>
                </tr>
                <tr>
                    <td>职工号:</td>
                    <td id="tnum"></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td id="tsex"></td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td id="tage"></td>
                </tr>
                <tr>
                    <td>状态:</td>
                    <td id="tstatus"></td>
                </tr>
                <tr>
                    <td>备注:</td>
                    <td id="tremark"></td>
                </tr>
                <tr>
                    <td>身份证号码:</td>
                    <td id="idcard" colspan="2"></td>
                </tr>
                <tr>
                    <td>手机号码:</td>
                    <td id="phone" colspan="2"></td>
                </tr>
                <tr>
                    <td>家庭住址:</td>
                    <td id="address" colspan="2"></td>
                </tr>
                <tr>
                    <td>进校时间:</td>
                    <td id="entime" colspan="2"></td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
</body>
</html>
