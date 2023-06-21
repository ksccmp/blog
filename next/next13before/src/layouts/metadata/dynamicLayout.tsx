import Head from 'next/head';
import { ReactNode } from 'react';

interface Props {
    children: ReactNode;
    title: string;
    description: string;
}

const MetadataDynamicLayout = (props: Props) => {
    return (
        <>
            <Head>
                <title>{props.title}</title>
                <meta name="description" content={props.description} />

                <meta property="og:title" content={props.title} />
                <meta property="og:description" content={props.description} />
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
                <meta name="twitter:title" content={props.title} />
                <meta name="twitter:description" content={props.description} />
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

export default MetadataDynamicLayout;
