<%@ page contentType="text/html;charset=UTF-8" language="java" %>   <%--jsp--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <%--jstl--%>
<%
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath() + "/";
%>  <%--取base--%>
<!doctype html>
<html lang="en">
<head>
    <base href="<%=basePath%>" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
    <script src="lib/Timetables.min.js"></script>
    <title>课表展示</title>
    <style>
        #coursesTable {
            padding: 15px 10px;
        }

        .Courses-head {
            background-color: #edffff;
        }

        .Courses-head > div {
            text-align: center;
            font-size: 14px;
            line-height: 28px;
        }

        .left-hand-TextDom, .Courses-head {
            background-color: #f2f6f7;
        }

        .Courses-leftHand {
            background-color: #f2f6f7;
            font-size: 12px;
        }

        .Courses-leftHand .left-hand-index {
            color: #9c9c9c;
            margin-bottom: 4px !important;
        }

        .Courses-leftHand .left-hand-name {
            color: #666;
        }

        .Courses-leftHand p {
            text-align: center;
            font-weight: 900;
        }

        .Courses-head > div {
            border-left: none !important;
        }

        .Courses-leftHand > div {
            padding-top: 5px;
            border-bottom: 1px dashed rgb(219, 219, 219);
        }

        .Courses-leftHand > div:last-child {
            border-bottom: none !important;
        }

        .left-hand-TextDom, .Courses-head {
            border-bottom: 1px solid rgba(0, 0, 0, 0.1) !important;
        }

        .Courses-content > ul {
            border-bottom: 1px dashed rgb(219, 219, 219);
            box-sizing: border-box;
        }

        .Courses-content > ul:last-child {
            border-bottom: none !important;
        }

        .highlight-week {
            color: #02a9f5 !important;
        }

        .Courses-content li {
            text-align: center;
            color: #666666;
            font-size: 14px;
            line-height: 50px;
        }

        .Courses-content li span {
            padding: 6px 2px;
            box-sizing: border-box;
            line-height: 18px;
            border-radius: 4px;
            white-space: normal;
            word-break: break-all;
            cursor: pointer;
        }

        .grid-active {
            z-index: 9999;
        }

        .grid-active span {
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<fieldset class="table-search-fieldset" style="background-color:white; border:1px solid #E6E6E6;">
    <legend>选择</legend>
    <div style="margin: 10px 10px 10px 10px;">
        <form class="layui-form layui-form-pane" action="" lay-filter="searchForm">
            <div class="layui-form-item">
                <%--隐藏域，cid--%>
                <input type="hidden" id="search_cid" name="cid" class="layui-input" value="${sessionScope.loginObj.cid}">
                <!--学年-->
                <div class="layui-inline">
                    <label class="layui-form-label">学年</label>
                    <div class="layui-input-inline">
                        <select name="year" id="search_year" lay-search="">
                            <option value="">请选择学年</option>
                            <!--从2021到2030-->
                            <c:forEach begin="2021" end="2030" var="i">
                                <option value="${i}-${i + 1}学年">${i}-${i + 1}学年</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <!--学期-->
                <div class="layui-inline">
                    <label class="layui-form-label">学期</label>
                    <div class="layui-input-inline">
                        <select name="term" id="search_term" lay-search="">
                            <option value="">请选择学期</option>
                            <option value="第一学期">第一学期</option>
                            <option value="第二学期">第二学期</option>
                        </select>
                    </div>
                </div>
                <%--周数--%>
                <div class="layui-inline">
                    <label class="layui-form-label">周数</label>
                    <div class="layui-input-inline">
                        <select name="weekno" id="search_weekno" lay-search="">
                            <option value="">请选择周数</option>
                            <%--从1到20--%>
                            <c:forEach begin="1" end="20" var="i">
                                <option value="${i}">第${i}周</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 确　　定 </button>
                </div>
            </div>
        </form>
    </div>
</fieldset>
<div id="coursesTable"></div>
<script>

    layui.use(['form', 'table'], function () {
        var $ = layui.jquery, form = layui.form, table = layui.table;

        function my_search(data) {
            var result = JSON.stringify(data);
            $.getJSON({
                url: 'tableShow/student/queryTable.do',
                data: {json: result},
                success: function (res) {
                    console.log(res);
                    var courseListOther = res;
                    Timetable.setOption({
                        timetables: courseListOther,
                        gridOnClick: function (e) {
                            alert(e.name + '  ' + e.week + ', 第' + e.index + '节课, 课长' + e.length + '节');
                            console.log(e);
                        },
                        styles:{
                            Gheight: 65,
                        },
                        timetableType: courseType
                    });
                }
            });
        }

        $.getJSON({
            url: 'clazz/student/queryAllClazzs.do',
            success: function (data) {
                console.log(data);
                $("#search_cid").html();
                $.each(data, function (i, n) {
                    $("#search_cid")
                        .append("<option value=\"" + n.cid + "\">" + n.cname + "</option>")
                });
                form.render('select', 'searchForm'); //刷新select选择框渲染
                form.val("searchForm", {
                    "year": "2021-2022学年",
                    "term": "第一学期",
                    "weekno": 1,
                });
                var data = form.val("searchForm");
                console.log(data);
                my_search(data);
            }
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            my_search(data.field);
            return false;
        });
    })

    var courseList = [
        ['','','','','','','','','',''],
        ['','','','','','','','','',''],
        ['','','','','','','','','',''],
        ['','','','','','','','','',''],
        ['','','','','','','','','','']
    ];
    var week = window.innerWidth > 360 ? ['周一', '周二', '周三', '周四', '周五'] :
    ['一', '二', '三', '四', '五'];
    var day = new Date().getDay();
    var courseType = [
        [{index: '1', name: '8:30\n9:15'}, 1],
        [{index: '2', name: '9:20\n10:05'}, 1],
        [{index: '3', name: '10:25\n11:10'}, 1],
        [{index: '4', name: '11:15\n12:00'}, 1],
        [{index: '5', name: '13:30\n14:15'}, 1],
        [{index: '6', name: '14:20\n15:05'}, 1],
        [{index: '7', name: '15:25\n16:10'}, 1],
        [{index: '8', name: '16:15\n17:00'}, 1],
        [{index: '9', name: '18:00\n18:45'}, 1],
        [{index: '10', name: '18:50\n19:35'}, 1]
    ];
    // 实例化(初始化课表)
    var Timetable = new Timetables({
        el: '#coursesTable',
        timetables: courseList,
        week: week,
        timetableType: courseType,
        highlightWeek: day,
        gridOnClick: function (e) {
          alert(e.name + '  ' + e.week + ', 第' + e.index + '节课, 课长' + e.length + '节');
          console.log(e);
        },
        styles: {
          Gheight: 65
        }
    });

</script>
</body>
</html>
