import type { AppProps } from 'next/app';
import { useState } from 'react';
import { DehydratedState, Hydrate, QueryClient, QueryClientProvider } from 'react-query';

const App = ({ Component, pageProps }: AppProps<{ dehydratedState: DehydratedState }>) => {
    /**
     * queryClient
     */
    const [queryClient] = useState(() => new QueryClient());

    return (
        <QueryClientProvider client={queryClient}>
            {/* hydration을 사용하기 위해 hydrate 등록 필수 */}
            <Hydrate state={pageProps.dehydratedState}>
                <Component {...pageProps} />
            </Hydrate>
        </QueryClientProvider>
    );
};

export default App;
