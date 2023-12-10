// react-query-v5
import { useInfiniteQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function NeedGetNextPageParam() {
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
        initialPageParam: 1,

        // if not config getNextPageParam, occur error !
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
