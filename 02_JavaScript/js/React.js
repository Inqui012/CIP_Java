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



