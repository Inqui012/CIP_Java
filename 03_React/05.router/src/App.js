import { Route, Routes } from 'react-router-dom'
import Home from './Home'
import About from './About'
import Profile from './Pages/Profile'

function App() {
   return (
      <Routes>
         {/* path 로 사용자가 어떤 주소로 이동했는지 감지한다. */}
         {/* element 로 해당 주소로 이동했을때 보여줄 콤포넌트를 지정 */}
         {/* a 태그와의 차이점은 SPA 방식이라는점 */}
         <Route path="/" element={<Home />} />
         <Route path="/About" element={<About />} />
         {/* Profiles/:데이터를 보낼 매개변수이름? */}
         <Route path="/Profiles/:username" element={<Profile />} />
      </Routes>
   )
}

export default App
