import * as React from 'react';
import { AppProps } from 'next/app';
import Head from 'next/head';

const App = ({ Component, pageProps }: AppProps) => {
    return (
        <>
            <Head>
                <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
            </Head>

            <Component {...pageProps} />
        </>
    )
};

export default App;