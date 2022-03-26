let queryResult;
let val = "";
$(function () {
    let getJsonData;
    let getPageSizeData;
    let type;
    let selector;
    let dataName;
    let searchId;
    //查找学生记录
    $("#stuSearchBtn").on("click", function () {
        page = 1;
        //获取搜索框的查询条件
        if ($('#stuSearch').val() !== "") {
            val = $("#stuSearch").val();
        }
        //搜索框为空不执行搜索退出操作
        if (val === "") return;
        //初始化参数查询参数
        getJsonData = "reqStuParam=" + val + "&type=stu";
        getPageSizeData = "reqStuParam=" + val + "&pageSizeBySearch=pageSize";
        type = "查询学生"
        selector = "delStu";
        dataName = "stuNo=";
        searchId = "stuSearch";
        //获得当前对象
        let curObj = $(this).attr("curObj");
        //获取搜索结果并显示
        queryInfo(type, getPageSizeData, getJsonData, curObj, selector, dataName, searchId);
    })
    //查找老师记录
    $("#teaSearchBtn").on("click", function () {
        page = 1;
        if ($('#teaSearch').val() !== "") {
            val = $("#teaSearch").val();
        }
        //搜索框为空不执行搜索退出操作
        if (val === "") return;
        //初始化参数查询参数
        getJsonData = "reqTeaParam=" + val + "&type=tea";
        getPageSizeData = "reqTeaParam=" + val + "&pageSizeBySearch=pageSize";
        type = "查询教师";
        selector = "delTea";
        dataName = "teaNo=";
        searchId = "teaSearch";
        //获得当前对象
        let curObj = $(this).attr("curObj");
        //获取搜索结果并显示
        queryInfo(type, getPageSizeData, getJsonData, curObj, selector, dataName, searchId);
    })
    //查找班级记录
    $("#classBaseSearchBtn").on("click", function () {
        page = 1;
        if ($('#classBaseSearch').val() !== "") {
            val = $("#classBaseSearch").val();
        }
        //搜索框为空不执行搜索退出操作
        if (val === "") return;
        //初始化参数查询参数
        getJsonData = "reqClassBaseParam=" + val + "&type=classBase";
        getPageSizeData = "reqClassBaseParam=" + val + "&pageSizeBySearch=pageSize";
        type = "查询班级基本信息";
        selector = "delClaBase";
        dataName = "classNo=";
        searchId = "classBaseSearch";
        //获得当前对象
        let curObj = $(this).attr("curObj");
        //获取搜索结果并显示
        queryInfo(type, getPageSizeData, getJsonData, curObj, selector, dataName, searchId);
    })
    //查找教室记录
    $("#classroomSearchBtn").on("click", function () {
        page = 1;
        if ($('#classroomSearch').val() !== "") {
            val = $("#classroomSearch").val();
        }
        //搜索框为空不执行搜索退出操作
        if (val === "") return;
        getJsonData = "reqClassroomParam=" + val + "&type=classroom";
        getPageSizeData = "reqClassroomParam=" + val + "&pageSizeBySearch=pageSize";
        type = "查询教室基本信息";
        selector = "delClassroom";
        dataName = "classroomNo=";
        searchId = "classroomSearch";
        //获得当前对象
        let curObj = $(this).attr("curObj");
        //获取搜索结果并显示
        queryInfo(type, getPageSizeData, getJsonData, curObj, selector, dataName, searchId);
    })
    //查找课程基本信息
    $("#courseBaseSearchBtn").on("click", function () {
        page = 1;
        if ($('#courseBaseSearch').val() !== "") {
            val = $("#courseBaseSearch").val();
        }
        //搜索框为空不执行搜索退出操作
        if (val === "") return;
        getJsonData = "reqCourseBaseParam=" + val + "&type=courseBase";
        getPageSizeData = "reqCourseBaseParam=" + val + "&pageSizeBySearch=pageSize";
        type = "查询课程基本信息";
        selector = "delCb";
        dataName = "courseNo=";
        searchId = "courseBaseSearch";
        //获得当前对象
        let curObj = $(this).attr("curObj");
        //获取搜索结果并显示
        queryInfo(type, getPageSizeData, getJsonData, curObj, selector, dataName, searchId);
    })
    //查找课程表信息
    $("#courseTableSearchBtn").on("click", function () {
        page = 1;
        if ($('#courseTableSearch').val() !== "") {
            val = $("#courseTableSearch").val();
        }
        //搜索框为空不执行搜索退出操作
        if (val === "") return;
        getJsonData = "reqCourseTableParam=" + val + "&type=courseTable";
        getPageSizeData = "reqCourseTableParam=" + val + "&pageSizeBySearch=pageSize";
        type = "查询课程表信息";
        selector = "delCtb";
        dataName = "id=";
        searchId = "courseTableSearch";
        //获得当前对象
        let curObj = $(this).attr("curObj");
        //获取搜索结果并显示
        queryInfo(type, getPageSizeData, getJsonData, curObj, selector, dataName, searchId);
    })
})

