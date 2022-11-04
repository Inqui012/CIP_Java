import React from 'react'
import { Link } from 'react-router-dom'

const Home = () => {
   return (
      <div>
         <h1>HOME</h1>
         <p>REACT ROUTER PRACTICE</p>
         {/* a 태그의 기능처럼 클릭하면 지정된 주소로 이동한다. */}
         <Link to="/About">TO ABOUT</Link>
      </div>
   )
}

export default Home
