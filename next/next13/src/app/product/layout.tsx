import { ReactNode } from 'react';

interface Props {
    children: ReactNode;
}

const ProductLayout = (props: Props) => {
    return (
        <div>
            <h2>Product Layout</h2>
            <div>{props.children}</div>
        </div>
    );
};

export default ProductLayout;
