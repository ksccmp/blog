import React from 'react';
import useNumberShallowStore from '../modules/zustand/shallow';

const ShallowChildren = () => {
    const numberC = useNumberShallowStore((state) => state.numberC);
    const increaseNumberC = useNumberShallowStore((state) => state.increaseNumberC);

    return (
        <div>
            <h2>numberC : {numberC}</h2>
            <button onClick={increaseNumberC}>C 증가</button>
        </div>
    );
};

export default ShallowChildren;
