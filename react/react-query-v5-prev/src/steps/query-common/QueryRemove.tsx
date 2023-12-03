// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function QueryRemove() {
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>

            <div>
                {/* if want to remove query, use result */}
                <button onClick={() => res.remove()}>query remove</button>
            </div>
        </main>
    );
}
