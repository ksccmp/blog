import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import Variables from './steps/mutation/Variables';

export default function App() {
    const queryClient = new QueryClient();

    return (
        <QueryClientProvider client={queryClient}>
            <Variables />
        </QueryClientProvider>
    );
}
