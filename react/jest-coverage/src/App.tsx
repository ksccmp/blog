import { useState } from 'react';
import { decreaseValue, increaseValue } from './app.module';
import './except/except.module';

export default function App() {
    const [value, setValue] = useState<number>(0);

    const handleIncrease = () => {
        setValue(increaseValue(value));
    };

    const handleDecrease = () => {
        setValue(decreaseValue(value));
    };

    return (
        <main>
            {value > 3 ? (
                <h2 data-testid="value-greater-three-text">value가 3보다 크네요?, {value}</h2>
            ) : (
                <h2 data-testid="value-lower-three-text">value가 3보다 작거나 같네요?, {value}</h2>
            )}

            <button data-testid="increase-button" onClick={handleIncrease}>
                증가
            </button>

            <button data-testid="decrease-button" onClick={handleDecrease}>
                감소
            </button>
        </main>
    );
}
