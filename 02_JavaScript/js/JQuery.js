$(function () {
    $('#title').css("color", "red");

    // .parent(), .parents(). 바로 위 부모, 모든 부모(HTML까지).
    // .children(), .childrens(). 한단계 아래 자식, 하위 모든 자식.
    // .prev(), .next(). 형제들중 이전, 다음 형제 .siblings(). 모든 형제
    // .prevUntil(), .nextUntil(). 시작태그부터 지정된 형제태그들까지 선택. 시작태그, 끝태그 미포함.
    // .closest() 자신포함, 가장 가까운 상위태그.
    // $('CSS선택자:first') = nth:first-of-type
    $('#list_01').parent().css("border", "1px solid blue");
    $('#list_01').children('.child').css("font-size", "3rem");
    $('#list_02').prev().css("padding", "20px 0");
    $('#list_02').next().css("background-color", "skyblue");


})
