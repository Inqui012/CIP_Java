import React, { Component } from 'react';

// State = 일부 콤포넌트에서만 한정되어 사용하는 데이터. 시간경과에 따라 업데이트 가능. 객체

class Counter extends Component {
    constructor(props) {
        super(props);   // 확장클래스인 Counter의 상위인 Component에서 props를 가져옴
        this.state = {
            numberUp: 0,
            numberDown: 0,
            getDate: new Date()
        }
    }
    // 생명주기 메소드 = 라이프사이클 = 콤포넌트의 생성/삭제에 영향을 받는 매소드들
    // 콤포넌트로 생성된 DOM이 랜더링 될 때마다 실행할것들, 마운팅.
    componentDidMount() {
        /// timer 객체는 위에서 지정하지 않았지만 데이터 흐름안에 포함되지 않을경우는 밖에서 따로 추가해줄 수 있다?
        // 외부에 보이지 않는 애들이란 뜻인가? 아니면 그냥 다 해도 되는데 권장하지 않는 방법인가.
        this.timer = setInterval(() => {
            this.setState({getDate: new Date()})
        }, 1000);
    }
    // 콤포넌트가로 생성된 DOM이 삭제될때마다 실행할것들, 언마운팅.
    componentWillUnmount() {
        clearInterval(this.timer);
    }
    render() {
        // const { number } = this.props; 이렇게 변수로 저장해서 변수명으로 해도 가능.
        return (
            <div>
                <hr></hr>
                <h1>현재시간 { this.state.getDate.toLocaleTimeString() }</h1>
                <h1>증가하는 수치 : {this.state.numberUp}</h1>
                <button onClick={() => {
                    // setState = state 객체의 수치들을 다시 조정할 수 있다. 변경될때는 무조건 render를 다시하게된다.
                    // this.setState((prevState) => {return {numberUp: this.state.numberUp + 1}}) 로도 사용가능. 아래와 동일
                    this.setState({ numberUp: this.state.numberUp + 1})
                }}>증가</button>
                <h1>감소하는 수치 : {this.state.numberDown}</h1>
                <button onClick={() => {
                    this.setState({ numberDown: this.state.numberDown - 1})
                }}>감소</button>
                <button onClick={() => {
                    // setState({객체수정}, 콜백함수) 형식도 가능. 우선 객체를 수정한 후에 함수를 실행한다.
                    this.setState({ numberDown: this.state.numberDown - 1 }, () => {
                        console.log('Click button');
                    })
                }}>콘솔버튼</button>
            </div>
        );
    }
}

export default Counter;
