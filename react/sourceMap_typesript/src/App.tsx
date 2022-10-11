import React from 'react';
import Component from './component';
import { useConstant } from './constant';

const App = () => {
    return (
        <div>
            <h2>sourceMap Test App</h2>
            <Component />
            <h3>{useConstant}</h3>
        </div>
    );
};

export default App;
