let json;
//刷新页面
$('.reset').on("click", function () {
    location.href = "CourseTableInsert.html";
})
$(function () {
    //数据库获取课程号
    let courseNo = "reqCourseNo=courseNo";
    doAjax(courseNo);
    $.each(json, function (i, courseBase) {
        $("#ctbCouNo").append("<option>" + courseBase.courseNo + "</option>");
    })
    //数据库获取教室地点
    let site = "reqSite=site";
    doAjax(site);
    $.each(json, function (i, classroom) {
        $("#ctbSite").append("<option>" + classroom.classroomNo + "</option>");
    })
    //数据库获取老师编号
    let teaNo = "reqTeaNo=teaNo";
    doAjax(teaNo);
    $.each(json, function (i, teacher) {
        $("#ctbTeaNo").append("<option>" + teacher.no + "</option>");
    })
    //数据库获取班级号
    let classNo = "reqClassNo=classNo";
    doAjax(classNo);
    $.each(json, function (i, classBase) {
        $("#ctbClassNo").append("<option>" + classBase.classNo + "</option>");
    })
    // 执行ajax
    function doAjax(data) {
        $.ajax({
            async: false,
            url: "query.do",
            data: data,
            contentType: "json",
            success: function (resp) {
                if (resp.length > 0) {
                    json = resp;
                }
            }
        })
    }
    //获取输入的参数传递给服务器
    $('.submitCtb').on("click", function () {
        let ctbCouNo = $('#ctbCouNo').val();
        let ctbClassNo = $('#ctbClassNo').val();
        let ctbTeaNo = $('#ctbTeaNo').val();
        let ctbTimeWeek = $('.ctbTimeWeek').val();
        let ctbTimeWhatDay = $('.ctbTimeWhatDay').val();
        let ctbTimeSessionNo = $('.ctbTimeSessionNo').val();
        let ctbSite = $('#ctbSite').val();
        if (ctbCouNo !== "" && ctbClassNo !== "" && ctbTeaNo !== "" && ctbTimeWeek !== "" && ctbTimeWhatDay !== "" && ctbTimeSessionNo !=="" && ctbSite !== "") {
            let data = "ctbCouNo=" + ctbCouNo + "&ctbClassNo=" + ctbClassNo + "&ctbTeaNo=" + ctbTeaNo + "&ctbTimeWeek=" + ctbTimeWeek + "&ctbTimeWhatDay=" + ctbTimeWhatDay + "&ctbTimeSessionNo="
                + ctbTimeSessionNo + "&ctbSite=" + ctbSite;
            doAjaxInsert(data, "CourseTableInsert.html", "此班级已存在这个时间的课程！");
        } else {
            alert("请输入完整的课表信息！");
        }
    })
})