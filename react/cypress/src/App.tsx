import React from 'react';
import { Route, Routes } from 'react-router';
import Home from './pages/home';
import Login from './pages/login';

const App = () => {
    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/home" element={<Home />} />
        </Routes>
    );
};

export default App;
