// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function Options() {
    // (1) not use object
    const res = useQuery<string[]>(['strings'], async () => (await axios.get('http://localhost:8080/strings')).data);

    // (2) use object
    // const res = useQuery<string[]>({
    //     queryKey: ['strings'],
    //     queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
    // });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}
