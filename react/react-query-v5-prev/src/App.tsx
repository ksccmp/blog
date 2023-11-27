import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import WindowFocus from './steps/common/WindowFocus';

export default function App() {
    const queryClient = new QueryClient();

    return (
        <QueryClientProvider client={queryClient}>
            <WindowFocus />
        </QueryClientProvider>
    );
}
