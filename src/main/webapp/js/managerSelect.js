let page;
let maxPage;
let ajaxArr;
let json;
$(function () {
    // 用户窗体
    $($(".box ul li")[1]).click(function () {
        //初始化页数
        page = 1;
        //初始化查询对象
        let userObj = "查询用户";
        //获取当前对象
        let curObj = $(this).attr("defined");
        //解除事件防止触发两次
        unBindEvent(curObj);
        //初始化搜索栏
        $(":text").val("");
        //初始化页数
        initPage(userObj);
        //初始化用户信息
        selectInfo(userObj, getJson(userObj));
        //获取翻页控制器
        pageController(userObj, curObj);
        //绑定修改按钮
        updateBtn(curObj, "updateUser", "modify.do?username=");
        //绑定删除按钮
        delBtn(curObj, userObj, "delUser", "delete.do", "username=");
        //显示窗体
        $(".userRight").show(300, "linear");
    })
    $(".box ul li:not(:eq(1))").click(function () {
        $('.userRight').hide();
    })

    // 学生窗体
    $($(".box ul li")[2]).click(function () {
        //初始化页数
        page = 1;
        //初始化查询对象
        let selObj = "查询学生";
        //获得当前对象
        let curObj = $(this).attr("defined");
        //解除事件防止触发两次
        unBindEvent(curObj);
        //初始化搜索栏
        $(":text").val("");
        //初始化页数
        initPage(selObj);
        //初始化学生信息
        selectInfo(selObj, getJson(selObj));
        //绑定修改按钮
        updateBtn(curObj, "updateStu", "modify.do?stuNo=");
        //绑定删除按钮
        delBtn(curObj, selObj, "delStu", "delete.do", "stuNo=");
        //获取翻页控制器
        pageController(selObj, curObj);
        //显示窗体
        $(".stuRight").show(300, "linear");
    })
    $(".box ul li:not(:eq(2))").click(function () {
        $('.stuRight').hide();
    })

    // 老师窗体
    $($(".box ul li")[3]).click(function () {
        //初始化页数
        page = 1;
        //初始化查询对象
        let teaObj = "查询教师";
        //获得当前标签对象
        let curObj = $(this).attr("defined");
        //解除事件防止触发两次
        unBindEvent(curObj);
        //初始化搜索栏
        $(":text").val("");
        //初始化页数
        initPage(teaObj);
        //初始化教师信息
        selectInfo(teaObj, getJson(teaObj));
        //绑定修改按钮
        updateBtn(curObj, "updateTea", "modify.do?teaNo=");
        //绑定删除按钮
        delBtn(curObj, teaObj, "delTea", "delete.do", "teaNo=");
        //获得翻页控制器
        pageController(teaObj, curObj);
        //显示窗体
        $(".teaRight").show(300, "linear");
    })
    $(".box ul li:not(:eq(3))").click(function () {
        $(".teaRight").hide();
    })

    // 课程表窗体
    $($(".box ul li")[4]).click(function () {
        //初始化页数
        page = 1;
        //初始化查询对象
        let ctbObj = "查询课程表信息";
        //获得当前标签对象
        let curObj = $(this).attr("defined");
        //解除事件防止触发两次
        unBindEvent(curObj);
        //初始化搜索栏
        $(":text").val("");
        //初始化页数
        initPage(ctbObj);
        //初始化教师信息
        selectInfo(ctbObj, getJson(ctbObj));
        //绑定修改按钮
        updateBtn(curObj, "updateCouTable", "modify.do?ctbId=");
        //绑定删除按钮
        delBtn(curObj, ctbObj, "delCtb", "delete.do", "id=");
        //获得翻页控制器
        pageController(ctbObj, curObj);
        //显示窗体
        $(".courseTableRight").show(300, "linear");
    })
    $(".box ul li:not(:eq(4))").click(function () {
        $(".courseTableRight").hide();
    })

    // 课程基本信息窗体
    $($(".box ul li")[5]).click(function () {
        //初始化页数
        page = 1;
        //初始化查询对象
        let cBaseObj = "查询课程基本信息";
        //获得当前标签对象
        let curObj = $(this).attr("defined");
        //解除事件防止触发两次
        unBindEvent(curObj);
        //初始化搜索栏
        $(":text").val("");
        //初始化页数
        initPage(cBaseObj);
        //初始化教师信息
        selectInfo(cBaseObj, getJson(cBaseObj));
        //绑定修改按钮
        updateBtn(curObj, "updateCouBase", "modify.do?courseNo=");
        //绑定删除按钮
        delBtn(curObj, cBaseObj, "delCb", "delete.do", "courseNo=");
        //获得翻页控制器
        pageController(cBaseObj, curObj);
        //显示窗体
        $(".couBaseRight").show(300, "linear");
    })
    $(".box ul li:not(:eq(5))").click(function () {
        $(".couBaseRight").hide();
    })

    // 班级基本信息窗体
    $($(".box ul li")[6]).click(function () {
        //初始化页数
        page = 1;
        //初始化查询对象
        let claBaseObj = "查询班级基本信息";
        //获得当前对象
        let curObj = $(this).attr("defined");
        //解除事件防止触发两次
        unBindEvent(curObj);
        //初始化搜索栏
        $(":text").val("");
        //初始化页数
        initPage(claBaseObj);
        //初始化教师信息
        selectInfo(claBaseObj, getJson(claBaseObj));
        //绑定修改按钮
        updateBtn(curObj, "updateClassBase", "modify.do?classNo=");
        //绑定删除按钮
        delBtn(curObj, claBaseObj, "delClaBase", "delete.do", "classNo=");
        //获得翻页控制器
        pageController(claBaseObj, curObj);
        //显示窗体
        $(".claBaseRight").show(300, "linear");
    })
    $(".box ul li:not(:eq(6))").click(function () {
        $(".claBaseRight").hide();
    })

    //  教室基本信息窗体
    $($(".box ul li")[7]).click(function () {
        //初始化页数
        page = 1;
        //初始化查询对象
        let classroomBaseObj = "查询教室基本信息";
        //获得当前对象
        let curObj = $(this).attr("defined");
        //解除事件防止触发两次
        unBindEvent(curObj);
        //初始化搜索栏
        $(":text").val("");
        //初始化页数
        initPage(classroomBaseObj);
        //初始化教师信息
        selectInfo(classroomBaseObj, getJson(classroomBaseObj));
        //绑定修改按钮
        updateBtn(curObj, "updateClassroom", "modify.do?classroomNo=");
        //绑定删除按钮
        delBtn(curObj, classroomBaseObj, "delClassroom", "delete.do", "classroomNo=");
        //获得翻页控制器
        pageController(classroomBaseObj, curObj);
        //显示窗体
        $(".classroomBaseRight").show(300, "linear");
    })
    $(".box ul li:not(:eq(7))").click(function () {
        $(".classroomBaseRight").hide();
    })
})

