import axios from 'axios';
import React, { useEffect, useState } from 'react';

interface Data {
    name: string;
    value: number;
}

const App = () => {
    /**
     * useState
     */
    const [datas, setDatas] = useState<Data[]>([]);

    /**
     * api
     */
    const api = {
        getData: async () => {
            const res = await axios.get('http://localhost:8080/getData');
            if (res.data) {
                setDatas(res.data);
            }
        },
    };

    /**
     * useEffect
     */
    useEffect(() => {
        api.getData();
    });

    return (
        <div>
            <div>
                <h2 data-cy="name">name : base</h2>
                <p data-cy="value">value : 0</p>
            </div>

            {datas.map((data) => (
                <div key={data.value}>
                    <h2 data-cy="name">name : {data.name}</h2>
                    <p data-cy="value">value : {data.value}</p>
                </div>
            ))}
        </div>
    );
};

export default App;
