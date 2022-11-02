import React, { Component } from 'react'

class EventPractice extends Component {
   state = {
      message: '',
   }
   constructor(props) {
      super(props)
      // 객체 외부에서 객체의 this를 참조할때 오류를 막기 위해 바인딩을 한다.
      // 객체 내부에서의 this는 안정적으로 해당 객체를 지정하지만
      // 외부 변수에 객체를 저장하게 될 때에는 이 관계가 사라져서 this 가 지정된 객체를 정확하게 찾아가지 못한다.

      //    React에서는 주로 아래방법처럼 외부에 선언한 함수를 constructor 안에서 바인딩한다.
      this.handleChange = this.handleChange.bind(this)
      //   this.handleClick = this.handleClick.bind(this)
   }
   handleChange(e) {
      this.setState({ message: e.target.value })
   }
   // 화살표함수를 이용하면 오토바인딩이 되어서 따로 바인딩 설정을 해주지 않아도 가능
   handleClick = () => {
      alert(this.state.message)
      this.setState({
         message: '',
      })
   }
   render() {
      return (
         <div>
            <h1>Practice Event</h1>
            {/* 인라인으로 지정되는 이벤트들은 onClick, onChage 처럼 카멜방식사용 */}
            {/* 매개변수 e 로 받는 이벤트객체 사용법은 js와 동일 */}
            <input
               type="text"
               name="message"
               placeholder="any"
               value={this.state.message}
               onChange={this.handleChange}
            />
            <button type="submit" onClick={this.handleClick}>
               Confirm
            </button>
            <br />
         </div>
      )
   }
}

export default EventPractice
