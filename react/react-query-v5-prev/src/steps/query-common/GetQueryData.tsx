// prev react-query-v5
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
                {/* use query key and add filter */}
                <h2>queryData</h2>
                {queryClient
                    .getQueryData<string[]>(
                        ['strings'],
                        // set query filter
                        {
                            type: 'active',
                            stale: true,
                        },
                    )
                    ?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}
