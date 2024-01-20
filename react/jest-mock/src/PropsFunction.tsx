import { useState } from 'react';

interface Props {
    onPropsFunction?: () => void;
}

export default function PropsFunction({ onPropsFunction }: Props) {
    const [hasPropsFunction, setHasPropsFunction] = useState<boolean>(false);

    const handleCheckPropsFunctionClick = () => {
        if (onPropsFunction) {
            setHasPropsFunction(true);
        }
    };

    return (
        <div>
            <h2>Mock Test</h2>
            <div>
                <p role="has-props-function-text">{String(hasPropsFunction)}</p>

                <button role="check-props-function-button" type="button" onClick={handleCheckPropsFunctionClick}>
                    check
                </button>
            </div>
        </div>
    );
}
