// react-query-v5
import { UseQueryResult, useQuery } from '@tanstack/react-query';

export default function ErrorDefaultType() {
    // error type is Error
    const res: UseQueryResult<string[], Error> = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => {
            throw 'force exception';
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
