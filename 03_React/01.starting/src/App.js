import './App.css';
// Component의 확장 클래스를 사용하면 자동으로 생성되네.
import { Component } from 'react';
import MyComponent from './MyComponent';

// class App extends Component {
//   // 오버라이드 = 상위 Component 에 있는 함수 render()를 가져다 쓸 수 있다.
//   render() {
//     const name = "REACT";
//     return <div>{name}</div>
//   }
// }

const App = () => {
  return <MyComponent />
}

export default App;
