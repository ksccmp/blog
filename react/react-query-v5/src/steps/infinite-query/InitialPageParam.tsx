// react-query-v5
import { useInfiniteQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function InitialPageParam() {
    const res = useInfiniteQuery<string[]>({
        queryKey: ['strings'],
        // pageParam cannot set initial data in queryFn parameter
        queryFn: async ({ pageParam }) =>
            (
                await axios.get('http://localhost:8080/strings/pages', {
                    params: {
                        page: pageParam,
                        limit: 2,
                    },
                })
            ).data,
        getNextPageParam: (_lastPage, allPages) => allPages.length + 1,

        // pageParam can set initial data at initialPageParam
        initialPageParam: 1,
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
