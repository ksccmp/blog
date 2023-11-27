// prev react-query-v5
import { useQuery } from '@tanstack/react-query';
import { ErrorBoundary } from 'react-error-boundary';

function ThrowOnError() {
    // use useErrorBoundary for throw error
    const res = useQuery<string[]>({
        queryKey: ['strings'],
        queryFn: async () => {
            throw 'force exception';
        },
        useErrorBoundary: true, // set useErrorBoundary
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

export default function ErrorBoundaryThrowOnError() {
    return (
        <ErrorBoundary fallback={<p>ErrorBoundary Error...</p>}>
            <ThrowOnError />
        </ErrorBoundary>
    );
}
