import axios from 'axios';
import { GetStaticProps } from 'next';

interface Product {
    name: string;
    price: number;
    stock: number;
}

export const getStaticPaths = async () => {
    try {
        const res = await axios.get('http://localhost:8080/product/no');
        const productNos: number[] = res.data;

        return {
            paths: productNos.map((productNo) => {
                return {
                    params: {
                        productNo: String(productNo),
                    },
                };
            }),
            fallback: 'blocking',
        };
    } catch (error) {
        return {
            paths: [],
            fallback: false,
        };
    }
};

export const getStaticProps: GetStaticProps = async (context) => {
    if (context.params) {
        const productNo = Number(context.params.productNo);
        const res = await axios.get('http://localhost:8080/product/detail', {
            params: {
                productNo,
            },
        });

        const product: Product = res.data;
        if (product) {
            return {
                props: {
                    product,
                },
                revalidate: 5,
            };
        }
    }

    return {
        notFound: true,
        revalidate: 5,
    };
};

interface Props {
    product: Product;
}

const Isr = (props: Props) => {
    return (
        <div>
            <h2>데이터 Fetch로 가져온 상품</h2>
            <p>상품이름: {props.product?.name}</p>
            <p>가격: {props.product?.price}</p>
            <p>재고: {props.product?.stock}</p>
        </div>
    );
};

export default Isr;
