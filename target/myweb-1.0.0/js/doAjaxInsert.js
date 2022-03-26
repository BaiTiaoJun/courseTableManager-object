function doAjaxInsert(data, url, tip) {
    $.ajax({
        async: false,
        type: "post",
        url: "insert.do",
        data: data,
        success: function (resp) {
            if (resp === '1') {
                alert("添加成功！");
                location.href = url;
            } else if (resp === '-1'){
                alert(tip);
            }
        }
    })
}