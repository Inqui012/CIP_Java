var currentURL = location.href;
// JS에서 제공하는 URL 객체.
var urlObj = new URL(currentURL);

// .searchParams = 해당객체(URL주소)에서 사용할 수 있는 함수들이 모여있는 객체? 프로토타입.
var params = urlObj.searchParams;
console.log(params);
var q = params.get("q");
console.log(q);

// 전체 날씨 정보 얻어오기
var result = getCurrentWeather(q);
console.log(result);

//데이터 바인딩
$("#temp").text(result.main.temp + "℃");
$("#wind").text(result.wind.speed + "m/s");
$("#humidity").text(result.main.humidity + "%");