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
    <link rel="stylesheet" href="css/TeaAndStuSelect.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/couSelect.js"></script>
    <script type="text/javascript" src="js/exit.js"></script>
    <style>
        .box .left p {
            margin-top: 3.3rem;
        }
    </style>
</head>
<body>
<center>
    <div class="base">
        <header class="header">
            <h5>${name}老师，欢迎访问您个人信息</h5>
            <input type="button" value="注销" class="exit">
            <input type="button" class="kcb" value="查看课程表">
            <input type="button" class="xg" value="修改密码">
        </header>
        <div class="box">
            <div class="left">
                <p><font>职工编号：</font>${teaInfo.no}</p>
                <p><font>姓名：</font>${teaInfo.name}</p>
                <p><font>院系：</font>${teaInfo.dept}</p>
                <p><font>专业方向：</font>${teaInfo.major}</p>
                <p><font>职称：</font>${teaInfo.positionalTitle}</p>
            </div>
            <div class="right">

            </div>
    </div>
</center>
</body>
</html>