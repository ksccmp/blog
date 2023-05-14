import React, { useState } from 'react';
import TextField from '../components/molecules/textField';

const Register = () => {
    /**
     * useState
     */
    const [name, setName] = useState<string>('');
    const [price, setPrice] = useState<number>(0);

    return (
        <div>
            <input
                data-cy="name-input"
                type="text"
                placeholder="상품명을 입력해주세요."
                onChange={(e) => setName(e.target.value)}
            />

            <input
                data-cy="price-input"
                type="number"
                placeholder="가격을 입력해주세요."
                onChange={(e) => setPrice(Number(e.target.value))}
            />

            <TextField dataCy="textField-container" />
        </div>
    );
};

export default Register;
