// https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=411d579a912a8d5efb7cd45593e2daa4&units=metric&lang=kr
var url = "https://api.openweathermap.org/data/2.5/weather";
url += "?appid=411d579a912a8d5efb7cd45593e2daa4";
url += "&units=metric";
url += "&lang=kr";
url += "&q=";

// 모든정보
function getCurrentWeather(city) {
    var dataObj;
    var openWeatherAPI = url;
    // .ajax({}); 객체데이터를 매개변수로 받는 함수.
    // 페이지 전체를 리프레쉬하지 않고 일부만을 업데이트할 수 있는 비동기성이 특징.
    $.ajax({
        // 서버에 데이터를 요청한 방식.
        type: "GET",
        url: openWeatherAPI += city,
        // 서버에서 받아올 데이터 타입.
        dataType: "json",
        // 동기, 비동기. 서버와의 통신에서 request 와 response 의 전달상황. ajax(); 의 default 값은 true.
        // 동기 = request 가 발생하면 response 가 반드시 다음번에 따라온다. request 와 response를 묶어서 생각.
        //      reponse가 늦어지면 그 사이에 다른작업을 진행하지 못하는 block 상태가 됨. response 결과에 따라서 이후에 변화가 있을때는 중요.
        // 비동기 = request 와 response 가 동시에 진행되지 않아도 됨. request 순서와 response 순서가 보장되지 않음. 성능은 좋음.
        //      response를 기다리는동안 다른 request를 동시에 진행할 수 있다. non blook상태. 
        async: false,
        // 데이터를 성공적으로 불러왔을때 작업 
        success: function (data) {
            dataObj = data;
        },
        // 데이터를 불러오는데 에러났을 때 작업
        error: function (request, status, error) {
            console.log("code:" + request.status);
            console.log("message:" + request.responseText);
            console.log("error:" + error);
        }
    });
    return dataObj;
};
// 지역별 온도
function getCurrentTemp() {
    
};