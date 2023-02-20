// /pages/isr/[productNo].tsx

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
                        // /isr/1, /isr/2 → params: [{ params: { productNo: '1' }}, { params: { productNo: '2' }}]
                        productNo: String(productNo),
                    },
                };
            }),
            fallback: 'blocking', // prerendering되지 않은 페이지가 호출되면 초기 렌더링이 되기전에 데이터를 fetching한 뒤 렌더링 진행
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
        ]);

        const product: Product = res.data;
        if (product) {
            return {
                props: {
                    productNo,
                    product,
                },
                // revalidate: 30, // On-demand Revalidation 처리를 위해 설정 제거
            };
        }
    }

    return {
        notFound: true,
    };
};

interface Props {
    productNo: number;
    product: Product;
}

const Isr = (props: Props) => {
    /**
     * handle
     */
    const handle = {
        clickRevalidation: async () => {
            await axios.get(`/api/product/detail/${props.productNo}`);
        },
    };

    return (
        <div>
            <h2>데이터 Fetch로 가져온 상품</h2>
            <p>상품이름: {props.product?.name}</p>
            <p>가격: {props.product?.price}</p>
            <p>재고: {props.product?.stock}</p>

            <button onClick={handle.clickRevalidation}>revalidation 트리거</button>
        </div>
    );
};

export default Isr;
