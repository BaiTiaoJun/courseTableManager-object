<%--
  Created by IntelliJ IDEA.
  User: 27310
  Date: 2021/12/4
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>课程表信息查询界面</title>
    <link rel="stylesheet" href="css/CouSelectJsp.css">
    <link rel="stylesheet" href="css/HeaderAndBackground.css">
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript" src="js/couSelect.js"></script>
</head>
<body>
<div class="base">
    <header class="header">
        <h5>${name}用户，欢迎访问课程表信息表</h5>
        <select class="sel">
            <option selected disabled>--请选择周次--</option>
        </select>
        <input type="submit" class="user" value="查看${userType}信息">
        <input type="button" class="xg" src="UserUpdate.html" value="修改密码">
    </header>
    <div class="box">
        <table class="tb">
            <tr class="tr1">
                <td></td>
                <td>周一</td>
                <td>周二</td>
                <td>周三</td>
                <td>周四</td>
                <td>周五</td>
                <td>周六</td>
            </tr>
            <tr style="height: 20rem">
                <td><font>1</br></br></br>2</font></td>
                <td>
                <c:forEach items="${requestScope.list}" var="eleCou">
                    <c:set var="time" value="${eleCou.time}"/>
                    <c:if test="${f:contains(time, '星期一') && f:contains(time, '第1-2节')}">
                        <c:forEach items="${requestScope.nameList}" var="eleName">
                            <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                名称：${eleName.cname}
                            </c:if>
                        </c:forEach><br>
                        班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                        <c:forEach items="${requestScope.noList}" var="eleNo">
                            <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                老师：${eleNo.name}
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期二') && f:contains(time, '第1-2节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期三') && f:contains(time, '第1-2节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期四') && f:contains(time, '第1-2节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期五') && f:contains(time, '第1-2节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期六') && f:contains(time, '第1-2节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr style="height: 20rem">
                <td><font>3</br></br></br>4</font></td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期一') && f:contains(time, '第3-4节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期二，第3-4节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期三') && f:contains(time, '第3-4节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期四') && f:contains(time, '第3-4节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期五') && f:contains(time, '第3-4节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期六') && f:contains(time, '第3-4节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr style="height: 20rem">
                <td><font>5</br></br></br>6</font></td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期一') && f:contains(time, '第5-6节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期二') && f:contains(time, '第5-6节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期三') && f:contains(time, '第5-6节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期四') && f:contains(time, '第5-6节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期五') && f:contains(time, '第5-6节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期六') && f:contains(time, '第5-6节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td><font>7</br></br></br>8</font></td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期一') && f:contains(time, '第7-8节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期二') && f:contains(time, '第7-8节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期三') && f:contains(time, '第7-8节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期四') && f:contains(time, '第7-8节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期五') && f:contains(time, '第7-8节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期六') && f:contains(time, '第7-8节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td><font>9</br></br></br>10</font></td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期一') && f:contains(time, '第9-10节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期二') && f:contains(time, '第9-10节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期三') && f:contains(time, '第9-10节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期四') && f:contains(time, '第9-10节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期五') && f:contains(time, '第9-10节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${requestScope.list}" var="eleCou">
                        <c:set var="time" value="${eleCou.time}"/>
                        <c:if test="${f:contains(time, '星期六') && f:contains(time, '第9-10节')}">
                            <c:forEach items="${requestScope.nameList}" var="eleName">
                                <c:if test="${eleName.courseNo eq eleCou.courseNo}">
                                    名称：${eleName.cname}
                                </c:if>
                            </c:forEach><br>
                            班级：${eleCou.cclass}<br>教室：${eleCou.site}<br>
                            <c:forEach items="${requestScope.noList}" var="eleNo">
                                <c:if test="${eleNo.no eq eleCou.teacherNo}">
                                    老师：${eleNo.name}
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
