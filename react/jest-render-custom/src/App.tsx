import useAppStore from './use-app-store';

export default function App() {
    const { count, increase, decrease } = useAppStore();

    return (
        <main>
            <div>
                <h2 role="count-text">Count : {count}</h2>
            </div>

            <div>
                <button role="increase-button" type="button" onClick={increase}>
                    increase
                </button>
                <button role="decrease-button" type="button" onClick={decrease}>
                    decrease
                </button>
            </div>
        </main>
    );
}
