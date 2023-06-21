import { Metadata } from 'next';
import { ReactNode } from 'react';

// API Routes를 활용하여 OG Image Generation 적용
export const metadata: Metadata = {
    openGraph: {
        images: [
            {
                url: '/api/og',
                width: 300,
                height: 150,
            },
        ],
    },
};

interface Props {
    children: ReactNode;
}

const MetadataOgImageLayout = (props: Props) => {
    return <div>{props.children}</div>;
};

export default MetadataOgImageLayout;
