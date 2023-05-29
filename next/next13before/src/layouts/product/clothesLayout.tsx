import { ReactNode } from 'react';

interface Props {
    children: ReactNode;
}

const ProductClothesLayout = (props: Props) => {
    return (
        <div>
            <h2 style={{ color: 'skyblue' }}>Product Clothes Layout</h2>
            <div>{props.children}</div>
        </div>
    );
};

export default ProductClothesLayout;
