import React from 'react';
import useNumberOverwriteStore from '../modules/zustand/overwrite';

const Overwrite = () => {
    const { numberA, numberB, clear, deleteNumberB } = useNumberOverwriteStore();

    return (
        <div>
            <h2>numberA : {numberA}</h2>
            <h2>numberB : {numberB}</h2>

            <button onClick={clear}>초기화</button>
            <button onClick={deleteNumberB}>B 삭제</button>
        </div>
    );
};

export default Overwrite;
