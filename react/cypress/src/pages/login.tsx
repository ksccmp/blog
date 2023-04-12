import React from 'react';
import { useNavigate } from 'react-router';

const Login = () => {
    /**
     * navigate
     */
    const navigate = useNavigate();

    /**
     * handle
     */
    const handle = {
        login: () => {
            navigate('/home');
        },
    };

    return (
        <div>
            <input data-cy="id-input" type="text" placeholder="ID" />
            <input data-cy="password-input" type="password" placeholder="Password" />
            <button data-cy="login-button" onClick={handle.login}>
                로그인
            </button>
        </div>
    );
};

export default Login;
