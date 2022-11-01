import { Component } from 'react';
import PropTypes from 'prop-types';


class MyComponent01 extends Component {
    // 클래스형식에서는 static을 사용해서 기본값, 필수값등을 설정해줄 수 있음.
    static defaultProps = {
        name: "DEFAULT"
    }
    static propTypes = {
        name: PropTypes.string,
        forNumber: PropTypes.number.isRequired
    }
    render() {
        // 클래스형이라서 props도 this.props로 받아옴
        const { name, forNumber, children } = this.props;
        return (
            <>
                CLASS COMPONENT PROPS : {name}<br />
                CLASS PROPS CHILDREN = {children}<br />
                CLASS FAV NUMBER = {forNumber}<br />
                <br />
            </>
        )
    }
}
export default MyComponent01
