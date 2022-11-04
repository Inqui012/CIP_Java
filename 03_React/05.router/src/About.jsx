import React from 'react'
import { useSearchParams } from 'react-router-dom'
import { useLocation } from 'react-router-dom'

const About = () => {
   // useLocation(); 쿼리스트링 전체를 가져옴
   const location = useLocation()
   // useSearchParams() 훅. 쿼리스트링을 쉽게 가져올 수 있음.
   // setSearchParams 이거는 useState 에서 사용하는 데이터 업데이트 하는 함수인듯
   const [searchParams, setSearchParams] = useSearchParams()
   // searchParams.get('키') = 지정된 키의 쿼리스트링의 '값'을 가져옴
   const detail = searchParams.get('detail')
   const mode = searchParams.get('mode')
   return (
      <div>
         <h1>ABOUT</h1>
         <p>REACT ROUTER PRACTICE</p>
         <p>DETIAL : {detail}</p>
         <p>MODE : {mode}</p>
         {/* 전체 주소에서 쿼리스트링 구문 전체를 출력하네 */}
         <p>LOCATION : {location.search}</p>
      </div>
   )
}

export default About
