// prev react-query-v5
import { useInfiniteQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function InitialPageParam() {
    const res = useInfiniteQuery<string[]>({
        queryKey: ['strings'],
        // pageParam can set initial data in queryFn parameter
        queryFn: async ({ pageParam = 1 }) =>
            (
                await axios.get('http://localhost:8080/strings/pages', {
                    params: {
                        page: pageParam,
                        limit: 2,
                    },
                })
            ).data,
        getNextPageParam: (_lastPage, allPages) => allPages.length + 1,
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.pages.map((strings, page) =>
                    strings.map((string) => <p key={`${page}${string}`}>{string}</p>),
                )}
            </div>
        </main>
    );
}
