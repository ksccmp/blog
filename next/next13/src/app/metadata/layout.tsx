import { Metadata } from 'next';
import { ReactNode } from 'react';

export const metadata: Metadata = {
    title: 'title 테스트',
    description: 'description 테스트',
    openGraph: {
        title: 'og title 테스트',
        description: 'og description 테스트',
        url: 'https://jforj.tistory.com',
        siteName: 'og site name 테스트',
        images: [
            {
                url: 'https://blog.kakaocdn.net/dn/kT8fV/btskKl5skJt/XcqUQY5A7DDGcqU4iIY9P0/img.png',
                width: 800,
                height: 600,
            },
        ],
        type: 'website',
    },
    twitter: {
        card: 'summary',
        title: 'twitter title 테스트',
        description: 'twitter description 테스트',
        images: [
            {
                url: 'https://blog.kakaocdn.net/dn/kT8fV/btskKl5skJt/XcqUQY5A7DDGcqU4iIY9P0/img.png',
                width: 800,
                height: 600,
            },
        ],
    },
};

interface Props {
    children: ReactNode;
}

const MetadataLayout = (props: Props) => {
    return <div>{props.children}</div>;
};

export default MetadataLayout;
