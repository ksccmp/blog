import { Noto_Sans_KR } from 'next/font/google'; // @next/font will be removed in next14
import { ReactNode } from 'react';

const notoSansKr = Noto_Sans_KR({
    weight: ['500'],
    subsets: ['latin'],
});

interface Props {
    children: ReactNode;
}

const FontGoogleLayout = (props: Props) => {
    return <div className={notoSansKr.className}>{props.children}</div>;
};

export default FontGoogleLayout;
