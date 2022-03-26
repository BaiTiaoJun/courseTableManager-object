<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/14
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程基本信息修改</title>
    <link rel="stylesheet" href="css/Modify.css">
    <link rel="stylesheet" href="css/CouBaseModify.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/returnManagerSelectJsp.js"></script>
    <script type="text/javascript" src="js/doAjaxModify.js"></script>
    <script type="text/javascript" src="js/reset.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".couTerm option[id='" + '${requestScope.term}' + "']").attr("selected", true);
            //重置事件
            reset("courseNo=${requestScope.courseNo}");
            //取默认值
            $('#couName').val('${requestScope.cname}');
            $('#couPeriod').val('${requestScope.period}');
            $('#couCredit').val('${requestScope.credit}');
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
        <input id="couNo" type="hidden" value="${requestScope.courseNo}"><br>
        <font>课程名：</font>
        <select id="couName" style="width: 30%">
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
        <font>开课学期：</font>
        <select class="couTerm">
            <option id="第一学期">第一学期</option>
            <option id="第二学期">第二学期</option>
            <option id="第三学期">第三学期</option>
            <option id="第四学期">第四学期</option>
            <option id="第五学期">第五学期</option>
            <option id="第六学期">第六学期</option>
            <option id="第七学期">第七学期</option>
            <option id="第八学期">第八学期</option>
            <option id="第九学期">第九学期</option>
            <option id="第十学期">第十学期</option>
        </select><br>
        <font>学时：</font>
        <select id="couPeriod" style="text-align: center">
            <option>13</option>
            <option>14</option>
            <option>15</option>
            <option>16</option>
            <option>17</option>
        </select><br>
        <font>学分：</font>
        <select id="couCredit" style="text-align: center">
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select><br>
        <input class="submitCb" type="submit" value="提交">
        <input class="reset" type="reset" value="重置">
    </div>
</section>
</body>
</html>
