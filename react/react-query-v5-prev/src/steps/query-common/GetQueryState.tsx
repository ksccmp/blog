// prev react-query-v5
import { useQuery, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';

export default function GetQueryState() {
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
                <h2>queryState</h2>
                {queryClient
                    .getQueryState<string[]>(
                        ['strings'],
                        // set query filter
                        {
                            type: 'active',
                            stale: true,
                        },
                    )
                    ?.data?.map((string) => <p key={string}>{string}</p>)}
            </div>
        </main>
    );
}
