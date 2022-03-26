//重置事件
function reset(param) {
    $(":reset").click(function () {
        location.href="modify.do?" + param;
    })
}