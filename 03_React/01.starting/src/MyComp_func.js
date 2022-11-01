import PropTypes from 'prop-types';
// function MyComponent() { } = ES5버전
const MyComponent = (props) => {
    // 비구조화 할당. 위의 매개변수자리에 객체형식으로 변수를 지정하는것도 많이 사용.
    const { name, forNumber, children } = props;
    return (
        <>
            NEW COMPONENT PROPS : {name}<br />
            {/* children 은 app.js 에서 해당 콤포넌트가 감싸고있는 내용물인듯 */}
            PROPS CHILDREN = {children}<br />
            FAV NUMBER = {forNumber}<br />
            <br />
        </>
        
    )
}

// 기본값 설정가능
MyComponent.defaultProps = {
    name: "DEFAULT"
}

// Props의 데이터 타입 검사 가능 상위에 해당 모듈? 불러와야함.
MyComponent.propTypes = {
    // 해당 키에 대한 값을 string으로 지정한 상태. string이 아닐경우 콘솔오류가 나는듯? 출력은 제대로 됨.
    name: PropTypes.string,
    // isRquired = 필수값으로 지정. 들어오는 prop값이 없을경우 콘솔오류.
    forNumber: PropTypes.number.isRequired
}
// 외부에서 사용할 수 있게 export 를 넣어준다.
export default MyComponent