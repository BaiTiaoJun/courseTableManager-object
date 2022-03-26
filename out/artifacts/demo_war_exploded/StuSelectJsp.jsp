<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/11/29
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息查询界面</title>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html">
    <link rel="stylesheet" href="css/StuSelectJsp.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/sender.js"></script>
</head>
<body>
<center>
    <div class="base">
        <header class="header">
            <a href="login.html"><h5>${username}用户，欢迎访问学生信息表</h5></a>
            <input type="button" class="kcb" value="查看课程表">
            <input type="button" class="xg" value="修改密码">
        </header>
        <table  class="tb">
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>出生年月</td>
                <td>学院</td>
                <td>班级</td>
                <td>地址</td>
                <td>联系</td>
            </tr>
            <s:forEach items="${requestScope.list}" var="eleStu">
                <tr align="center">
                    <td align="center">${eleStu.no}</td>
                    <td align="center">${eleStu.name}</td>
                    <td align="center">${eleStu.sex}</td>
                    <td align="center">${eleStu.birthdate}</td>
                    <td align="center">${eleStu.dept}</td>
                    <td align="center">${eleStu.sclass}</td>
                    <td align="center">${eleStu.address}</td>
                    <td align="center">${eleStu.contact}</td>
                </tr>
            </s:forEach>
        </table>
    </div>
</center>
</body>
</html>
