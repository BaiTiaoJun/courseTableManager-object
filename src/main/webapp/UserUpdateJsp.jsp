<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/12
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改界面</title>
    <link rel="stylesheet" href="css/Modify.css">
    <link rel="stylesheet" href="css/UserModify.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/returnManagerSelectJsp.js"></script>
    <script type="text/javascript" src="js/doAjaxModify.js"></script>
    <script type="text/javascript" src="js/reset.js"></script>
    <script type="text/javascript">
        $(function () {
            let text = '${requestScope.usertype}';
            $(".selType option[id='"+text+"']").attr("selected", true);
            reset("username=${requestScope.username}");
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
            <input type="hidden" id="user" value="${requestScope.username}">
            <font>密码：</font><input type="text" class="in" id="pass" value="${requestScope.password}"><br>
            <font>用户类别：</font>
            <select class="selType" id="type">
                <option id="学生">学生</option>
                <option id="老师">老师</option>
                <option id="管理员">管理员</option>
            </select>
            <input class="submitUser" type="submit" value="提交">
            <input class="reset" type="reset" value="重置">
        </div>
    </section>
</body>
</html>
