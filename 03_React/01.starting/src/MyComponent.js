// function MyComponent() { } = ES5버전
const MyComponent = (props) => {
    // 비구조화 할당. 위의 매개변수자리에 객체형식으로 변수를 지정하는것도 많이 사용.
    const { name, children } = props;
    return (
        <>
            NEW COMPONENT PROPS : {name}<br />
            PROPS CHILDREN = {children}
        </>
        
    )
}
// 기본값 설정가능
MyComponent.defaultProps = {
    name: "DEFAULT"
}
// 외부에서 사용할 수 있게 export 를 넣어준다.
export default MyComponent