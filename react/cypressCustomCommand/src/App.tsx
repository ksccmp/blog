import React from 'react';
import { Route, Routes } from 'react-router';
import Home from './pages/home';
import Login from './pages/login';
import Register from './pages/register';

const App = () => {
    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/home" element={<Home />} />
            <Route path="/register" element={<Register />} />
        </Routes>
    );
};

export default App;
