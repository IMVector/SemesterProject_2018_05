//表格交替背景颜色
$(document).ready(function () {
    tableColor();
});
$(document).ready(function () {
    $('.dropdown').dropdown({
        on: 'hover'
    });
});

/**
 * 交替更改表格的颜色
 * @returns {undefined}
 */
function tableColor() {
    $(".table").find("tr").each(function (i) {
        switch (i % 5) {
            case 0:
                $(this).addClass("active");
                break;
            case 1:
                $(this).addClass("danger");
                break;
            case 2:
                $(this).addClass("success");
                break;
            case 3:
                $(this).addClass("info");
                break;
            case 4:
                $(this).addClass("warning");
                break;
        }
    });
}
//网页加载时计算网页显示区域
$(document).ready(function () {//网页加载时计算显示区域大小
    var height = window.innerHeight - 30;
    $("#mybody").css("height", height);
    $("#mybody").css("max-height", height);
});
//浏览器大小改变时布局响应事件
$(document).ready(function () {
    $(window).resize(function () {//浏览器显示区域大小改变时重新计算显示区域
        var height = window.innerHeight - 30;
        $("#mybody").css("height", height);
        $("#mybody").css("max-height", height);
    });
});

//ajax刷新时回调函数计算窗口大小
function calSize() {
    var height = window.innerHeight - 30;
    $("#mybody").css("height", height);
    $("#mybody").css("max-height", height);
}