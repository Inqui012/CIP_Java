// pc subMenu
const menu = document.querySelector('.menu__main');
const subMenu = document.querySelectorAll('.list__drop');
const panel = document.querySelector('.header__panel');
const header = document.querySelector('.header');

// 'mouseover' 이벤트 = CSS에서의 :hover
// forEach로 각각의 서브메뉴에 기능을 지정.
menu.addEventListener('mouseover', () => {
    panel.style.display = 'block';
    subMenu.forEach(subMenu => { subMenu.style.display = "block" });
});
// 오버된 마우스가 사라졌을때
header.addEventListener('mouseout', () => {
	panel.style.display = 'none';
    subMenu.forEach(subMenu => { subMenu.style.display = "none" });
});
panel.addEventListener('mouseout', () => {
	panel.style.display = 'none';
    subMenu.forEach(subMenu => { subMenu.style.display = "none" });
});

// mobile hamburger toggle
const Mhamburger = document.querySelector('.mobile.hamburger');
const Mclose = document.querySelector('.mobile.close');
const Mnav = document.querySelector('.header__Mnav');
Mhamburger.addEventListener('click', () => {Mnav.style.display = 'block';});
Mclose.addEventListener('click', () => { Mnav.style.display = 'none';});

// mobile submenu toggle
const showHide = e => {
    // e.children[]; 해당 이벤트가 발생한 태그의 자식'태그'를 지정한다. 자식태그들을 배열형으로 묶어서 저장하기 때문에 인덱스로 표시
    // e.childNodes[]; 도 있는데 이건 코드내의 빈공백도 선택이 되기때문에 쓰기가 힘들것...같나?
    const MListDrop = e.children[2];
    // getComputedStyle(쿼리셀렉터).속성; 지정된 쿼리가 가지고 있는 CSS중에서 지정된 속성값을 가져온다.
    // 셀렉터.style.속성 = ; 은 지정된 태그에 '인라인' 스타일로 지정된 속성만을 불러올 수 있다.
    const displayAttr = window.getComputedStyle(MListDrop).display;

    if (displayAttr == 'none') {
        MListDrop.style.display = 'block';
    } else {
        MListDrop.style.display = 'none';
    }
}

// disable modile menu width 767 over
// resize 이벤트를 그대로 쓰면 매초마다 함수가 실행되서 브라우저에 과부하를 줄 수도 있고 비효율적이라서 보통 스로틀을 주기도 한다.
// 아래는 리사이즈의 딜레이 타임을줘서 일정시간안에 리사이즈 이벤트가 일어나면 타이머를 덮어씌워 초기화시기면서 함수를 실행시킨다.
var delay = 300;
var timer = null;
window.addEventListener('resize', function(){
    clearTimeout(timer);
    let winWidth = window.innerWidth;
	timer = setTimeout(function(){
		if (winWidth >= 767){
            Mnav.style.display = 'none';
        }
	}, delay);
});