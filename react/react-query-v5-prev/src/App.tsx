import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import IsDataEqual from './steps/query-common/IsDataEqual';

export default function App() {
    const queryClient = new QueryClient();

    return (
        <QueryClientProvider client={queryClient}>
            <IsDataEqual />
        </QueryClientProvider>
    );
}
