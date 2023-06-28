import React from 'react';
import useNumberDevtoolsStore from '../modules/zustand/devtools';

const Devtools = () => {
    // 한번에 가져오는 경우
    const { numberA, numberB, increaseNumberA, increaseNumberB } = useNumberDevtoolsStore();

    return (
        <div>
            <h2>numberA : {numberA}</h2>
            <h2>numberB : {numberB}</h2>

            <button onClick={increaseNumberA}>A 증가</button>
            <button onClick={() => increaseNumberB(3)}>B 증가</button>
        </div>
    );
};

export default Devtools;
