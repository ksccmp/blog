import { useState } from 'react';

export default function Interaction() {
    const [isClick, setIsClick] = useState<boolean>(false);
    const [isHover, setIsHover] = useState<boolean>(false);

    return (
        <main>
            <button data-testid="button" onClick={() => setIsClick(!isClick)} onMouseOver={() => setIsHover(!isHover)}>
                button
            </button>

            {isClick && <h2 data-testid="click-text">Click !</h2>}
            {isHover && <h2 data-testid="hover-text">Hover !</h2>}
        </main>
    );
}
