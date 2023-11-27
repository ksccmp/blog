// react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function CacheTime() {
    // if want to set cacheTime, use gcTime
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
        gcTime: 30000, // set cacheTime
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}
