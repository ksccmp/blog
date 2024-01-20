import { useState } from 'react';
import { getAddNumber } from './util';

export default function Number() {
    const [number, setNumber] = useState<number>(1);

    const handleAddClick = () => {
        setNumber(getAddNumber(number));
    };

    return (
        <main>
            <h2>Mock Test</h2>
            <div>
                <p role="number-text">{number}</p>

                <button role="add-button" type="button" onClick={handleAddClick}>
                    add
                </button>
            </div>
        </main>
    );
}
