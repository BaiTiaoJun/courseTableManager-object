$(function () {
    $(".xg").on("click", function () {
        $.post({
            url: "login.do",
            success:function () {
                location.href = "login.do";
            }
        })
    })
    $(".kcb").click(function () {
        $.ajax({
            url: "query.do",
            success: function () {
                window.location.href = "query.do?type=课程表";
            }
        })
    })
    $(".xsb").click(function () {
        $.ajax({
            url: "query.do",
            success: function () {
                window.location.href = "query.do";
            }
        })
    })
})