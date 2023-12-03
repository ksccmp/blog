// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function RefetchInterval() {
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,

        // use both data and query
        refetchInterval: (data, query) => {
            console.log(data);
            console.log(query.state.data);
            return false;
        },
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
