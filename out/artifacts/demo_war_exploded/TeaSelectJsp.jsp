<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/1
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>老师信息查询界面</title>
    <meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
    <link rel="stylesheet" href="css/TeaSelectJsp.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/sender.js"></script>
</head>
<body>
<center>
    <div class="base">
        <header class="header">
            <a href="login.html"><h5>${username}用户，欢迎访问老师信息表</h5></a>
            <input type="button" class="kcb" value="查看课程表">
            <input type="button" class="xg" value="修改密码">
        </header>
        <table class="tb">
            <tr>
                <td>职工编号</td>
                <td>姓名</td>
                <td>院系</td>
                <td>专业方向</td>
                <td>职称</td>
            </tr>
            <s:forEach items="${requestScope.list}" var="eleTea">
                <tr>
                    <td>${eleTea.no}</td>
                    <td>${eleTea.name}</td>
                    <td>${eleTea.dept}</td>
                    <td>${eleTea.major}</td>
                    <td>${eleTea.positionalTitle}</td>
                </tr>
            </s:forEach>
        </table>
    </div>
</center>
</body>
</html>
