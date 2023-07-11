import { lazy } from 'react';
import { Route, Routes } from 'react-router';

const Home = lazy(() => import('@/pages/home')); // lazy를 이용한 코드 스플리팅 설정
const Setting = lazy(() => import('@/pages/setting')); // lazy를 이용한 코드 스플리팅 설정

const App = () => {
    return (
        <Routes>
            <Route path="/home" element={<Home />} />
            <Route path="/setting" element={<Setting />} />
        </Routes>
    );
};

export default App;
