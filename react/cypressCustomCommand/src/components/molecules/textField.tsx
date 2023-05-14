import React from 'react';

interface Props {
    dataCy?: string;
}

const TextField = (props: Props) => {
    return (
        <div data-cy={props.dataCy}>
            <input type="text" />
        </div>
    );
};

export default TextField;
