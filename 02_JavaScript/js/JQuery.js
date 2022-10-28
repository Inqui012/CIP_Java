// 데이터를 주고받는 방법. ajax, fetch, axios
// jQ 의 경우 데이터관리에 ajax 사용가능. 온리 쿼리
var url = "https://api.openweathermap.org/data/2.5/weather";
url += "?appid=411d579a912a8d5efb7cd45593e2daa4";
url += "&units=metric";
url += "&lang=kr";
url += "&q=incheon";
function getCurrentWeather() {
    var dataObj;
    var openWeatherAPI = url;
    // .ajax({}); 객체데이터를 매개변수로 받는 함수.
    // 페이지 전체를 리프레쉬하지 않고 일부만을 업데이트할 수 있는 비동기성이 특징.
    $.ajax({
        // 서버에 데이터를 요청한 방식.
        type: "GET",
        url: openWeatherAPI,
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
            
// 스크립트에서는 fetch 방법을 사용함. ES6.
// 기본적으로 비동기를 편하게 제어하기 위해 많이 사용하는듯.
// async, await 로 비동기로 진행되는 promise 들을 자연스럽게 연결시킬 수 있다.
// 아래의 경우 비동기 통신으로 인해 2초뒤에 실행되는 resolve보다 먼저 alert가 실행되어 데이터가 전달되지 않는다.
function asyncFunc01() {
    let Promise02 = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("DONE");
        }, 2000)
    })
    let result02 = Promise02;
    alert(result02);
}
// 아래처럼 async 로 함수를 정의하고 await 로 promise02 객체가 생성되는것을 기다린 후 alert가 실행된다.
async function asyncFunc02() {
    let Promise02 = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("DONE");
        }, 2000)
    })
    let result02 = await Promise02;
    alert(result02);
}
asyncFunc02();
const promise01 = new Promise(function (resolve, reject) {
    // 데이터를 보내는 함수
    resolve('STRING');
});
console.log(promise01);
// .then(function(result){}); 을 이용해서 Promise 객체의 실행이 성공했을경우 데이터를 받아올 수 있음.
// .catch(function(error){}); Promise 객체 실행이 실패했을경우에 수행할 작업을 지정할 수 있다.
promise01.then(function (result) {
    console.log(result);
});
// 상위의 ajax 참고.
// fetch();는 Promise 객체자동으로 생성해서 반환한다. IE에서 사용불가.
const getData = function (url) {
    return fetch(url);
};
// url에서 얻은 값을 data 변수로 입력해서 .json()형식으로 받아오고, 거기서 result 값에 넣음.
getData(url).then(data => data.json()).then(result => {
    console.log(result);
});

var obj01 = [
    {
        area: "seoul",
        name: "hotel"
    },
    {
        area: "incheon",
        name: "restorant"
    },
    {
        area: "busan",
        name: "hospital"
    }
];

// .map(Array, function (val, index) {}); = 새로운 배열생성
var arr01 = $.map(obj01, function (val, idx) {
    if (val.area === "seoul") {
        return val;
    }
});

// .grep(Array, function () {}); = filter();
var arr02 = $.grep(obj01, function (val) {
    if (val.area === "seoul") {
        return true;
    }
    return false;
});

// .inArray("value", Array); = value값에 맞는 인덱스가 Array 변수에 있는지 확인하고 해당 인덱스 번호를 출력.
// .isArray(var); = 변수가 배열인지 아닌지 판단.
// $(선택자1).index($('CSS선택자2')) = 선택자1 중에서 선택자2를 가진곳의 인덱스번호 출력. 
var arr03 = ["get", "join", "obj"];
var idxNum = $.inArray("get", arr03);

// .html(); /= inner html 지정된 태그의 하위요소를 전부 가져옴. 태그+내용을 전부 문자열로 가져옴 공백포함.
//      괄호안에 문자열형식으로 태그를 넣으면 해당 위치에 있을 내용을 전부 괄호안의 내용물로 변경함.
// .text(); 하위요소의 텍스트만을 문자열로 공백포함으로 가져옴.
//      괄호안에 문자열을 넣으면 태그라도 그냥 문자열로 인식해서 바꿔넣게됨.
var result01 = $('.child').html();
var result01 = $('.child').text();


