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
    <title>教师打分</title>
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
</head>
<body>
    <div class="layui-form">
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="150">
                <col>
            </colgroup>

            <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>分数</th>
                </tr>
            </thead>

            <tbody id="tbody1">
                <%--<tr>
                    <td>2020710001</td>
                    <td>张无忌</td>
                    <td><input type="number" placeholder="请输入分数" value="0" name="score" class="layui-input"></td>
                </tr>--%>
            </tbody>

        </table>

        <div style="text-align: center">
            <button type="submit" class="layui-btn layui-btn-normal"  lay-submit lay-filter="data-save-btn">完成成绩录入</button>
            <button type="submit" class="layui-btn layui-btn-danger"  lay-submit lay-filter="data-close-btn">关闭窗口</button>
        </div>

    </div>

    <script type="text/javascript">

        $.ajax({
            url: 'student/teacher/queryStudentsByOid.do',
            data: {oid:${param.get('oid')}},
            type: 'post',
            datatype: 'json',
            success: function (res) {
                console.log(res);
                $('#tbody1').html();
                $.each(res,function (i, n) {
                    $('#tbody1')
                        .append("<tr> <td>"+n.snum+"</td> <td>"+n.sname+"</td> <td><input type=\"number\" placeholder=\"请输入分数\" value=\""+n.score+"\" name=\""+n.sid+"\" class=\"layui-input\"></td> </tr>");
                })
            }
        });

        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(data-save-btn)', function(data){
                //layer.msg(JSON.stringify(data.field));
                var result = JSON.stringify(data.field);

                //保存信息
                $.ajax({
                    url: 'courseGrade/teacher/saveScore.do',
                    data: {json:result, oid: ${param.get('oid')}},
                    type: 'post',
                    datatype: 'json',
                    success: function (res) {
                        layer.msg("更新"+res+"个成绩成功",{time:1000});
                    }
                });
                return false;
            });

            form.on('submit(data-close-btn)', function(){
                //关闭iframe
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                parent.layer.close(index);
                return false;
            });
        });



    </script>

</body>
</html>
