export default function RootPage() {
    return (
        <main className="m-2">
            <div>
                <h2 className="text-3xl font-bold">NEXT_PUBLIC_MODE</h2>
                <p data-testid="mode-text">{process.env.NEXT_PUBLIC_MODE}</p>
                <p data-testid="node-env-text">{process.env.NODE_ENV}</p>
            </div>
        </main>
    );
}
