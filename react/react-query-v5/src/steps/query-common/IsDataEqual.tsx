// react-query-v5
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function IsDataEqual() {
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
        // if length is same, use old data
        // structuralSharing: (oldData, newData) => {
        //     return oldData?.length === newData.length ? oldData : newData;
        // },
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
