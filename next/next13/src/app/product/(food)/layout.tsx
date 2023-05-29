import { ReactNode } from 'react';

interface Props {
    children: ReactNode;
}

const ProductFoodLayout = (props: Props) => {
    return (
        <div>
            <h2 style={{ color: 'olive' }}>Product Food Layout</h2>
            <div>{props.children}</div>
        </div>
    );
};

export default ProductFoodLayout;
