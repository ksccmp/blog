// prev react-query-v5
import { useQueries } from '@tanstack/react-query';
import axios from 'axios';

export default function Combine() {
    const pages = [1, 2];
    const res = useQueries({
        queries: pages.map((page) => ({
            queryKey: ['strings', 'pages', page],
            queryFn: async () =>
                (
                    await axios.get('http://localhost:8080/strings/pages', {
                        params: {
                            page,
                            limit: 2,
                        },
                    })
                ).data,
        })),
        // not use combine, html is complexible
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.map((queryRes) => (queryRes.data as string[])?.map((string) => <p key={string}>{string}</p>))}
                {res.some((queryRes) => queryRes.isFetching) && (
                    <div>
                        <h2>isFetching...</h2>
                    </div>
                )}
            </div>
        </main>
    );
}
