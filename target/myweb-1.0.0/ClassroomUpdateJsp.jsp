<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/14
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>修改教室基本信息</title>
  <link rel="stylesheet" href="css/Modify.css">
  <link rel="stylesheet" href="css/ClassroomModify.css">
  <link rel="stylesheet" href="css/HeaderAndBackground.css">
  <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
  <script type="text/javascript" src="js/returnManagerSelectJsp.js"></script>
  <script type="text/javascript" src="js/reset.js"></script>
  <script type="text/javascript" src="js/doAjaxModify.js"></script>
  <script type="text/javascript">
    <c:set var="isMulClassroom" value="${requestScope.isMulClassroom}"/>
    <c:choose>
    <c:when test="${'true' eq isMulClassroom}">
    $(function () {
      $("input[name='isMulClassroom'][value='1']").attr("checked", true);
    })
    </c:when>
    <c:otherwise>
    $(function () {
      $("input[name='isMulClassroom'][value='0']").attr("checked", true);
    })
    </c:otherwise>
    </c:choose>

    <c:set var="classroomStatus" value="${requestScope.status}"/>
    <c:choose>
    <c:when test="${'使用' eq classroomStatus}">
    $(function () {
      $("input[name='classroomStatus'][value='使用']").attr("checked", true);
    })
    </c:when>
    <c:otherwise>
    $(function () {
      $("input[name='classroomStatus'][value='空闲']").attr("checked", true);
    })
    </c:otherwise>
    </c:choose>
    $(function () {
      reset("classroomNo=${requestScope.classroomNo}");
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
    <input type="hidden" id="classroomNo" value="${requestScope.classroomNo}">
    <font>容量：</font><input type="text" class="in" id="capacity" value="${requestScope.capacity}"><br>
    <font>是否是多媒体教室：</font>
    <input type="radio" name="isMulClassroom" class="isMul" value="1">是
    <input type="radio" name="isMulClassroom" class="isMul" id="false" value="0">不是<br>
    <font>教室状态：</font>
    <input type="radio" name="classroomStatus" class="isUse" id="use" value="使用">使用
    <input type="radio" name="classroomStatus" class="isUse" id="inuse" value="空闲">空闲<br>
    <input class="submitClassroom" type="submit" value="提交">
    <input class="reset" type="reset" value="重置">
  </div>
</section>
</body>
</html>
