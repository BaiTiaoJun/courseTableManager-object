<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/3
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户密码修改界面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
    <link rel="stylesheet" href="css/UserUpdateJsp.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/updateUser.js"></script>
</head>
<body>
    <header class="header">
        <input type="button" class="return" value="返回学生信息表">
    </header>
    <div class="box">
        <div class="table">
            <h4>用户：${username}</h4>
            <h4>原密码：<input type="password" class="in" id="one"></h4>
            <h4>新密码：<input type="password" class="in" id="two"></h4>
            <h4>确认密码：<input type="password" class="in" id="three"></h4>
            <input type="button" value="确认提交" class="submit">
        </div>
    </div>
</body>
</html>
