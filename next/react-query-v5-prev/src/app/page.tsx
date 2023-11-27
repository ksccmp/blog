// prev react-query-v5
import { Hydrate, QueryClient, dehydrate } from '@tanstack/react-query';
import axios from 'axios';
import { cache } from 'react';
import Hydration from './Hydration';

export default async function Home() {
    const queryClient = cache(() => new QueryClient())();
    await queryClient.prefetchQuery({
        queryKey: ['strings'],
        queryFn: async () => (await axios.get('http://localhost:8080/strings')).data,
    });
    const dehydratedState = dehydrate(queryClient);

    return (
        // dehydratedState 등록을 위해 Hydrate 사용
        <Hydrate state={dehydratedState}>
            <main>
                <div>
                    <h2>Strings</h2>
                    <Hydration />
                </div>
            </main>
        </Hydrate>
    );
}
