'use client';

import axios from 'axios';
import { useEffect, useState } from 'react';

export default function RootPage() {
    const [names, setNames] = useState<string[]>([]);

    const apiGetNames = async () => {
        const res = await axios.get('/get-names');
        if (res) {
            setNames(res.data);
        }
    };

    useEffect(() => {
        apiGetNames();
    }, []);

    return (
        <main className="m-4">
            <h2 className="text-2xl font-bold">Storybook Names ...</h2>

            <div>
                <ul>
                    {names.map((name) => (
                        <li key={name} data-testid="name-list-item">
                            {name}
                        </li>
                    ))}
                </ul>
            </div>
        </main>
    );
}
