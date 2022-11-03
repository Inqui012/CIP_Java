import React, { useRef } from 'react'

const Component = () => {
   // useRef() 는 로컬변수로 스테이트와 다르가 변화가 있어도 렌더링이 일어나지 않음.
   const id = useRef(1)
   const setId = n => (id.current = n)
   const printId = () => console.log(id.current)
   return (
      <div>
         <hr />
         <h1>Component</h1>
         {setId}
         {printId}
      </div>
   )
}

export default Component
