// react-query-v5
import { useQuery, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';

export default function GetQueryData() {
    const queryClient = useQueryClient();
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
                {/* only use query key */}
                <h2>queryData</h2>
                {queryClient.getQueryData<string[]>(['strings'])?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}
