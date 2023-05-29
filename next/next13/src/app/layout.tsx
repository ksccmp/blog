import { ReactNode } from 'react';

interface Props {
    children: ReactNode;
}

const RootLayout = (props: Props) => {
    return (
        <html lang="ko">
            <body>{props.children}</body>
        </html>
    );
};

export default RootLayout;
