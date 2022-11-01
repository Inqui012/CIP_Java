import React, {useState} from 'react';

const Say = () => {
    // useState(); = 
    const [message, setMessage] = useState('');
    const onClickEnter = () => setMessage('Welcome!')
    const onClickExit = () => setMessage('Farawell!')
    return (
        <div>
            <hr></hr>
            <button onClick={onClickEnter}>ENTER</button><br />
            <button onClick={onClickExit}>EXIT</button><br />
            <h1>{ message }</h1>
        </div>
    );
}

export default Say;
