import { ResolvingMetadata } from 'next';
import { ReactNode } from 'react';

interface Product {
    no: number;
    name: string;
    description: string;
    price: number;
}

interface Props {
    params: { no: string };
    searchParams: { [key: string]: string | string[] | undefined };
    children: ReactNode;
}

// generateMetadata를 사용할 경우 metadata는 적용되지 않음
// params를 활용할 경우 layout과 page 둘다 사용 가능
export const generateMetadata = async (props: Props, parent: ResolvingMetadata) => {
    const res = await fetch(`http://localhost:8080/getProduct?no=${props.params.no}`);
    const product: Product = await res.json();

    return {
        title: product.name,
        description: product.description,
        openGraph: {
            ...(await parent).openGraph,
            title: product.name,
            description: product.description,
        },
        twitter: {
            ...(await parent).twitter,
            title: product.name,
            description: product.description,
        },
    };
};

const MetadataDynamicMetadataNoLayout = (props: Props) => {
    return <div>{props.children}</div>;
};

export default MetadataDynamicMetadataNoLayout;
