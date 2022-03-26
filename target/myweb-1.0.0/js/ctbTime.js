$(function () {
    let week = "一,二,三,四,五,六,七,八,九,十,十一,十二,十三,十四,十五,十六,十七";
    let whatDay = "一,二,三,四,五,六";
    let sessionNo = "1-2,3-4,5-6,7-8,9-10";
    let weekArr = week.split(",");
    let whatDayArr = whatDay.split(",");
    let sessionNoArr = sessionNo.split(",");
    for (let i = 0; i < weekArr.length; i++) {
        $(".ctbTimeWeek").append("<option>第" + weekArr[i] + "周</option>");
    }
    for (let i = 0; i < whatDayArr.length; i++) {
        $(".ctbTimeWhatDay").append("<option>星期" + whatDayArr[i] + "</option>");
    }
    for (let i = 0; i < sessionNoArr.length; i++) {
        $(".ctbTimeSessionNo").append("<option>第" + sessionNoArr[i] + "节</option>");
    }
})