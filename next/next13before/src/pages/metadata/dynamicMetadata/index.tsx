import { GetServerSideProps } from 'next';
import MetadataDynamicLayout from '../../../layouts/metadata/dynamicLayout';

interface Product {
    no: number;
    name: string;
    description: string;
    price: number;
}

export const getServerSideProps: GetServerSideProps = async (context) => {
    const res = await fetch(`http://localhost:8080/getProduct?no=${context.query.no}`);
    const product: Product = await res.json();

    return {
        props: {
            product,
        },
    };
};

interface Props {
    product: Product;
}

const MetadataDynamicMetadata = (props: Props) => {
    return (
        <MetadataDynamicLayout title={props.product.name} description={props.product.description}>
            <div>
                <h2>Metadata DynamicMetadata Page</h2>
            </div>
        </MetadataDynamicLayout>
    );
};

export default MetadataDynamicMetadata;
