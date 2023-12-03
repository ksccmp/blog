import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import Combine from './steps/queries/Combine';

export default function App() {
    const queryClient = new QueryClient();

    return (
        <QueryClientProvider client={queryClient}>
            <Combine />
        </QueryClientProvider>
    );
}
