import LifeCycle from './LifeCycle'
import React, { Component } from 'react'

function getRandomColor() {
   // 랜덤한 컬러코드를 만들어주는 코드
   return '#' + Math.floor(Math.random() * 16777215).toString(16)
}
class App extends Component {
   state = {
      color: '#000',
   }
   handleClick = () => {
      this.setState({ color: getRandomColor() })
   }
   render() {
      return (
         <div>
            <button onClick={this.handleClick}>RANDOM COLOR</button>
            {/* state 에 있는 color를 하위콤포넌트인 lifecycle에게 props로 전달 */}
            <LifeCycle color={this.state.color} />
         </div>
      )
   }
}

export default App
