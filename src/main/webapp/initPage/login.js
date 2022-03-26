$(function () {
    $(":text").focus();
    $(".submit").click(function () {
        doLogin();
    })
    $(window).keydown(function (event) {
        if (event.keyCode === 13) {
            doLogin();
        }
    })
})

function doLogin() {
    let username = $(":text").val();
    let password = $(":password").val();
    if (username === "" || password === "") {
        alert("用户或密码不能为空!");
        return false;
    }
    $.post({
        url: "login.do",
        data: "username=" + username + "&" + "password=" + password,
        dataType: "text",
        success: function (resp) {
            if (resp==="学生" || resp==="老师" || resp==="管理员") {
                location.href = "query.do?type=" + resp;
            } else {
                alert("用户信息输入有误，请重新输入！");
            }
        }
    })
}