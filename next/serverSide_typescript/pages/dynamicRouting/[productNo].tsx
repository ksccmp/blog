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
                        // 페이지가 구성되기 위해 사용될 데이터를 params로 저장 (getStaticProps에서 가져와 사용)
                        // /dynamicRouting/1, /dynamicRouting/2 → params: [{ params: { productNo: '1' }}, { params: { productNo: '2' }}]
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
        const productNo = Number(context.params.productNo); // getStaticPaths에서 전달한 params를 이용하여 data fetching
        const [res] = await Promise.all([
            await axios.get('http://localhost:8080/product/detail', {
                params: {
                    productNo,
                },
            }),
            // 강제 timeout
            new Promise((resolve) => setTimeout(resolve, 10000)),
        ]);

        const product: Product = res.data;
        if (product) {
            return {
                props: {
                    product,
                },
            };
        }
    }

    return {
        notFound: true,
    };
};

interface Props {
    product: Product;
}

const DynamicRouting = (props: Props) => {
    return (
        <div>
            <h2>데이터 Fetch로 가져온 상품</h2>
            <p>상품이름: {props.product?.name}</p>
            <p>가격: {props.product?.price}</p>
            <p>재고: {props.product?.stock}</p>
        </div>
    );
};

export default DynamicRouting;
