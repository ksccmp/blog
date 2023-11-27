// prev react-query-v5
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
                {/* 캐시된 데이터가 없는 경우 : isLoading */}
                <p>isLoading: {String(res.isLoading)}</p>
                {/* API 호출이 응답되지 않은 경우 : isFetching */}
                <p>isFetching: {String(res.isFetching)}</p>
                {/* isLoading && isFetching의 결과 : isInitialLoading */}
                <p>isInitialLoading: {String(res.isInitialLoading)}</p>

                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}
