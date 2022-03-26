<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/13
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>课程表信息修改界面</title>
  <link rel="stylesheet" href="css/Modify.css">
  <link rel="stylesheet" href="css/CouTableModify.css">
  <link rel="stylesheet" href="css/HeaderAndBackground.css">
  <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
  <script type="text/javascript" src="js/returnManagerSelectJsp.js"></script>
  <script type="text/javascript" src="js/doAjaxModify.js"></script>
  <script type="text/javascript" src="js/ctbTime.js"></script>
  <script type="text/javascript" src="js/reset.js"></script>
  <script type="text/javascript" src="js/CourseTableInsert.js"></script>
  <script type="text/javascript">
    $(function () {
        $(".ctbTimeWeek option").filter(function () {
            return $(this).text() === "${requestScope.week}"
        }).attr("selected", true);
        $(".ctbTimeWhatDay option").filter(function () {
            return $(this).text() === "${requestScope.whatDay}"
        }).attr("selected", true);
        $(".ctbTimeSessionNo option").filter(function () {
            return $(this).text() === "${requestScope.sessionNo}"
        }).attr("selected", true);
        //重置事件
        reset("ctbId=${requestScope.courseId}");
        //取默认值
        $('#ctbCouNo').val('${requestScope.courseNo}');
        $('#ctbClassNo').val('${requestScope.classNo}');
        $('#ctbTeaNo').val('${requestScope.teacherNo}');
        $('#ctbSite').val('${requestScope.site}');
    })
  </script>
  <style type="text/css">
    #ctbSite {
      width: 15%;
    }
    #ctbTeaNo {
      width: 19%;
    }
    #ctbClassNo {
      width: 23%;
    }
    .ctbTimeSessionNo {
      width: 17%;
    }
  </style>
</head>
<body>
  <header class="header">
    <input type="button" class="managerPage" value="返回管理员首页">
  </header>
  <div id="dialog">信息修改成功！3秒后自动跳转自登陆界面</div>
  <section class="infoPage">
    <div class="left"></div>
    <div class="right">
      <input type="hidden" id="ctbId" value="${requestScope.courseId}">
      <font>课程号：</font>
      <select id="ctbCouNo"></select><br>
      <font>班级号：</font>
      <select id="ctbClassNo"></select><br>
      <font>授课老师编号：</font>
      <select id="ctbTeaNo"></select><br>
      <font>授课时间：</font>
      <select class="ctbTimeWeek"></select>
      <select class="ctbTimeWhatDay"></select>
      <select class="ctbTimeSessionNo"></select><br>
      <font>授课地点：</font>
      <select id="ctbSite"></select><br>
      <input class="submitCtb" type="submit" value="提交">
      <input class="reset" type="reset" value="重置">
    </div>
  </section>
</body>
</html>
