import Head from 'next/head';
import { ReactNode } from 'react';

interface Props {
    children: ReactNode;
}

const MetadataLayout = (props: Props) => {
    return (
        <>
            <Head>
                <title>title 테스트</title>
                <meta name="description" content="description 테스트" />

                <meta property="og:title" content="og title 테스트" />
                <meta property="og:description" content="og description 테스트" />
                <meta property="og:url" content="https://jforj.tistory.com" />
                <meta property="og:site_name" content="og site name 테스트" />
                <meta
                    property="og:image"
                    content="https://blog.kakaocdn.net/dn/kT8fV/btskKl5skJt/XcqUQY5A7DDGcqU4iIY9P0/img.png"
                />
                <meta property="og:image:width" content="800" />
                <meta property="og:image:height" content="600" />
                <meta property="og:type" content="website" />

                <meta name="twitter:card" content="summary" />
                <meta name="twitter:title" content="twitter title 테스트" />
                <meta name="twitter:description" content="twitter description 테스트" />
                <meta
                    name="twitter:image"
                    content="https://blog.kakaocdn.net/dn/kT8fV/btskKl5skJt/XcqUQY5A7DDGcqU4iIY9P0/img.png"
                />
                <meta name="twitter:image:width" content="800" />
                <meta name="twitter:image:height" content="600" />
            </Head>

            {props.children}
        </>
    );
};

export default MetadataLayout;
