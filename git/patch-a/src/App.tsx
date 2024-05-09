import { useEffect, useState } from 'react';

export default function App() {
    const [messages, setMessages] = useState<string[]>([]);

    useEffect(() => {
        setMessages(['git', 'diff', 'patch']);
    }, []);

    return (
        <main>
            <h2>git diff로 patch 파일 생성하기</h2>
            <div>
                <ul>
                    {messages.map((message, index) => (
                        <li key={index}>{message}</li>
                    ))}
                </ul>
            </div>
        </main>
    );
}
