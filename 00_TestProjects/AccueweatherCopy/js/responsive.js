$(function () {
    // 열기
    $(".hamburger").click(function () {
        // .hide(); / .show(); = display 속성을 바꿔주는 함수.
        $(".mobile.hamburger").hide();
        $(".mobile.close").show();

        $("#mobile_menu").empty();
        // NAV에서 복사해옴.
        var nav = $(".nav").clone();
        $("#mobile_menu").append(nav);
        $("#mobile_menu").show();
    });

    // 닫기
    $(".close").click(function () {
        $(".mobile.hamburger").show();
        $(".mobile.close").hide();

        $("#mobile_menu").hide();
    });

    // 리사이즈
    var delay = 300;
    var timer = null;
    window.addEventListener('resize', function () {
        clearTimeout(timer);
        var winWidth = $(window).width();
        timer = setTimeout(function () {
            if (winWidth >= 767) {
                if ($("#mobile_menu").is(":visible")) {
                    $(".mobile.hamburger").show();
                    $(".mobile.close").hide();
                    $("#mobile_menu").hide();
                }
            }
        }, delay);
    });
});