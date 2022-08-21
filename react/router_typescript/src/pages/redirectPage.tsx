import React from 'react';
import { Navigate } from 'react-router';

const RedirectPage = () => {
    return (
        <div>
            <h2>RedirectPage</h2>
            <Navigate to="/" />
        </div>
    );
};

export default RedirectPage;
