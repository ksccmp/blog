import { Metadata } from 'next';
import { ReactNode } from 'react';

// 따로 설정을 하지 않으면 상위 Layout에 설정한 metadata 적용
export const metadata: Metadata = {
    title: 'children title 테스트',
    description: 'children description 테스트',
    openGraph: {
        title: 'og children title 테스트',
        description: 'og children description 테스트',
        siteName: 'og children site name 테스트',
    },
};

interface Props {
    children: ReactNode;
}

const MetadataChildrenLayout = (props: Props) => {
    return <div>{props.children}</div>;
};

export default MetadataChildrenLayout;
