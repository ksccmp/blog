import React, { useState } from 'react';

const Component = () => {
    const [value] = useState<string>('내용');

    return (
        <div>
            <h2>이런 {value}들이 sourceMap에 보인다면?</h2>
        </div>
    );
};

export default Component;
