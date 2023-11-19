/* eslint-disable prettier/prettier */
import { useState } from 'react'; // statements (1/1), lines (1/1)
import { decrease, increaseValue, multiplyValue } from './app.module'; // statements (1/1), lines (1/1)

export default function App() { // statements (1/1), functions (1/1), lines (1/1)
    const [value, setValue] = useState<number>(0); // statements (1/1), lines (1/1)

    const handleIncrease = () => { // statements (1/1), functions (1/1), lines (1/1)
        setValue(increaseValue(value)); // statements (1/1), lines (1/1)
    };

    const handleDecrease = () => { // statements (1/1), functions (1/1), lines (1/1)
        setValue(decrease().decreaseValue(value)); // statements (1/1), lines (1/1)
    };

    return ( // statements (1/1), lines (1/1)
        <main>
            {value > 3 ? ( // branches (1/1)
                <h2 data-testid="value-greater-three-text">
                    value가 3보다 크네요?, value끼리 곱한 값은 {multiplyValue(value)}
                </h2>
            ) : ( // branches (1/1)
                <h2 data-testid="value-lower-three-text">
                    value가 3보다 작거나 같네요?, value끼리 곱한 값은 {multiplyValue(value)}
                </h2>
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
