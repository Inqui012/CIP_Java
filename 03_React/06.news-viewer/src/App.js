import './App.css';
import { Route, Routes } from 'react-router-dom';
import NewsPage from './Pages/NewsPage';

function App() {
  return (
    <Routes>
      {/* 표시할 주소를 설정. 아무것도 없으면 루트. */}
      <Route path='/' element={<NewsPage />} />
      <Route path='/:category' element={<NewsPage />} />
    </Routes>
  );
}

export default App;
