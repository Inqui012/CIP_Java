import React, { useState, useMemo, useCallback } from 'react'
import { useRef } from 'react'

// 으음...여기가 안되는데 왜일까
// const getAverage = lists => {
//    if (lists.legnth === 0) {
//       return 0
//    } else {
//       // reduce((이전값, 다음값) => 계산 , 초기값)
//       const sum = lists.find(val => !isNaN(val)).reduce((a, b) => a + b, 0)
//       return sum / lists.length
//    }
// }

const Average = () => {
   const [list, setList] = useState([])
   const [number, setNumber] = useState('')
   const inputEl = useRef(null)
   // useCallback(제어할 함수, [배열]) = 배열안에는 제어할 함수에 들어가는 변수들을 넣어준다.
   // 해당 변수들이 업데이트될 때에만 함수를 생성하게 만든다. 함수를 재사용할떄 사용.
   const onChange = useCallback(e => setNumber(e.target.value), [])
   const onClick = () => {
      const nextList = list.concat(parseInt(number))
      setList(nextList)
      setNumber('')
      inputEl.current.focus()
   }
   const printList = list.map((val, idx) => <li key={idx}>{val}</li>)
   // useMemo(() => {}, [배열]) = 배열의 값이 바뀔때만 함수가 실행된다. 결과값을 재사용.
   const avg = useMemo(() => {
      //   getAverage(list)
      console.log(list.length)
   }, [list])

   return (
      <div>
         <hr />
         <h1>Average</h1>
         <input value={number} onChange={onChange} ref={inputEl}></input>
         <button onClick={onClick}>APPLY</button>
         <ul>{printList}</ul>
         <div>
            <b>Avg : {avg}</b>
         </div>
      </div>
   )
}

export default Average
