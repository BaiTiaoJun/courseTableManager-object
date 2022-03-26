<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/11/29
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息修改界面</title>
    <link rel="stylesheet" href="css/Modify.css">
    <link rel="stylesheet" href="css/StuModify.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/dateSelected.js"></script>
    <script type="text/javascript" src="js/doAjaxModify.js"></script>
    <script type="text/javascript" src="js/returnManagerSelectJsp.js"></script>
    <script type="text/javascript" src="js/reset.js"></script>
<%--    从对象中获取性别的初始值--%>
    <script type="text/javascript">
        <c:set var="sex" value="${requestScope.stuSex}"/>
        <c:choose>
            <c:when test="${'男' eq sex}">
                $(function () {
                    $("input[name='sex'][value=男]").attr("checked", true);
                })
            </c:when>
            <c:otherwise>
                $(function () {
                    $("input[name='sex'][value=女]").attr("checked", true);
                })
            </c:otherwise>
        </c:choose>
    </script>

    <script type="text/javascript">
        //获取每个记录的默认时间
        $(function () {
            $(".selYear option").filter(function () {
                return $(this).text()==${requestScope.year};
            }).attr("selected", true);
            $(".selMonth option").filter(function () {
                return $(this).text()==${requestScope.month};
            }).attr("selected", true);
            $(".selDay option").filter(function () {
                return $(this).text()==${requestScope.day};
            }).attr("selected", true);
            //重置事件
            reset("stuNo=${requestScope.stuNo}");
            //默认学院
            $('#dept').val('${requestScope.stuDept}');
        })
    </script>
</head>
<body>
    <header class="header">
        <input type="button" class="managerPage" value="返回管理员首页">
    </header>
    <div id="dialog">信息修改成功！3秒后自动跳转自登陆界面</div>
    <section class="infoPage">
        <div class="left"></div>
        <div class="right">
            <input type="hidden" id="stuId" value="${requestScope.stuNo}">
            <font>姓名：</font><input type="text" id="stuName" class="in" value="${requestScope.stuName}"><br>
            <font>性别：</font>
            <input class="selSex" id="male" name="sex" type="radio" value="男"><font class="fontman">男</font>
            <input class="selSex" id="female" name="sex" type="radio" value="女"><font class="fontwomen">女</font><br>
            <font>出生年月日：</font>
            <select class="selYear" id="year"></select>
            <select class="selMonth" id="month"></select>
            <select class="selDay" id="day"></select><br>
            <font>学院：</font>
            <select id="dept" style="width: 30%">
                <option>计算机与科学学院</option>
                <option>管理学院</option>
                <option>外语学院</option>
                <option>园林学院</option>
                <option>机械学院</option>
                <option>生物与化学学院</option>
                <option>艺术学院</option>
                <option>建筑学院</option>
            </select><br>
<%--            <input type="text" id="dept" class="in" value="${requestScope.stuDept}"><br>--%>
            <font>班级：</font><input type="text" id="class" class="in" value="${requestScope.stuSclass}"><br>
            <font>地址：</font><input type="text" id="addr" class="in" value="${requestScope.stuAddress}"><br>
            <font>联系：</font><input type="text" id="contact" class="in" value="${requestScope.stuContact}"><br>
            <input class="submitStu" type="submit" value="提交">
            <input class="reset" type="reset" value="重置">
        </div>
    </section>
</body>
</html>