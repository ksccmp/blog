// react-query-v5
import { useInfiniteQuery, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';

function Page() {
    const res = useInfiniteQuery<string[]>({
        queryKey: ['strings'],
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

export default function PrefetchPages() {
    const queryClient = useQueryClient();
    queryClient.prefetchInfiniteQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async ({ pageParam }) => {
            return (
                await axios.get('http://localhost:8080/strings/pages', {
                    params: {
                        page: pageParam,
                        limit: 2,
                    },
                })
            ).data;
        },
        initialPageParam: 1,
        getNextPageParam: (_lastPage, allPages) => allPages.length + 1,

        // 3 pages can prefetched
        pages: 3,
    });

    return <Page />;
}
