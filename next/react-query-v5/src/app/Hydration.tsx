'use client';

import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export default function Hydration() {
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
    });

    return <>{res.data?.map((string) => <p key={string}>{string}</p>)}</>;
}
