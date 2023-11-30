import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import KeepPreviousData from './steps/query-common/KeepPreviousData';

export default function App() {
    const queryClient = new QueryClient();

    return (
        <QueryClientProvider client={queryClient}>
            <KeepPreviousData />
        </QueryClientProvider>
    );
}
