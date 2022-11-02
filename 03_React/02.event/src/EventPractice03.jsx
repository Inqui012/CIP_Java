import React, { Component } from 'react'

class EventPractice03 extends Component {
   state = {
      message: '',
      username: '',
   }
   handleChange = e => {
      this.setState({ [e.target.name]: e.target.value })
   }
   handleClick = () => {
      alert(this.state.message + ':' + this.state.username)
      this.setState({
         message: '',
         username: '',
      })
   }
   handleKeyPress = e => {
      if (e.key === 'Enter') {
         this.handleClick()
      }
   }
   render() {
      return (
         <div>
            <h1>EventPractice03</h1>
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
               onKeyPress={this.handleKeyPress}
            />
            <button type="submit" onClick={this.handleClick}>
               Confirm
            </button>
         </div>
      )
   }
}

export default EventPractice03
