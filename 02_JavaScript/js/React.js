// node.js, yarn을 설치하여 react-create-app 으로 폴더를 생성한 후 작성한다.
// React 는 Vtural Dom 을 생성해서 실제 Dom에서 변화가 있는 부분만을 바꾸어 렌더하는 식으로 실행 속도를 높인다.
// JSX. React 에서 사용하는 코드문법. 가독성이 좋고, 오류인지가 쉬움.
// Babel문법 = JS코드를 ES5 <-> ES6 변환해줌, JSX문법을 JS문법으로 변환

// 기존방법
// const root = document.querySelector('#root');
// const btn_plus = document.querySelector('#btn_plus');
// let i = 1;
// root.innerHTML = '<p>init : 1</p>';
// btn_plus.addEventListener('click', () => {
//     root.innerHTML = `<p>init : ${i++}</p>`;
// });

// React
// 객체데이터로 div안의 내용물을 구성해서 만들어놓고, render 로 실행하는듯.
// render (실행할 위치, 실행할 객체);
// const component = {
//     message: 'init',
//     count: 0,
//     render () {
//         return `<p>${this.message} : ${this.count}</p>`;
//     }
// };
// function render (rootElement, component) {
//     rootElement.innerHTML = component.render();
// };
// render(document.querySelector('#root'), component);
// document.querySelector('#btn_plus').addEventListener("click", () => {
//     component.message = "update";
//     component.count += 1;
//     render(document.querySelector('#root'), component);
// })

// React 라이브러리 이용
const Component = (props) => {
    return React.createElement(
        'p',
        null,   // props
        `${props.message} : ${props.count}`
        )
}
// ReactDOM.render(요소생성함수, 요소를 생성할 위치의 부모태그)
// React.createElement(실행할 함수, {넣을 데이터}, null)
ReactDOM.render(React.createElement(Component, {message: 'init', count: 0}, null), document.querySelector('#root'))
btn_plus.addEventListener('click', () => {
    ReactDOM.render(React.createElement(Component, {message: 'update', count: 5}, null), document.querySelector('#root'))            
});

// React 프로젝트의 App.js 참조. JSX 문법들
function App() {
  const name = 'Var.REACT';
  const def = undefined;
  // 인라인 형식으로 들어갈 CSS를 객체형식으로 생성할 수 있음.
  // 스타일객체의 키값은 카멜형식으로 변형.
  // import 되는 App.css 에 그냥 CSS 작성해서 클래스로 불러와도 상관없음.
  const styleCSS = {
    backgroundColor: 'blue',
    fontSize: '20px',
    color: 'white'
  }
  return (
    // 이 안의 내용들이 componant, 주석모양이 특이하네
    // 최상위는 반드시 부모요소가 존재해야한다. (태그 || fragment)
    // fragment = <></> 아무것도 없는 빈태그?
    // {}를 이용해서 중간에 js 변수, 표현식(연산자), 삼항연산자 등을 이용할 수 있다. js 의 if문 사용불가.
    // JSX에서의 연산자.
    //    A && B = A가 true 일경우 B, false 일경우 A
    //    A || B = A가 true 일경우 A, false 일경우 B
    
    <>
      {/* 인라인스타일로 스타일을 주게됨 */}
      { name === 'Var.REACT' ? <span style={styleCSS}>참</span> : <span>거짓</span>}
      <h1>Print : {name}</h1>
      {/* JSX문법에서는 Class 대신 ClassName을 사용. Class도 적용은 되나 콘솔에 오류뜸. */}
      <h2 className='reactClass'>REACT TEST</h2>
      {def || 'TEST'}
      {def && 'TEST'}
      {/* HTML의 독립태그들도 JSX에서는 반드시 닫는태그가 있어야함. 보통은 단일태그 끝에 / 로 닫는 표시를 함. */}
      <input type="text" />
    </>
  );
}


