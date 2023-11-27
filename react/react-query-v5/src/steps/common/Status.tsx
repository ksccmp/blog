// react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function Status() {
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {/* 캐시된 데이터가 없는 경우 : isPending */}
                <p>isPending: {String(res.isPending)}</p>
                {/* API 호출이 응답되지 않은 경우 : isFetching */}
                <p>isFetching: {String(res.isFetching)}</p>
                {/* isPending && isFetching의 결과 : isLoading */}
                <p>isLoading: {String(res.isLoading)}</p>

                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}
