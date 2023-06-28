import React from 'react';
import { shallow } from 'zustand/shallow';
import ShallowChildren from '../components/shallowChildren';
import useNumberShallowStore from '../modules/zustand/shallow';

const Shallow = () => {
    // multiple state-picks 방식으로 store 사용 (shallow 적용)
    const { numberA, numberB } = useNumberShallowStore(
        (state) => ({
            numberA: state.numberA,
            numberB: state.numberB,
        }),
        shallow,
    );
    // atomic state 방식으로 store 사용
    // const numberA = useNumberShallowStore((state) => state.numberA);
    // const numberB = useNumberShallowStore((state) => state.numberB);
    const increaseNumberA = useNumberShallowStore((state) => state.increaseNumberA);

    return (
        <div>
            <h2>numberA : {numberA}</h2>
            <h2>numberB : {numberB}</h2>
            <button onClick={increaseNumberA}>A 증가</button>

            <ShallowChildren />
        </div>
    );
};

export default Shallow;
