import React, { useState, useEffect } from 'react'

const Info = () => {
   // 변수앞에 항상 const, let, var 정의하는거 잊지말기. 한참 헤맸네.
   const [name, setName] = useState('')
   const [alias, setAlias] = useState('')
   const onChangeName = e => setName(e.target.value)
   const onChangeAlias = e => setAlias(e.target.value)

   // useEffect(() => {}) = 콤포넌트가 렌더링이 될 때마다 실행하는 함수.
   useEffect(() => {
      console.log('Render is Done')
   })
   // useEffect(() => {}, [값]) = 배열로 지정된 값이 업데이트 될 때에만 함수를 실행.
   // 값이 공백일경우에는 첫 렌더링에서 실행한 후 이후 업데이트에서는 반응하지 않음.
   // useEffect(() => {return () => {}}, []) = 렌더링 전에 return에 지정된 함수를 실행한다
   // 위와 같은 콤포넌트가 업데이트되기 전에 실행하는 함수들을 뒷정리 함수라고 한다.
   useEffect(() => {
      console.log('Onetime, No Update')
   }, [])
   useEffect(() => {
      console.log('Every name Change')
   }, [name])

   return (
      <div>
         <div>
            <input value={name} onChange={onChangeName} />
            <input value={alias} onChange={onChangeAlias} />
         </div>
         <div>
            <div>
               <b>NAME : {name}</b>
            </div>
            <div>
               <b>ALIAS : {alias}</b>
            </div>
         </div>
      </div>
   )
}

export default Info
