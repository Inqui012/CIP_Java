import './App.css';
// Component의 확장 클래스를 사용하면 자동으로 생성되네.
import { Component } from 'react';
import MyComponent from './MyComp_func';
import MyComponent01 from './MyComp_class';

function ReactStart() {
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
    // component = 코드를 재사용하기 쉽게 하기 위해서 캡슐화한 한 블록.
    // Class component = 라이프사이클 이용 / function component (권장) = 라이프사이클 없음
    // 이 안의 내용들이 component, 주석모양이 특이하네
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

class ClassTest extends Component {
  // 오버라이드 = 상위 Component 에 있는 함수 render()를 가져다 쓸 수 있다.
  render() {
    const name = "REACT";
    return <div>{name}</div>
  }
}

const App = () => {
  // propsKey="value" = 인라인 속성을 주는것처럼 props 를 줄 수 있다.
  // 컴포넌트js에서 기본값 설정해줄 수도 있음
  return (
    <>
      <MyComponent name="PropsName" forNumber={1} /><br />
      <MyComponent>Testing Props Children</MyComponent>
      <MyComponent /><br />
      <MyComponent01 /><br />
      <ClassTest /><br />
      <ReactStart />
    </>
  )  
}

export default App;
