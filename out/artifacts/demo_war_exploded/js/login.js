$(function () {
    $(".submit").click(function () {
        let username = $(":text").val();
        let password = $(":password").val();
        $.post({
            url: "login.do",
            data: "username=" + username + "&" + "password=" + password,
            dataType: "text",
            success: function (resp) {
                if (resp=="学生" || resp=="老师" || resp=="管理员") {
                    location.href = "query.do?type=" + resp + "&username=" + username;
                } else {
                    alert("用户信息输入有误或已经登录'当前/某个用户'" +
                        "\n请重新输入或尝试点击'退出登录'后重试！");
                }
            }
        })
    })
    $(".exit").click(function () {
        $.get({
            url: "exit.do",
            success: function (resp) {
                if (resp == "空用户" || resp === "null")
                    alert("还没有用户登录，请先登录！");
                else
                    alert(resp + "用户成功退出！");
            }
        })
    })
})