import React, { useState, useMemo, useCallback } from 'react'

// 으음...여기가 안되는데 왜일까
const getAvg = numbers => {
   //    if (numbers.legnth === 0) return 0
   // reduce((이전값, 다음값) => 계산 , 초기값)
   const sum = numbers.reduce((a, b) => a + b, 0)
   return sum / numbers.legnth
}

const Average = () => {
   const [list, setList] = useState([])
   const [number, setNumber] = useState('')

   // useCallback(제어할 함수, [배열]) = 배열안에는 제어할 함수에 들어가는 변수들을 넣어준다.
   // 해당 변수들이 업데이트될 때에만 함수를 생성하게 만든다. 함수를 재사용할떄 사용.
   const onChange = useCallback(e => setNumber(e.target.value), [])
   const onClick = e => {
      const nextList = list.concat(parseInt(number))
      setList(nextList)
      setNumber('')
   }
   const printList = list.map((val, idx) => <li key={idx}>{val}</li>)
   // useMemo(() => {}, [배열]) = 배열의 값이 바뀔때만 함수가 실행된다. 결과값을 재사용.
   const avg = useMemo(() => {
      getAvg(list)
   }, [list])

   return (
      <div>
         <hr />
         <input value={number} onChange={onChange}></input>
         <button onClick={onClick}>APPLY</button>
         <ul>{printList}</ul>
         <div>
            <b>Avg : {avg}</b>
         </div>
      </div>
   )
}

export default Average
