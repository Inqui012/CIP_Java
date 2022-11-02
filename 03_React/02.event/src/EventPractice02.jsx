import React, { Component } from 'react'

class EventPractice02 extends Component {
   state = {
      message: '',
      username: '',
   }
   handleChange = e => {
      // [e.target.name] = 현재 이벤트가 발생한 DOM이 가지고 있는 name 값을 가져옴.
      // 객체데이터의 값을 []를 이용해서 가져올 수 있다.
      // state[message] = state.message
      this.setState({ [e.target.name]: e.target.value })
   }
   handleClick = () => {
      alert(this.state.message + ':' + this.state.username)
      this.setState({
         message: '',
         username: '',
      })
   }
   render() {
      return (
         <div>
            <h1>EventPractice02</h1>
            <input
               type="text"
               name="username"
               placeholder="any"
               value={this.state.username}
               onChange={this.handleChange}
            />
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
         </div>
      )
   }
}

export default EventPractice02