// 查询方法
function selectInfo(icon, json) {
    $(".showBox").empty();
    if (icon === "查询学生") {
        $(".stuRight .showBox").append("<tr>" +
            "<td><font>学号</font></td>" +
            "<td><font>姓名</font></td>" +
            "<td><font>性别</font></td>" +
            "<td><font>出生年月</font></td>" +
            "<td><font>学院</font></td>" +
            "<td><font>班级</font></td>" +
            "<td><font>地址</font></td>" +
            "<td><font>联系</font></td>" +
            "<td><font>操作</font></td>" +
            "</tr>")
        $.each(json, function (i, stuObj) {
            $(".stuRight .showBox").append("<tr>" +
                "<td><font>" + stuObj.no + "</font></td>" +
                "<td><font>" + stuObj.name + "</font></td>" +
                "<td><font>" + stuObj.sex + "</font></td>" +
                "<td><font>" + stuObj.birthdate + "</font></td>" +
                "<td><font>" + stuObj.dept + "</font></td>" +
                "<td><font>" + stuObj.sclass + "</font></td>" +
                "<td><font>" + stuObj.address + "</font></td>" +
                "<td><font>" + stuObj.contact + "</font></td>" +
                "<td><input type='button' value='修改' class='updateStu' req=" + stuObj.no + ">" +
                "<input type='button' value='删除' class='delStu' req=" + stuObj.no + "></td>" +
                "</tr>");
        });
    } else if (icon === "查询用户"){
        $(".userRight .showBox").append("<tr>" +
            "<td><font>用户名</font></td>" +
            "<td><font>密码</font></td>" +
            "<td><font>用户类别</font></td>" +
            "<td><font>操作</font></td>" +
            "</tr>");
        $.each(json, function (i, userObj) {
            $(".userRight .showBox").append("<tr>" +
                "<td><font>" + userObj.username + "</font></td>" +
                "<td><font>" + userObj.password + "</font></td>" +
                "<td><font>" + userObj.usertype + "</font></td>" +
                "<td><input type='button' value='修改' class='updateUser' req=" + userObj.username + ">" +
                "<input type='button' value='删除' class='delUser' req=" + userObj.username + "></td>" +
                "</tr>");
        })
    } else if (icon === "查询教师") {
        $(".teaRight .showBox").append("<tr>" +
            "<td><font>教工编号</font></td>" +
            "<td><font>姓名</font></td>" +
            "<td><font>院系</font></td>" +
            "<td><font>专业方向</font></td>" +
            "<td><font>职称</font></td>" +
            "<td><font>操作</font></td>" +
            "</tr>");
        $.each(json, function (i, teaObj) {
            $(".teaRight .showBox").append("<tr>" +
                "<td><font>" + teaObj.no + "</font></td>" +
                "<td><font>" + teaObj.name + "</font></td>" +
                "<td><font>" + teaObj.dept + "</font></td>" +
                "<td><font>" + teaObj.major + "</font></td>" +
                "<td><font>" + teaObj.positionalTitle + "</font></td>" +
                "<td><input type='button' class='updateTea' value='修改' req=" + teaObj.no + ">" +
                "<input type='button' value='删除' class='delTea' req="+ teaObj.no +"></td>" +
                "</tr>");
        })
    } else if (icon === "查询课程表信息") {
        $(".courseTableRight .showBox").append("<tr>" +
            "<td><font>排课id</font></td>" +
            "<td><font>课程号</font></td>" +
            "<td><font>班级号</font></td>" +
            "<td><font>授课教师编号</font></td>" +
            "<td><font>授课时间</font></td>" +
            "<td><font>授课地点</font></td>" +
            "<td><font>操作</font></td>" +
            "</tr>");
        $.each(json, function (i, ctbObj) {
            $(".courseTableRight .showBox").append("<tr>" +
                "<td><font>" + ctbObj.id + "</font></td>" +
                "<td><font>" + ctbObj.courseNo + "</font></td>" +
                "<td><font>" + ctbObj.cclass + "</font></td>" +
                "<td><font>" + ctbObj.teacherNo + "</font></td>" +
                "<td><font>" + ctbObj.time + "</font></td>" +
                "<td><font>" + ctbObj.site + "</font></td>" +
                "<td><input type='button' class='updateCouTable' value='修改' req=" + ctbObj.id + ">" +
                "<input type='button' value='删除' class='delCtb' req=" + ctbObj.id + "></td>" +
                "</tr>");
        })
    } else if (icon === "查询课程基本信息") {
        $(".couBaseRight .showBox").append("<tr>" +
            "<td><font>课程号</font></td>" +
            "<td><font>课程名</font></td>" +
            "<td><font>开课学期</font></td>" +
            "<td><font>学时</font></td>" +
            "<td><font>学分</font></td>" +
            "<td><font>操作</font></td>" +
            "</tr>");
        $.each(json, function (i, cbObj) {
            $(".couBaseRight .showBox").append("<tr>" +
                "<td><font>" + cbObj.courseNo + "</font></td>" +
                "<td><font>" + cbObj.cname + "</font></td>" +
                "<td><font>" + cbObj.term + "</font></td>" +
                "<td><font>" + cbObj.period + "</font></td>" +
                "<td><font>" + cbObj.credit + "</font></td>" +
                "<td><input type='button' value='修改' class='updateCouBase' req=" + cbObj.courseNo + ">" +
                "<input type='button' value='删除' class='delCb' req=" + cbObj.courseNo + "></td>" +
                "</tr>");
        })
    } else if (icon === "查询班级基本信息") {
        $(".claBaseRight .showBox").append("<tr>" +
            "<td><font>班级号</font></td>" +
            "<td><font>院系</font></td>" +
            "<td><font>班级人数</font></td>" +
            "<td><font>入学年份</font></td>" +
            "<td><font>辅导员</font></td>" +
            "<td><font>操作</font></td>" +
            "</tr>");
        $.each(json, function (i, clabObj) {
            $(".claBaseRight .showBox").append("<tr>" +
                "<td><font>" + clabObj.classNo + "</font></td>" +
                "<td><font>" + clabObj.dept + "</font></td>" +
                "<td><font>" + clabObj.classNum + "</font></td>" +
                "<td><font>" + clabObj.enYear + "</font></td>" +
                "<td><font>" + clabObj.instructor + "</font></td>" +
                "<td><input type='button' value='修改' class='updateClassBase' req=" + clabObj.classNo + ">" +
                "<input type='button' value='删除' class='delClaBase' req=" + clabObj.classNo + "></td>" +
                "</tr>");
        })
    } else if (icon === "查询教室基本信息") {
        $(".classroomBaseRight .showBox").append("<tr>" +
            "<td><font>教室编号</font></td>" +
            "<td><font>容量</font></td>" +
            "<td><font>是否多媒体教室</font></td>" +
            "<td><font>教室状态</font></td>" +
            "<td><font>操作</font></td>" +
            "</tr>");
        $.each(json, function (i, classroomObj) {
            let isTrue = (classroomObj.isMulClassroom === '1')? '是' : '不是';
            $(".classroomBaseRight .showBox").append("<tr>" +
                "<td><font>" + classroomObj.classroomNo + "</font></td>" +
                "<td><font>" + classroomObj.capacity + "</font></td>" +
                "<td><font>" + isTrue + "</font></td>" +
                "<td><font>" + classroomObj.status + "</font></td>" +
                "<td><input type='button' value='修改' class='updateClassroom' req=" + classroomObj.classroomNo + ">" +
                "<input type='button' value='删除' class='delClassroom' req=" + classroomObj.classroomNo + "></td>" +
                "</tr>");
        })
    }
}

