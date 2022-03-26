<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/14
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>班级基本信息修改</title>
  <link rel="stylesheet" href="css/Modify.css">
  <link rel="stylesheet" href="css/ClassBaseModify.css">
  <link rel="stylesheet" href="css/HeaderAndBackground.css">
  <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
  <script type="text/javascript" src="js/returnManagerSelectJsp.js"></script>
  <script type="text/javascript" src="js/dateSelected.js"></script>
  <script type="text/javascript" src="js/reset.js"></script>
  <script type="text/javascript" src="js/doAjaxModify.js"></script>
  <%--    获取每个记录的默认时间--%>
  <script type="text/javascript">
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
      reset("classNo=${requestScope.classNo}");
      //取默认事件
      $('#classDept').val('${requestScope.dept}');
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
    <input type="hidden" id="classNo" value="${requestScope.classNo}"><br>
    <font>院系：</font>
    <select id="classDept" style="width: 20rem">
      <option>计算机与科学学院</option>
      <option>管理学院</option>
      <option>外语学院</option>
      <option>园林学院</option>
      <option>机械学院</option>
      <option>生物与化学学院</option>
      <option>艺术学院</option>
      <option>建筑学院</option>
    </select><br>
    <font>班级人数：</font><input class="in" type="text" id="classStuNum" value="${requestScope.classStuNum}"><br>
    <font>入学年份：</font>
    <select class="selYear"></select>
    <select class="selMonth"></select>
    <select class="selDay"></select><br>
    <font>辅导员：</font><input id="instructor" class="in" type="text" value="${requestScope.instructor}"><br>
    <input class="submitClassBase" type="submit" value="提交">
    <input class="reset" type="reset" value="重置">
  </div>
</section>
</body>
</html>
