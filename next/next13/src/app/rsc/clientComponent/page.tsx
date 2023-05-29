'use client';

import { useState } from 'react';

const RscClientComponentPage = () => {
    const [data, setData] = useState<string>('');

    return (
        <div>
            <h2>Client Component Page</h2>
            <input type="text" onChange={(e) => setData(e.target.value)} />
            <p>입력값 : {data}</p>
        </div>
    );
};

export default RscClientComponentPage;
