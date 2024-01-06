'use client';

import { useEffect, useState } from 'react';

export default function RootPage() {
    const [names, setNames] = useState<string[]>([]);

    const apiGetNames = async () => {
        const res = await fetch('/get-names');
        if (res) {
            setNames(await res.json());
        }
    };

    useEffect(() => {
        apiGetNames();
    }, []);

    return (
        <main className="m-4">
            <h2 className="text-2xl font-bold">Browser Env Names ...</h2>

            <div>
                <ul>
                    {names.map((name) => (
                        <li key={name}>{name}</li>
                    ))}
                </ul>
            </div>
        </main>
    );
}
