import * as React from 'react';
import { NextPage } from 'next';
import Router from 'next/router';

const Index: NextPage = () => {

    React.useEffect(() => {
        Router.push('/image');
    })

    return (
        <div>Index</div>
    );
};

export default Index;