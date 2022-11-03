// 콤포넌트 파일이 아니기 때문에 파일명이 소문자로 시작함.
import { useReducer } from 'react'

function reducer(state, action) {
   return {
      ...state,
      [action.name]: action.value,
   }
}

// 함수를 export 가능
export default function useInputs(init) {
   const [state, dispatch] = useReducer(reducer, init)
   const onChange = e => dispatch(e.target)
   return [state, onChange]
}
