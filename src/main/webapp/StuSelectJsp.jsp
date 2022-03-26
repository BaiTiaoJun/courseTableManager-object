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
    <link rel="stylesheet" href="css/TeaAndStuSelect.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/couSelect.js"></script>
    <script type="text/javascript" src="js/exit.js"></script>
</head>
<body>
<center>
    <div class="base">
        <header class="header">
            <h5>${name}同学，欢迎访问您的个人信息</h5>
            <input type="button" value="注销" class="exit">
            <input type="button" class="kcb" value="查看课程表">
            <input type="button" class="xg" value="修改密码">
        </header>
        <div class="box">
            <div class="left">
                <p><font>学号：</font>${stuInfo.no}</p>
                <p><font>姓名：</font>${stuInfo.name}</p>
                <p><font>性别：</font>${stuInfo.sex}</p>
                <p><font>出生年月：</font>${stuInfo.birthdate}</p>
                <p><font>学院：</font>${stuInfo.dept}</p>
                <p><font>班级：</font>${stuInfo.sclass}</p>
                <p><font>地址：</font>${stuInfo.address}</p>
                <p><font>联系：</font>${stuInfo.contact}</p>
            </div>
            <div class="right">

            </div>
        </div>
    </div>
</center>
</body>
</html>
