import axios from 'axios';
import { FormEvent, useState } from 'react';

interface EventMessage {
    eventName: string;
    data: string;
}

export default function App() {
    // state
    const [id, setId] = useState<string>('');
    const [eventName, setEventName] = useState<string>('');
    const [data, setData] = useState<string>('');
    const [eventMessages, setEventMessages] = useState<EventMessage[]>([]);

    // message event config
    const configMessageEvent = (event: MessageEvent) => {
        setEventMessages((prev) => [
            ...prev,
            {
                eventName: event.type,
                data: event.data,
            },
        ]);
    };

    // event handler
    const handleSubmitSubscribe = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        const eventSource = new EventSource(`http://localhost:8080/subscribe/${id}`);

        // 연결된 sse emitter의 event name(connect, alarm, message 등)에 맞는 event가 전달되는 경우
        eventSource.addEventListener('connect', (event) => {
            configMessageEvent(event);
        });

        eventSource.addEventListener('alarm', (event) => {
            configMessageEvent(event);
        });

        eventSource.addEventListener('message', (event) => {
            configMessageEvent(event);
        });
    };

    const handleSubmitSend = async (e: FormEvent<HTMLFormElement>, eventName: string, data: string) => {
        e.preventDefault();
        await axios.post(`http://localhost:8080/send/${id}`, {
            eventName,
            data,
        });
    };

    return (
        <main>
            <div>
                <h2>SSE Subscribe</h2>
                <form onSubmit={(e) => handleSubmitSubscribe(e)}>
                    <input type="text" placeholder="id" value={id} onChange={(e) => setId(e.target.value)} />
                    <button>Subscribe</button>
                </form>
            </div>

            <div>
                <h2>SSE Send</h2>
                <form onSubmit={(e) => handleSubmitSend(e, eventName, data)}>
                    <input
                        type="text"
                        placeholder="event name"
                        value={eventName}
                        onChange={(e) => setEventName(e.target.value)}
                    />
                    <input type="text" placeholder="data" value={data} onChange={(e) => setData(e.target.value)} />
                    <button>Send</button>
                </form>
            </div>

            <div>
                <h2>SSE Event Messages</h2>
                <div>
                    {eventMessages.map((eventMessage, index) => (
                        <ul key={index}>
                            <li>event name : {eventMessage.eventName}</li>
                            <li>data : {eventMessage.data}</li>
                        </ul>
                    ))}
                </div>
            </div>
        </main>
    );
}