$(function () {
    $('#title').css("color", "red");
    // .parent(), .parents(). 바로 위 부모, 모든 부모(HTML까지).
    // .children(), .childrens(). 한단계 아래 자식, 하위 모든 자식.
    // .prev(), .next(). 형제들중 이전, 다음 형제 .siblings(). 모든 형제
    // .prevUntil(), .nextUntil(). 시작태그부터 지정된 형제태그들까지 선택. 시작태그, 끝태그 미포함.
    // .closest() 자신포함, 가장 가까운 상위태그.
    // $('CSS선택자:first') = nth:first-of-type / :odd = (2n - 1) / :even = (2n) 
    // :lt(index) = index 미포함 이전 것들 / :gt(index) = index 미포함 이후것들
    // .eq(index) = nth: type-of(index) / .slice(index1, index2) = index1 부터 index2 이전까지
        
    $('#list_01').parent().css("border", "1px solid blue");
    $('#list_01').children('.child').css("font-size", "3rem");
    $('#list_02').prev().css("padding", "20px 0");
    $('#list_02').next().css("background-color", "skyblue");

    // .each(function (index, val) {}); = for each
    // $(obj01).each(function (idx, val) {
        
    // });

    // $('태그[속성]') / .val() = 태그상의 value 값 
    // :selected = 셀렉트박스 옵션중 선택된것 / :checked = 라디오, 체크박스 체크된것
    $('a[target]').css("border", "1px solid red");
    // ()안에 {}객체데이터 입력가능. 이경우 여러종류의 스타일을 한번에 줄 수 있어서 편리할듯.
    $('#member_f :text').css({ "background-color": "blue" });
    
    // :contains(내용) = 일치하는 내용을 가지고 있는 태그를 선택
    // :has(태그) = 일치하는 태그를 자식요소로 가지고 있는 태그.
    // .contents() = 지정된 태그의 모든 하위요소 / .not() = 지정이 아닌것 / .find() = 지정된것을 찾음
    // .is(속성값) = 해당태그에 지정된 속성값이 있는지 판별.
    $('#inner01 p:contains(SPAN01)').css({ border: "1px solid blue" });
    $('#inner01 p:has(span)').css("background-color", "brown");
    $('#outer_wrap').contents().css("background-color", "#eee");
    $('#inner02 p').not(':first').css("color", "red");
    $('#inner01').find('.test').css("color", "white");
    console.log($('.test02').is(":visible"));

    // .attr("속성"); 지정된 태그가 가지고 있는 지정된 속성값을 가져옴. 여러개가 있어도 HTML상 가장 처음것만 가져오는듯.
    // 객체데이터로 여러 데이터를 한번에 줄 수 있음.
    // .removeAttr("속성"); = 속성삭제
    $('a').attr("href", "https://www.ezenac.co.kr")

    // .addClass('클래스명') / .removeClass('클래스명') = 클래스 추가 삭제
    // .toggleClass('클래스명') 클래스 토글 / .hasClass('클래스명') 해당 클래스를 가지고 있는지 판단
    $('p#test03').addClass('red');

    // .after(); / .before(); = 지정된 위치의 앞/ 뒤에 내용추가. 태그인식함.
    // .insertAfter(); / .insertBefore(); = 지정된 내용을 지정하는 위치의 앞/ 뒤에 추가 위와 구조가 반대.
    // .append(); / prepend(); = 선택된 요소의 하위중에 맨뒤 / 맨앞에 괄호의 내용을 추가함. 태그인식.
    // .appendTo(); / prependTo(); = 위와 구조가 반대.
    // .clone(); = 지정된 요소의 내용물(하위포함 안함)을 배열형태로 가져옴.
    // .remove(); = 지정된 요소(본인과 하위포함)를 지움.
    // .empty(); = 지정된 요소의 하위태그를 지워줌.
    // .replaceWith(); = 지정된 요소를 괄호안의 내용물로 변경함.
    // .replaceAll(); = 위와 구조가 반대.
    $('#wrap01 p:eq(2)').after("<p>ATFER</p>");
    $('#wrap01 p:eq(1)').before("<p>BEFORE</p>");    
    $('#wrap01').append("<p>CONTNTS04</p>");
    $('#wrap01').prepend("<p>CONTNTS00</p>");
    var cloneCode = $('#wrap01').children().clone();
    $('#wrap02').append(cloneCode);
    $('h3').replaceWith("<h1>CHANGED</h1>");

    // .unwrap(); / .wrap(); / .wrapAll(); = 해당객체를 내포하고 있는 부모를 지우고 생성하고.
    // wrap의 경우 여러 요소를 한번에 감싸는게 아니라 각각 개별로 감싼다. 한번에 감싸기위해서는 wrapAll 사용.
    // .wrapInner(); = 지정된 요소의 하위요소들을 감싸는 태그를 추가
    $('strong').unwrap();
    $('p.ct01').wrap('<div />');
    $('li').wrapInner("<h3 />")

    // .Event(function () {}); 기본이벤트 형식
    $('.btn01').click(function () {
        $(this).parent().next().css({ color: "red" });
    })

    // .on({Event:function(){}, Event:function(){}}); 객체형식으로 이벤트를 여러개 동시에 등록할 수 있음.
    // .off("Event"); = 이벤트 제거. 여러 이벤트를 제거할때는 띄어쓰기로 구분하는듯.
    $('.btn02').on({
        "mouseover focus": function () { 
            $(this).text("CHANGE")
        },
        "mouseout": function () {
            $(this).text("BUTTON02")
        },
        "click": function () {
            $(this).parent().next().css("color", "blue")
        }
    })

    // 클래스 생성순서가 늦어서 실행 안됨.
    $(".03_btn01.on").on("mouseover focus", function() {
        alert("HI");
    })
    // 라이브 이벤트. 클래스 생성이 아래여도 실행가능.
    // 부모태그나 상위요소를 지정해서 이벤트를 주는듯?
    $('.03_btn02').parent().on("mouseover focus", ".03_btn02.on", function () {
        alert("HI");
    })
    $('.03_btn01').addClass("on");
    $('.03_btn02').addClass("on");

})
