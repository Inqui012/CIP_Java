import React, { Component } from 'react'

// 콤포넌트의 라이프 사이클 = 콤포넌트가 화면에 렌더링되기 위해 준비하는 단계부터 화면에서 사라질때 까지
// 라이프사이클은 class 콤포넌트에서만 사용가능하고 현재는 훅을 이용하는 일이 많아지고있음.
// 함수 콤포넌트 사용을 권장하지만 그래도 흐름은 이해할것.

class LifeCycle extends Component {
   state = {
      number: 0,
      color: null,
   }
   myRef = null
   constructor(props) {
      super(props)
      console.log('constructor')
   }
   // App.js 에서 props로 받아온 state.color 값을 자신의 state 에 동기화시키는듯
   // nextProps = 받아온 props값 / prevState = 현재 콤포넌트의 state
   static getDerivedStateFromProps(nextProps, prevState) {
      // 받아온 color 값과 현재 콤포넌트가 가지고 있는 color 값을 비교
      if (nextProps.color !== prevState.color) {
         // 현재 콤포넌트 state 의 color 값을 받아온 props 의 color 값으로 바꾼다
         return { color: nextProps.color }
      }
      return null
   }
   // 렌더가 끝나고 나서 실행
   componentDidMount() {
      console.log('componentDidMount')
   }
   // 콤포넌트가 사라질때.
   componentWillUnmount() {
      console.log('componentWillUnmount')
   }

   // Props 나 state 가 변경될때 리렌더링 여부를 결정. true / false 반환
   // nextProps , nextState = 바뀐 props 와 state 값.
   shouldComponentUpdate(nextProps, nextState) {
      // 새로 생성된 state.number 의 뒷자리가 4 가 아닐경우 true => 리렌더 실행.
      return nextState.number % 10 !== 4
   }

   // componentDidUpdate 와 함께 사용해야함.
   // props 나 state에 변화가 일어나기 직전의 DOM 상태를 확인하고 값을 반환한다.
   // 이 반환된 값을 componentDidUpdate 에서 참조해서 사용하게 됨.
   getSnapshotBeforeUpdate(prevProps, prevState) {
      console.log('getSnapshotBeforeUpdate')
      if (prevProps.color !== this.props.color) {
         return this.myRef.style.color
      }
      return null
   }

   // 렌더링이 끝난 후에 실행한다. snapshot 매개변수로 getSnapshotBeforeUpdate 에서 반환된 값을 가져온다.
   componentDidUpdate(prevProps, prevState, snapshot) {
      console.log('componentDidUpdate', prevProps, prevState)
      if (snapshot) {
         console.log('업데이트 되기 직전 색상: ', snapshot)
      }
   }
   render() {
      console.log('render')
      const title = {
         color: this.props.color,
      }
      return (
         <div>
            <h1>LifeCycle</h1>
            <h2 style={title} ref={ref => (this.myRef = ref)}>
               {this.state.number}
            </h2>
            <p>COLOR : {this.state.color}</p>
            <button>ADD</button>
         </div>
      )
   }
}

export default LifeCycle
