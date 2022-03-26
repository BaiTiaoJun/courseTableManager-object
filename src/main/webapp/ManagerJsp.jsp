<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/7
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员信息查询界面</title>
    <link rel="stylesheet" href="css/ManagerSelectJsp.css">
    <link rel="stylesheet" href="css/ManagerWindow.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/managerSelect.js"></script>
    <script type="text/javascript" src="js/doAjaxBySearch.js"></script>
    <script type="text/javascript" src="js/exit.js"></script>
</head>
<body>
    <header class="header">
            <div class="dot"></div>
            <h5>当前用户：${username}</h5>
            <input type="button" value="注销" class="exit">
    </header>
    <div class="font">
        <h5>欢迎您，系统管理员!</h5>
    </div>
    <section>
        <div class="box">
            <ul>
                <li>管理员信息首页</li>
                <li defined="userRight">用户信息查询</li>
                <li defined="stuRight">学生信息查询</li>
                <li defined="teaRight">教师信息查询</li>
                <li defined="courseTableRight">课程表查询</li>
                <li defined="couBaseRight">课程基本信息查询</li>
                <li defined="claBaseRight">班级基本信息查询</li>
                <li defined="classroomBaseRight">教室基本信息查询</li>
            </ul>
        </div>
        <%--用户窗体--%>
        <div class="userRight right">
            <input type="text" class="searchText" id="userSearch">
            <input type="button" class="searchBtn" value="查找" id="userSearchBtn">
            <a class="insertWrap" href="UserInsert.html"><input type="button" class="insert" value="添加数据"></a>
            <hr class="line">
            <table class="showBox"></table>
            <div class="search">
                <a class="prepage" href="javascript:void(0)">上一页</a>
                <a class="nextpage" href="javascript:void(0)">下一页</a>
                <input type="text">
                <font></font>
                <a class="skip" href="javascript:void(0)">跳转</a>
            </div>
        </div>
        <%--学生窗体--%>
        <div class="stuRight right">
            <input type="text" class="searchText" id="stuSearch" placeholder="学号或姓名">
            <input type="button" class="searchBtn" value="查找" id="stuSearchBtn" curObj="stuRight">
            <a class="insertWrap" href="StuInsert.html"><input type="button" class="insert" value="添加数据"></a>
            <hr class="line">
            <table class="showBox"></table>
            <div class="search">
                <a class="prepage" href="javascript:void(0)">上一页</a>
                <a class="nextpage" href="javascript:void(0)">下一页</a>
                <input type="text">
                <font></font>
                <a class="skip" href="javascript:void(0)">跳转</a>
            </div>
        </div>
<%--        教师窗体--%>
        <div class="teaRight right">
            <input type="text" class="searchText" id="teaSearch" placeholder="编号、姓名或院系">
            <input type="button" class="searchBtn" value="查找" id="teaSearchBtn" curObj="teaRight">
            <a class="insertWrap" href="TeaInsert.html"><input type="button" class="insert" value="添加数据"></a>
            <hr class="line">
            <table class="showBox"></table>
            <div class="search">
                <a class="prepage" href="javascript:void(0)">上一页</a>
                <a class="nextpage" href="javascript:void(0)">下一页</a>
                <input type="text">
                <font></font>
                <a class="skip" href="javascript:void(0)">跳转</a>
            </div>
        </div>
<%--        课程表窗体--%>
        <div class="courseTableRight right">
            <input type="text" class="searchText" id="courseTableSearch" placeholder="班级、课程、教师或周次">
            <input type="button" class="searchBtn" value="查找" id="courseTableSearchBtn" curObj="courseTableRight">
            <a class="insertWrap" href="CourseTableInsert.html"><input type="button" class="insert" value="添加数据"></a>
            <hr class="line">
            <table class="showBox"></table>
            <div class="search">
                <a class="prepage" href="javascript:void(0)">上一页</a>
                <a class="nextpage" href="javascript:void(0)">下一页</a>
                <input type="text">
                <font></font>
                <a class="skip" href="javascript:void(0)">跳转</a>
            </div>
        </div>
<%--        &lt;%&ndash;课程基本信息窗体&ndash;%&gt;--%>
        <div class="couBaseRight right">
            <input type="text" class="searchText" id="courseBaseSearch" placeholder="课程号或课程名">
            <input type="button" class="searchBtn" value="查找" id="courseBaseSearchBtn" curObj="couBaseRight">
            <a class="insertWrap" href="CourseBaseInsert.html"><input type="button" class="insert" value="添加数据"></a>
            <hr class="line">
            <table class="showBox"></table>
            <div class="search">
                <a class="prepage" href="javascript:void(0)">上一页</a>
                <a class="nextpage" href="javascript:void(0)">下一页</a>
                <input type="text">
                <font></font>
                <a class="skip" href="javascript:void(0)">跳转</a>
            </div>
        </div>
<%--        &lt;%&ndash;班级基本信息窗体&ndash;%&gt;--%>
        <div class="claBaseRight right">
            <input type="text" class="searchText" id="classBaseSearch" placeholder="班级、院系或入学年份">
            <input type="button" class="searchBtn" value="查找" id="classBaseSearchBtn" curObj="claBaseRight">
            <a class="insertWrap" href="ClassBaseInsert.html"><input type="button" class="insert" value="添加数据"></a>
            <hr class="line">
            <table class="showBox"></table>
            <div class="search">
                <a class="prepage" href="javascript:void(0)">上一页</a>
                <a class="nextpage" href="javascript:void(0)">下一页</a>
                <input type="text">
                <font></font>
                <a class="skip" href="javascript:void(0)">跳转</a>
            </div>
        </div>
<%--        &lt;%&ndash; 教室基本信息窗体&ndash;%&gt;--%>
        <div class="classroomBaseRight right">
            <input type="text" class="searchText" id="classroomSearch" placeholder="教室编号、容量或教室状态">
            <input type="button" class="searchBtn" value="查找" id="classroomSearchBtn" curObj="classroomBaseRight">
            <a class="insertWrap" href="ClassroomInsert.html"><input type="button" class="insert" value="添加数据"></a>
            <hr class="line">
            <table class="showBox"></table>
            <div class="search">
                <a class="prepage" href="javascript:void(0)">上一页</a>
                <a class="nextpage" href="javascript:void(0)">下一页</a>
                <input type="text">
                <font></font>
                <a class="skip" href="javascript:void(0)">跳转</a>
            </div>
        </div>
    </section>
</body>
</html>
