//获取年月日的下拉列表
$(function () {
    let year;
    let month;
    let day;
    for (year = 1920; year <= 2021; year++) {
        $(".selYear").append("<option>" + year + "</option>");
    }
    for (month = 1; month <= 12; month++) {
        $(".selMonth").append("<option>" + month + "</option>");
    }
    for (day = 1; day <= getDays(year, month); day++) {
        $(".selDay").append("<option>" + day + "</option>");
    }
    $(".selMonth").change(function () {
        let year = $(".selYear").find("option:selected").text();
        let month = $(this).find("option:selected").text();
        $(".selDay").empty();
        for (day = 1; day <= getDays(year, month); day++) {
            $(".selDay").append("<option>" + day + "</option>");
        }
    })
})

function getDays(year, month) {
    let days = new Date(year, month, 0);
    return days.getDate();
}