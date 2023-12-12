// react-query-v5
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';

export default function Variables() {
    const queryClient = useQueryClient();
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
    });

    const mutation = useMutation({
        mutationFn: async (string: string) =>
            await axios.post('http://localhost:8080/strings', {
                string,
            }),
        // error or success가 발생된 경우 refetch 수행
        // promise 형태의 return을 수행해야 refetch가 모두 종료될때까지 'pending' 상태를 유지
        onSettled: async () => {
            return await queryClient.invalidateQueries({
                queryKey: ['strings'],
            });
        },
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.map((string) => <p key={string}>{string}</p>)}
                {/* pending 되는 동안 refetch가 발생된 것 처럼 ui를 제공 */}
                {mutation.isPending && <p>{mutation.variables}</p>}
                {/* error가 발생되면 retry를 위한 ui를 제공 */}
                {mutation.isError && (
                    <>
                        <p>{mutation.variables} add failed...</p>
                        <button onClick={() => mutation.mutate(mutation.variables)}>retry</button>
                    </>
                )}
            </div>

            <div>
                <button onClick={() => mutation.mutate('newString')}>add newString</button>
            </div>
        </main>
    );
}