// 获得json对象
function getJson(type) {
    $.ajax({
        async: false,
        url: "query.do",
        data: "select=" + type + "&page=" + page,
        dataType: "json",
        success:function (resp) {
            ajaxArr = resp;
        }
    })
    return ajaxArr;
}

// 翻页控制器
function pageController(icon, s) {
    let str = "." + s;
    //上一页
    $(str + " .prepage").click(function () {
        page--;
        if (page >= 1) {
            $(str + " .showBox").empty();
            selectInfo(icon, getJson(icon));
        } else {
            page++;
        }
        $(str + " .search font").text(page + "/" + maxPage);
        $(":text").val("");
    })
    //下一页
    $(str + " .nextpage").click(function () {
        page++;
        if (page <= maxPage){
            $(str + " .showBox").empty();
            selectInfo(icon, getJson(icon));
        } else {
            page--;
        }
        $(str + " .search font").text(page + "/" + maxPage);
        $(":text").val("");
    })
    //跳转
    let inputPage
    $(str + " .skip").click(function () {
        inputPage = $(str + " .search :text").val();
        if (inputPage === "") return;
        console.log(inputPage)
        if (parseInt(inputPage) >= 1 && parseInt(inputPage) <= maxPage && maxPage > 1) {
            page = inputPage;
            $(str + " .showBox").empty();
            selectInfo(icon, getJson(icon));
            $(":text").val("");
            $(str + " .search font").text(page + "/" + maxPage);
        } else {
            alert('请输入有效的页数！');
            $(":text").val("");
            inputPage = "";
        }
    })
}

// 初始化总页数
function initPage(type) {
    $.get("query.do", "pageSize=maxPage&select=" + type, function (resp) {
        maxPage = resp;
        $(".search font").text(page + "/" + maxPage);
    }, "text");
}

// 修改按钮
function updateBtn(curObj, selector, url) {
    $("." + curObj + " .showBox").on("click", "." + selector, function () {
        location.href = url + $(this).attr("req");
    })
}

// 删除按钮
function delBtn(curObj, selObj, selector, url, dataName) {
    $("." + curObj + " .showBox").on("click", "." + selector, function () {
        if (!confirm("确定要删除此条数据？")) return;
        $.ajax({
            url: url,
            data: dataName + $(this).attr("req"),
            success: function (resp) {
                if (resp < page) {
                    page--;
                }
                maxPage = resp;
                $(".search font").text(page + "/" + maxPage);
                selectInfo(selObj, getJson(selObj));
            }
        })
    })
}

//解除事件防多次触发机制
function unBindEvent(curObj) {
    $("." + curObj + " .nextpage").unbind();
    $("." + curObj + " .prepage").unbind();
    $("." + curObj + " .showBox").off("click");
}