import React from 'react';
import { decrypt, encrypt } from './encryption';

const App = () => {
    return (
        <div>
            <p>암호화 전 : j4jstorage</p>
            <p>암호화 후 : {encrypt('j4jstorage')}</p>
            <p>복호화 후 : {decrypt('6mewIN3Ewx8ejvpMtqBHkA==')}</p>
        </div>
    );
};

export default App;
