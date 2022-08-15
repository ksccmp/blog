import * as React from 'react';
import { NextPage } from 'next';

const Index: NextPage = () => {
    return (
        <>
            <div>
                <h2>Index Page</h2>
                <p>.env 데이터: {process.env.NEXT_PUBLIC_ENV_DATA}</p>
                <p>next.config.js 데이터: {process.env.ENV_DATA}</p>
            </div>
        </>
    );
};

export default Index;