import React, { useReducer } from 'react'

function reducer(state, action) {
   switch (action.type) {
      case 'INCREMENT':
         return { value: state.value + 1 }
      case 'DECREMENT':
         return { value: state.value - 1 }
      default:
         return state
   }
}

const Counter = () => {
   // useReducer(함수명, {기본값}) = 기본값은 지정한 함수의 state 매개변수의 객체값으로 들어감.
   const [state, dispatch] = useReducer(reducer, { value: 0 })
   return (
      <div>
         <hr />
         <p>
            COUNTER : <b>{state.value}</b>
         </p>
         {/* dispatch(리듀서 함수에서 실행할 객체값); = 리듀서 함수로 객체값을 보낸다.  */}
         {/* dispatch() 에서 보낸 값은 리듀서의 action 객체의 값으로 들어간다. */}
         <button onClick={() => dispatch({ type: 'INCREMENT' })}>+1</button>
         <button onClick={() => dispatch({ type: 'DECREMENT' })}>-1</button>
      </div>
   )
}

export default Counter
