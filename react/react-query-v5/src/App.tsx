import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import PrefetchPages from './steps/infinite-query/PrefetchPages';

export default function App() {
    const queryClient = new QueryClient();

    return (
        <QueryClientProvider client={queryClient}>
            <PrefetchPages />
        </QueryClientProvider>
    );
}
