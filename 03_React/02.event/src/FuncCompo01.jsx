import React, { useState } from 'react'

const FuncCompo01 = () => {
   // EventPractice 와 같은 기능의 함수콤포넌트 useState 형식 이게 더 깔끔한듯?
   const [username, setUsername] = useState('')
   const [message, setMessage] = useState('')

   let getDate = new Date()
   const [daytime, setDaytime] = useState(getDate.toLocaleTimeString())
   const tick = () => {
      setInterval(() => {
         getDate = new Date()
         setDaytime(getDate.toLocaleTimeString())
      }, 1000)
   }
   tick()

   const onChangeUsername = e => setUsername(e.target.value)
   const onChangeMessage = e => setMessage(e.target.value)
   const onClick = e => {
      alert(message + ':' + username)
      setMessage('')
      setUsername('')
   }
   const onKeyPress = e => {
      if (e.key === 'Enter') {
         onClick()
      }
   }
   return (
      <div>
         <h1>FuncCompo01</h1>
         <input type="text" name="username" placeholder="any" value={username} onChange={onChangeUsername} />
         <input
            type="text"
            name="message"
            placeholder="any"
            value={message}
            onChange={onChangeMessage}
            onKeyPress={onKeyPress}
         />
         <button type="submit" onClick={onClick}>
            Confirm
         </button>
         <h2>{daytime}</h2>
      </div>
   )
}

export default FuncCompo01
