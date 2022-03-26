$(function () {
    $(".submit").click(function () {
        let oneVal = $("#one").val();
        let twoVal = $("#two").val();
        let threeVal = $("#three").val();
        if (oneVal != "" && twoVal != "" & threeVal != "") {
            if (twoVal != threeVal) {
                alert("确认密码和新密码不一致！");
            } else {
                $.post({
                    url: "modify.do",
                    data: "password=" + oneVal,
                    dataType: "text",
                    success: function (resp) {
                        alert(resp);
                    }
                })
            }
        } else {
            alert("请输入完整密码信息！");
        }
    })
})