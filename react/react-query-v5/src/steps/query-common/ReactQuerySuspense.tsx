// react-query-v5
import { useSuspenseQuery } from '@tanstack/react-query';
import axios from 'axios';
import React from 'react';

function Suspense() {
    // if need to suspense, use SuspenseQuery
    const res = useSuspenseQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
        // removed suspense option
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
