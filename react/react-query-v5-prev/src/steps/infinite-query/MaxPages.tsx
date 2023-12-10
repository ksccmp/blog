// prev react-query-v5
import { useInfiniteQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function MaxPages() {
    const res = useInfiniteQuery<string[]>({
        queryKey: ['strings'],
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
        // all page datas caching
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

            {/* do fetch only selected pages */}
            <button
                onClick={() =>
                    res.refetch({
                        refetchPage: (_lastPage, index, allPages) => {
                            return index >= allPages.length - 3;
                        },
                    })
                }
            >
                최근 3개 페이지만 refetch 수행
            </button>
        </main>
    );
}
