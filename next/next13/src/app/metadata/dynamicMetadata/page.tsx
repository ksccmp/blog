import { ResolvingMetadata } from 'next';

interface Product {
    no: number;
    name: string;
    description: string;
    price: number;
}

interface Props {
    params: { no: string };
    searchParams: { [key: string]: string | string[] | undefined };
}

// generateMetadata를 사용할 경우 metadata는 적용되지 않음
// searchParams를 활용할 경우 layout말고 page에서만 사용
export const generateMetadata = async (props: Props, parent: ResolvingMetadata) => {
    const res = await fetch(`http://localhost:8080/getProduct?no=${props.searchParams.no}`);
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

const MetadataDynamicMetadataPage = () => {
    return (
        <div>
            <h2>Metadata DynamicMetadata Page</h2>
        </div>
    );
};

export default MetadataDynamicMetadataPage;
