// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function WindowFocus() {
    const res = useQuery<string[]>({
        // refetchOnWindowFocus work screen focus event
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
