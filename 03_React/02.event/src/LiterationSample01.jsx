import React, { useState } from 'react'

const LiterationSample01 = () => {
   const names = ['snowman', 'ice', 'snow', 'wind']
   // 지정된배열.map(변수명 => {변수에 넣을 값});
   // 지정된 배열의 각 요소들로 맵함수 (조건)에 맞게 새로운 배열을 생성한다.
   // 이런형식으로 배열로 렌더를 실행할때는 반드시 key props 값을 넣어주어야한다.
   // key값은 DOM 내부에서 유일한 값을 지정해야함.
   const nameList = names.map((name, idx) => <li key={idx}>{name}</li>)

   const [foods, setFoods] = useState([
      { id: 1, text: 'rice' },
      { id: 2, text: 'bread' },
      { id: 3, text: 'noodle' },
      { id: 4, text: 'fruit' },
   ])
   const [inputtext, setInputText] = useState('')
   const [nextid, setNextId] = useState(5)
   const inputChange = e => setInputText(e.target.value)
   const addBtn = () => {
      // 들어온정보로 concat으로 기존배열+정보 로 새로운 배열생성
      // .push() 로는 안되네. 왜일까? 얕은복사로 데이터를 바꿔넣어서 useState랑 충돌나는거 아닐까?
      // 푸시는 배열의 길이를 리턴해서 배열 그 자체를 리턴하는게 아니라서
      const nextFoods = foods.concat({ id: nextid, text: inputtext })

      // id번호 하나 추가
      setNextId(nextid + 1)
      // 기존배열을 새로 생성된 배열로 업데이트
      setFoods(nextFoods)
      setInputText('')
   }
   const foodList = foods.map(food => (
      <li key={food.id} onDoubleClick={() => onRemove(food.id)}>
         {food.text}
      </li>
   ))

   const onRemove = id => {
      // filter(); 함수로 현재 클릭한 li의 id번호와 맞지않는(클릭하지 않은것)들로만 새로 배열을 생성함.
      const nextFoods = foods.filter(foods => foods.id !== id)
      setFoods(nextFoods)
      console.log(nextFoods)
   }
   return (
      <>
         <ul>{nameList}</ul>
         <input type="text" value={inputtext} onChange={inputChange}></input>
         <button type="submit" onClick={addBtn}>
            ADD
         </button>
         <ul>{foodList}</ul>
      </>
   )
}

export default LiterationSample01
