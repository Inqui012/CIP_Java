import React, { useState } from 'react'

const EventQuiz = () => {
   const [userid, setUserid] = useState('')
   const [userpwd, setUserpwd] = useState('')

   const onChangeUserid = e => setUserid(e.target.value)
   const onChangeUserpwd = e => setUserpwd(e.target.value)
   const onKeyPress = e => {
      if (e.key === 'Enter') {
         onClick()
      }
   }
   const onClick = () => {
      if (!userid || !userpwd) {
         alert('ther is blank')
      } else {
         alert(`ID : ${userid} / PW : ${userpwd}`)
      }
   }

   return (
      <div>
         <h1>EventQuiz</h1>
         <input type="text" name="userid" placeholder="id" value={userid} onChange={onChangeUserid} />
         <input
            type="password"
            name="userpwd"
            placeholder="password"
            value={userpwd}
            onChange={onChangeUserpwd}
            onKeyPress={onKeyPress}
         />
         <button type="submit" onClick={onClick}>
            Confirm
         </button>
      </div>
   )
}

export default EventQuiz
