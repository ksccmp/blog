/* eslint-disable prettier/prettier */

import React, { useEffect } from 'react';
import { Route, Routes, useNavigate } from 'react-router';
import LinkPage from './pages/linkPage';
import LocationPage from './pages/locationPage';
import NotFoundPage from './pages/notFoundPage';
import ParamPage from './pages/paramPage';
import RedirectPage from './pages/redirectPage';
import WrapperPage from './pages/wrapperPage';

const App = () => {
    const navigate = useNavigate();

    useEffect(() => {
        navigate('/param/j4j')
    }, [])

    return (
        <Routes>
            {/* /link를 입력하면 LinkPage 오픈 */}
            <Route path="/link" element={<LinkPage />} />
            
            {/* /location으로 시작하는 url을 입력하면 LocationPage 오픈 */}
            <Route path="/location/*" element={<LocationPage />} />

            {/* 상대경로로도 등록 가능, parameter 추가는 :을 이용 */}
            {/* /param을 입력하면 ParamPage 오픈 */}
            {/* /param/{ value }을 입력해도 ParamPage 오픈 */}
            <Route path="/param" element={<WrapperPage />}>
                <Route path="." element={<ParamPage />} />
                <Route path=":name" element={<ParamPage />} />
            </Route>

            {/* /redirect를 입력하면 RedirectPage 오픈 */}
            <Route path="/redirect" element={<RedirectPage />} />

            {/* 정의되지 않은 나머지 모든 url을 입력하면 NotFoundPage 오픈 */}
            <Route path="*" element={<NotFoundPage />} />
        </Routes>
    );
};

export default App;
