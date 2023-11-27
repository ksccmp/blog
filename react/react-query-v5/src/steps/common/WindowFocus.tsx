// react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function WindowFocus() {
    // refetchOnWindowFocus not work screen focus event
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
        refetchOnWindowFocus: true, // set refetchOnWindowFocus
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
