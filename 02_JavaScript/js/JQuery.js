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
var arr01 = $.map(obj, function (val, idx) {
    if (val.area === "seoul") {
        return val;
    }
});

// .grep(Array, function () {}); = filter();
var arr02 = $.grep(obj, function () {
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
    $(obj01).each(function (idx, val) {
        
    });
})