//初始化查询信息页面
function queryInfo(type, getPageSizeData, getJsonData, curObj, selector, dataName, searchId) {
    queryResult = undefined;
    queryResult = getJsonBySearch(getJsonData);
    if (queryResult !== undefined) {
        selectInfo(type, queryResult);
        $("." + curObj + " .nextpage").unbind();
        $("." + curObj + " .prepage").unbind();
        pageControllerBySearch(getJsonData, type, curObj, searchId);
        getPageSizeBySearch(getPageSizeData);
        $("." + curObj + " .showBox").off("click", "." + selector);
        delBtnBySearch(getPageSizeData, curObj, type, getJsonData, selector, dataName);
        $(".search font").text(page + "/" + maxPage);
    } else {
        alert("查找记录不存在，请重新输入！");
    }
}

//获取查找的记录结果
function getJsonBySearch(getJsonData) {
    $.ajax({
        async: false,
        url: "query.do",
        data: getJsonData + "&page=" + page,
        dataType: "json",
        success:function (resp) {
            if (resp.length === 0 && page !== 0) {
                return;
            }
            queryResult = resp;
        }
    })
    return queryResult;
}

//获取指定查询结果集的页数
function getPageSizeBySearch(getPageSizeData) {
    $.ajax({
        async: false,
        url: "query.do",
        data: getPageSizeData,
        success: function (resp) {
            if (resp !== '0') {
                maxPage = resp;
            }
        }
    })
}

// 翻页控制器
function pageControllerBySearch(getJsonData, type, curObj, searchId) {
    let str = "." + curObj;
    //上一页
    $(str + " .prepage").click(function () {
        page--;
        if (page >= 1) {
            $(str + " .showBox").empty();
            selectInfo(type, getJsonBySearch(getJsonData));
        } else {
            page++;
        }
        $(str + " .search font").text(page + "/" + maxPage);
        $(":text").val("");
        if (val !== "") {
            $("#" + searchId).val(val);
        }
    })
    //下一页
    $(str + " .nextpage").click(function () {
        page++;
        if (page <= maxPage){
            $(str + " .showBox").empty();
            selectInfo(type, getJsonBySearch(getJsonData));
        } else {
            page--;
        }
        $(str + " .search font").text(page + "/" + maxPage);
        $(":text").val("");
        if (val !== "") {
            $("#" + searchId).val(val);
        }
    })
    //跳转
    let inputPage;
    $(str + " .skip").click(function () {
        inputPage = $(str + " .search :text").val();
        if (inputPage === "") return;
        if (parseInt(inputPage) >= 1 && parseInt(inputPage) <= maxPage && maxPage > 1) {
            page = inputPage;
            $(str + " .showBox").empty();
            selectInfo(type, getJsonBySearch(getJsonData));
            $(":text").val("");
            $(str + " .search font").text(page + "/" + maxPage);
            $("#" + searchId).val(val);
        } else {
            alert('请输入有效的页数！');
            $(":text").val("");
            inputPage = "";
        }
    })
}

// 删除按钮
function delBtnBySearch(getPageSizeData, curObj, type, getJsonData, selector, dataName) {
    $("." + curObj + " .showBox").on("click", "." + selector, function () {
        if (!confirm("确定要删除此条数据？")) return;
        $.ajax({
            url: "delete.do",
            data: dataName + $(this).attr("req"),
            success: function () {
                getPageSizeBySearch(getPageSizeData);
                if (maxPage < page) {
                    page--;
                }
                $(".search font").text(page + "/" + maxPage);
                selectInfo(type, getJsonBySearch(getJsonData));
            }
        })
    })
}