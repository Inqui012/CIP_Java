import React, { Component } from 'react'

class ValidateSample01 extends Component {
   state = {
      password: '',
      clicked: false,
      vaildated: false,
   }
   handleChange = e => {
      this.setState({ password: e.target.value })
   }
   handleBtnClick = () => {
      this.setState({ clicked: true, vaildated: this.state.password === '0000' })
      // 아래 DOM에서 ref를 설정해주었기 때문에 이 이름으로 가져올 수 있음.
      this.reftest.focus()
   }
   render() {
      return (
         <div>
            <h1>VaildateSample01</h1>
            <input
               type="password"
               //   조건식은 삼항연산자밖에 사용 못함.
               className={this.handleBtnClick ? (this.state.vaildated === true ? 'success' : 'failed') : ''}
               value={this.state.password}
               onChange={this.handleChange}
               // ref={(ref) => { this.임의의이름 = ref; }}
               ref={ref => {
                  this.reftest = ref
               }}></input>
            <button onClick={this.handleBtnClick}>Vaildate</button>
         </div>
      )
   }
}

export default ValidateSample01
