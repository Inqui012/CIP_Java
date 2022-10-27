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
    console.log($('a').attr("href"));

})
