// prev react-query-v5
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
        // mutate가 호출된 경우
        onMutate: async (newString: string) => {
            // 어떠한 외부 refetch가 발생되어도 query가 변경되지 않고 유지
            await queryClient.cancelQueries({ queryKey: ['strings'] });
            // 이전 캐싱 데이터를 snapshot 처리
            const prevStrings = queryClient.getQueryData(['strings']);
            // query key에 새로운 데이터 임의로 추가하기
            queryClient.setQueryData<string[]>(['strings'], (prevStrings) =>
                prevStrings ? [...prevStrings, newString] : [newString],
            );
            // context로 반환
            return {
                prevStrings,
            };
        },
        // error가 발생된 경우
        onError: (_error, _newString, context) => {
            queryClient.setQueryData(['strings'], context?.prevStrings);
        },
        // error or success가 발생된 경우 refetch 수행
        onSettled: () => {
            queryClient.invalidateQueries({
                queryKey: ['strings'],
            });
        },
    });

    return (
        <main>
            <div>
                <h2>Strings</h2>
                {res.data?.map((string) => <p key={string}>{string}</p>)}
            </div>

            <div>
                <button onClick={() => mutation.mutate('newString')}>add newString</button>
            </div>
        </main>
    );
}
