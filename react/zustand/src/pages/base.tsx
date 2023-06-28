import React from 'react';
import useNumberBaseStore from '../modules/zustand/base';

const Base = () => {
    // 한번에 가져오는 경우
    const { numberA, numberB, increaseNumberA, increaseNumberB } = useNumberBaseStore();

    // 하나씩 가져오는 경우
    // const numberA = useNumberBaseStore((state) => state.numberA);
    // const numberB = useNumberBaseStore((state) => state.numberB);
    // const increaseNumberA = useNumberBaseStore((state) => state.increaseNumberA);
    // const increaseNumberB = useNumberBaseStore((state) => state.increaseNumberB);

    return (
        <div>
            <h2>numberA : {numberA}</h2>
            <h2>numberB : {numberB}</h2>

            <button onClick={increaseNumberA}>A 증가</button>
            <button onClick={() => increaseNumberB(3)}>B 증가</button>
        </div>
    );
};

export default Base;
