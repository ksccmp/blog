import React from 'react';
import { Outlet } from 'react-router';

const WrapperPage = () => {
    return (
        <div>
            <h1>WrapperPage</h1>
            <div>
                <Outlet />
            </div>
        </div>
    );
};

export default WrapperPage;
