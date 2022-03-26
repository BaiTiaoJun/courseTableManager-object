<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/4
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>老师信息查询界面</title>
    <link rel="stylesheet" href="css/CouSelectJsp.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/sender.js"></script>
</head>
<body>
<div class="base">
    <header class="header">
        <a href="login.html"><h5>${username}用户，欢迎访问课程表信息表</h5></a>
        <input type="submit" class="xsb" value="查${userType}表">
        <input type="button" class="xg" src="UserUpdate.html" value="修改密码">
    </header>
    <table class="tb">
        <tr>
            <td>排课ID</td>
            <td>课程号</td>
            <td>班级号</td>
            <td>授课老师编号</td>
            <td>授课时间</td>
            <td>授课地点</td>
        </tr>
        <s:forEach items="${requestScope.list}" var="eleCou">
            <tr align="center">
                <td align="center">${eleCou.id}</td>
                <td align="center">${eleCou.courseNo}</td>
                <td align="center">${eleCou.cclass}</td>
                <td align="center">${eleCou.teacherNo}</td>
                <td align="center">${eleCou.time}</td>
                <td align="center">${eleCou.site}</td>
            </tr>
        </s:forEach>
    </table>
</div>
</body>
</html>
