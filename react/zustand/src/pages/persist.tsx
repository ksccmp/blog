import React from 'react';
import useNumberPersistStore from '../modules/zustand/persist';

const Persist = () => {
    const { numberA, numberB, increaseNumberA, increaseNumberB } = useNumberPersistStore();

    return (
        <div>
            <h2>numberA : {numberA}</h2>
            <h2>numberB : {numberB}</h2>

            <button onClick={increaseNumberA}>A 증가</button>
            <button onClick={() => increaseNumberB(3)}>B 증가</button>
        </div>
    );
};

export default Persist;
