import { Route, Routes } from 'react-router-dom'
import Home from './Home'
import About from './About'

function App() {
   return (
      <Routes>
         {/* path 로 사용자가 어떤 주소로 이동했는지 감지한다. */}
         {/* element 로 해당 주소로 이동했을때 보여줄 콤포넌트를 지정 */}
         <Route path="/" element={<Home />} />
         <Route path="/About" element={<About />} />
      </Routes>
   )
}

export default App
