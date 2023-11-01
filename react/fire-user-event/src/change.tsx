import { useState } from 'react';

export default function Change() {
    const [data, setData] = useState<string>('');

    return (
        <main>
            <input data-testid="input" type="text" onChange={(e) => setData(e.target.value)} />
            <h2 data-testid="data-text">{data}</h2>
        </main>
    );
}
