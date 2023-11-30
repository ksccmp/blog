// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import { useState } from 'react';

export default function KeepPreviousData() {
    const [page, setPage] = useState<number>(1);
    const res = useQuery<string[]>({
        queryKey: ['strings', page],
        queryFn: async () =>
            (
                await axios.get('http://localhost:8080/strings/pages', {
                    params: {
                        page,
                        limit: 2,
                    },
                })
            ).data,
        // set keepPreviousData config in keepPreviousData
        keepPreviousData: true,
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>

            <div>
                <h2>Page</h2>
                <button onClick={() => setPage(page + 1)}>increase</button>
                <button onClick={() => setPage(page - 1)}>decrease</button>
            </div>
        </main>
    );
}
