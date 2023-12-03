// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function SuccessErrorSettled() {
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,

        // use onSuccess, onError, onSettled
        onSuccess: () => {
            console.log('onSuccess!');
        },
        onError: () => {
            console.log('onError!');
        },
        onSettled: () => {
            console.log('onSettled!');
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
