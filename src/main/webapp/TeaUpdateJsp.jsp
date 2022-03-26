<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/13
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师修改界面</title>
    <link rel="stylesheet" href="css/Modify.css">
    <link rel="stylesheet" href="css/TeaModify.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/returnManagerSelectJsp.js"></script>
    <script type="text/javascript" src="js/doAjaxModify.js"></script>
    <script type="text/javascript" src="js/reset.js"></script>
    <script type="text/javascript">
        $(function () {
            reset("teaNo=${requestScope.teaNo}");

            $('#teaDept').val('${requestScope.teaDept}');
            $('#teaMajor').val('${requestScope.teaMajor}');
            $('#teaPosTitle').val('${requestScope.teaPosTitle}');
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
      <input type="hidden" id="teaNo" value="${requestScope.teaNo}"><br>
      <font>姓名：</font><input class="in" id="teaName" type="text" value="${requestScope.teaName}"><br>
      <font>院系：</font>
        <select id="teaDept" style="width: 36%">
            <option>计算机与科学学院</option>
            <option>管理学院</option>
            <option>外语学院</option>
            <option>园林学院</option>
            <option>机械学院</option>
            <option>生物与化学学院</option>
            <option>艺术学院</option>
            <option>建筑学院</option>
        </select><br>
      <font>专业方向：</font>
        <select id="teaMajor">
            <option>python</option>
            <option>数据库原理与技术</option>
            <option>软件设计</option>
            <option>计算机网络</option>
            <option>java</option>
            <option>android</option>
            <option>javasScript</option>
            <option>计算机基础</option>
            <option>jsp</option>
            <option>大学英语</option>
            <option>高数</option>
            <option>ios</option>
            <option>c++</option>
        </select><br>
      <font>职称：</font>
        <select id="teaPosTitle" style="width: 36%">
            <option>正高级教师</option>
            <option>高级教师</option>
            <option>一级教师</option>
            <option>二级教师</option>
            <option>三级教师</option>
        </select><br>
      <input class="submitTea" type="submit" value="提交">
      <input class="reset" type="reset" value="重置">
    </div>
  </section>
</body>
</html>
