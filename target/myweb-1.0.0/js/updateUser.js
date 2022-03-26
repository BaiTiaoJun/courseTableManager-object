$(function () {
    $(".submit").click(function () {
        let oneVal = $("#one").val();
        let twoVal = $("#two").val();
        let threeVal = $("#three").val();
        if (oneVal !== "" && twoVal !== "" && threeVal !== "") {
            if (twoVal.length >= 6) {
                if (twoVal !== threeVal) {
                    alert("确认密码和新密码不一致！");
                } else {
                    $.post({
                        url: "modify.do",
                        data: "oldPassword=" + oneVal +"&newPassword=" + twoVal
                            + "&finalPassword=" + threeVal,
                        dataType: "text",
                        success: function (resp) {
                            if (resp === "false" || resp === "1") {
                                if (resp === "false") {
                                    alert("新密码不能和原密码相同");
                                } else if (resp === "1"){
                                    $("#dialog").show();
                                    setTimeout(function () {
                                        $("#dialog").hide();
                                        location.href = "exit.do";
                                    }, 3000);
                                }
                            } else if(resp === "true") {
                                alert("原密码错误！");
                            }
                        }
                    })
                }
            } else {
                alert("密码长度不能低于6位！")
            }
        } else {
            alert("请输入完整信息！");
        }
    })
   $(".return").click(function () {
       location.href = "query.do";
   })
})