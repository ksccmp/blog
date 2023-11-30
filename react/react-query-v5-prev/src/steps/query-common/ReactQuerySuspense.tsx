// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import React from 'react';

function Suspense() {
    // if need to suspense, set suspense option
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
        // suspense set true
        suspense: true,
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}

export default function ReactQuerySuspense() {
    return (
        <React.Suspense fallback={<p>Suspense...</p>}>
            <Suspense />
        </React.Suspense>
    );
}
