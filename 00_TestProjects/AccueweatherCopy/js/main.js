var cityList = ["seoul", "incheon", "busan", "gwangju", "jeju", "jeonju"];

$(".temp").each(function (i) {
    var temp = getCurrentTemp(cityList[i]);
    var iconUrl = "https://openweathermap.org/img/wn/";
    $(this).text(temp.celsius + "℃");
    $(this).prev().children().attr("src", iconUrl + temp.icon + ".png");
});
$(".location").on({
    "click" : function() {
        var q = $(this).children(".q").attr("id");
        var redirectURL = "pages/weather_location.html?q=" + q; 
        location.href = redirectURL;
    }
});