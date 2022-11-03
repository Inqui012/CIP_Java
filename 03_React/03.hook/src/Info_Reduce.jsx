import React, { useReducer } from 'react'

function reducer(state, action) {
   console.log(state)
   return {
      // 매개변수로 받아온 state 를 복사해서 바로 스프레드 반환?
      // { name: '', alias: '' } 와 같음 기존 객체를 가져옴
      ...state,
      // dispatch로 받은 e.target = 타이핑한 인풋태그  = action => action.값 = 인풋태그의 name="값"
      // 업데이트가 필요한 값만 업데이트
      // 업데이트되는 값은 태그의 속성 name="값" 의 "값"을 키로하는 객체로 저장되는듯
      [action.name]: action.value,
   }
}

const InfoReduce = () => {
   const [state, dispatch] = useReducer(reducer, { nametest: '', alias01: '' })
   const { nametest, alias01 } = state
   const onChange = e => {
      dispatch(e.target)
      console.log(e.target)
   }
   return (
      <div>
         <hr />
         {/* 여기서 name의 값을 state에 저장하고싶은 키값으로 줘야함 */}
         <input name="nametest" value={nametest} onChange={onChange} />
         <input name="alias01" value={alias01} onChange={onChange} />
         NAME01 : {nametest}
      </div>
   )
}

export default InfoReduce
