import React, { useEffect } from 'react';
import { useParams } from 'react-router';

const ParamPage = () => {
    const params = useParams();

    useEffect(() => {
        console.log(params);
    }, []);

    return (
        <div>
            <h2>ParamPage</h2>
        </div>
    );
};

export default ParamPage;
