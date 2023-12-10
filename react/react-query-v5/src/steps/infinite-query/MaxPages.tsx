// react-query-v5
import { useInfiniteQuery, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';

export default function MaxPages() {
    const queryClient = useQueryClient();
    const res = useInfiniteQuery<string[]>({
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

        // only last 3 page datas caching
        maxPages: 3,
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.pages.map((strings, page) =>
                    strings.map((string) => <p key={`${page}${string}`}>{string}</p>),
                )}
            </div>

            <button onClick={() => res.fetchNextPage()}>nextPage</button>

            {/* do not fetch only selected pages */}
            <button
                onClick={() =>
                    queryClient.refetchQueries({
                        queryKey: ['strings'],
                    })
                }
            >
                최근 3개 페이지만 (= 모든 페이지) refetch 수행
            </button>
        </main>
    );
}
