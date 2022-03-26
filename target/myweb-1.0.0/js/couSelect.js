$(function () {
    //stuselect和teaselect、couselect向userupdate提交
    $(".xg").on("click", function () {
        $.post("login.do", function () {
                location.href = "login.do";
            });
        });
    //stuselect或teaselect向couselect提交
    $(".kcb").click(function () {
        window.location.href = "query.do?type=课程表";
    });
    //couselect向stuselect或teaselect提交
    $(".user").click(function () {
        window.location.href = "query.do";
    });
    //couselect默认发起请求返回周次
    $.ajax({
        async: false,
        url: "query.do",
        data: "time=周次",
        dataType: "json",
        success: function (resp) {
            $(".sel option").next().remove();
            $.each(resp, function (i, obj) {
                $(".sel").append("<option value='" + obj + "'>" + obj + "</option>");
            });
            //默认加载当前第一个周数的课程信息，并且保留选中当前被选择的option
            if(decodeURIComponent(location.href).match(".*课程表.*") && !decodeURIComponent(location.href).match(".*selTime.*")) {
                $($(".sel>option")[1]).attr("selected", true);
                location.href = "query.do?selTime=" + $(".sel>option:selected").val() + "&type=课程表";
            } else if (location.href.match(".*selTime.*")) {
                let week = decodeURIComponent(location.href).match(/=(\S*)&/)[1];
                for (let i = 0; i < $('.sel option').length; i++) {
                    let obj = $($(".sel option")[i]);
                    if (obj.val() === week) {
                        obj.attr("selected", true);
                    }
                }
            }
        }
    });
    //couselect提交下拉列表所选信息
    $(".sel").change(function () {
        let obj = $(".sel>option:selected");
        let selTime = obj.val();
        location.href = "query.do?selTime=" + selTime + "&type=课程表";
    });
})