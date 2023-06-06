import localFont from 'next/font/local';
import { ReactNode } from 'react';

const notoSansKr = localFont({
    src: [
        {
            path: './NotoSansKR-Medium.otf',
            weight: 'normal',
            style: 'normal',
        },
    ],
});

interface Props {
    children: ReactNode;
}

const FontLocalLayout = (props: Props) => {
    return <div className={notoSansKr.className}>{props.children}</div>;
};

export default FontLocalLayout;
