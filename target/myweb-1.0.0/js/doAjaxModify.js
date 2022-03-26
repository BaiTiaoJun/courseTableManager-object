$(function () {
    $(".submitUser").on("click", function () {
        let username = $("#user").val();
        let password = $("#pass").val();
        let usertype = $("#type").val();
        let data = "user=" + username + "&pass=" + password + "&type=" + usertype
        doAjax(data);
    })

    $(".submitStu").click(function () {
        let stuId = $("#stuId").val();
        let stuName = $("#stuName").val();
        let stuSex = $(".selSex:checked").val();
        let selYear = $("#year").val();
        let selMonth = $("#month").val();
        let selDay = $("#day").val();
        let stuDept = $("#dept").val();
        let stuClass = $("#class").val();
        let stuAddr = $("#addr").val();
        let stuContact = $("#contact").val();
        let data = "stuId=" + stuId + "&name=" + stuName + "&sex=" +
            stuSex + "&year=" + selYear + "&month=" + selMonth +
            "&day=" + selDay + "&dept=" + stuDept + "&class=" +
            stuClass + "&addr=" + stuAddr + "&contact=" + stuContact;
        doAjax(data);
    })

    $(".submitTea").click(function () {
        let teaNo = $("#teaNo").val();
        let teaName = $("#teaName").val();
        let teaDept = $("#teaDept").val();
        let teaMajor = $("#teaMajor").val();
        let teaPosTitle = $("#teaPosTitle").val();
        let data = "teaId=" + teaNo + "&teaName=" + teaName + "&teaDept=" + teaDept +
            "&teaMajor=" + teaMajor + "&teaPosTitle=" + teaPosTitle;
        doAjax(data);
    })

    $(".submitCtb").click(function () {
        let ctbId = $("#ctbId").val();
        let ctbCouNo = $("#ctbCouNo").val();
        let ctbClassNo = $("#ctbClassNo").val();
        let ctbTeaNo = $("#ctbTeaNo").val();
        let ctbTimeWeek = $(".ctbTimeWeek").val();
        let ctbTimeWhatDay = $(".ctbTimeWhatDay").val();
        let ctbTimeSessionNo = $(".ctbTimeSessionNo").val();
        let ctbSite = $("#ctbSite").val();
        let data = "ctbNo=" + ctbId + "&ctbCouNo=" + ctbCouNo + "&ctbClassNo=" + ctbClassNo +
            "&ctbTeaNo=" + ctbTeaNo + "&ctbTimeWeek=" + ctbTimeWeek + "&ctbTimeWhatDay=" + ctbTimeWhatDay +
            "&ctbTimeSessionNo=" + ctbTimeSessionNo + "&ctbSite=" + ctbSite;
        doAjax(data);
    })

    $(".submitCb").click(function () {
        let couNo = $("#couNo").val();
        let couName = $("#couName").val();
        let couTerm = $(".couTerm").val();
        let couPeriod = $("#couPeriod").val();
        let couCredit = $("#couCredit").val();
        let data = "couNo=" + couNo + "&couName=" + couName + "&couTerm=" + couTerm +
            "&couPeriod=" + couPeriod + "&couCredit=" + couCredit;
        doAjax(data);
    })

    $(".submitClassBase").click(function () {
        let cNo = $("#classNo").val();
        let dept = $("#classDept").val();
        let classStuNum = $("#classStuNum").val();
        let selYear = $(".selYear").val();
        let selMonth = $(".selMonth").val();
        let selDay = $(".selDay").val();
        let instructor = $("#instructor").val();
        let data = "cNo=" + cNo + "&dept=" + dept + "&classStuNum=" + classStuNum +
            "&selYear=" + selYear + "&selMonth=" + selMonth + "&selDay=" + selDay +
            "&instructor=" + instructor;
        doAjax(data);
    })

    $(".submitClassroom").click(function () {
        let classroomNo = $("#classroomNo").val();
        let capacity = $("#capacity").val();
        let isMulClassroom = $(".isMul:checked").val();
        let isUse = $(".isUse:checked").val();
        let data = "classroomNumber=" + classroomNo + "&capacity=" + capacity + "&isMulClassroom=" + isMulClassroom +
            "&isUse=" + isUse;
        doAjax(data);
    })
})

function doAjax(data) {
    $.ajax({
        type: "post",
        url: "modify.do",
        dataType: "text",
        data: data,
        success: function (resp) {
            if (resp === "true") {
                $("#dialog").show();
                $("input").attr("disabled", true);
                $("select").attr("disabled", true);
                setTimeout(function () {
                    $("#dialog").hide();
                    location.href = "ManagerJsp.jsp";
                }, 3000);
            } else {
                alert("修改信息不能为空，请重新修改！");
            }
        }
    })
}