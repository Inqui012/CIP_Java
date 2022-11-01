import React, {useState} from 'react';

const Say = () => {
    // Hook = 함수형 콤포넌트에서 사용할 수 없었던 생명주기 기능을 가능하게 해주는기능?
    // useState(초기값); = State를 관리할 수 있는 hook.
    // const [state 객체의 키, 지정된 키를 업데이트하는 기능의 이름?] = useState(기본값);
    // 위와같이 비구조화로 변수를 정의해놓고 후에 업데이트기능(업데이트할 데이터) 로 실행시킴.
    const [message, setMessage] = useState('');
    const onClickEnter = () => setMessage('Welcome!')
    const onClickExit = () => setMessage('Farawell!')
    const [color, setColor] = useState('black');
    const onClickColorRed = () => setColor('red');
    const onClickColorGreen = () => setColor('green');
    const onClickColorBlue = () => setColor('blue');

    return (
        <div>
            <hr></hr>
            <button onClick={onClickEnter}>ENTER</button><br />
            <button onClick={onClickExit}>EXIT</button><br />
            <button style={{ color: 'red' }} onClick={onClickColorRed}>COLOR-RED</button><br />
            <button style={{color: 'green'}} onClick={onClickColorGreen}>COLOR-GREEN</button><br />
            <button style={{color: 'blue'}} onClick={onClickColorBlue}>COLOR-BLUE</button><br />
            {/* 인라인으로 속성이나 스타일 넣을때 중괄호 두번넣어야함. 주의. */}
            <h1 style={{ color }}>{message}</h1>
        </div>
    );
}

export default Say;
