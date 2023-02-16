import axios from 'axios';
import { GetServerSideProps } from 'next';

export const getServerSideProps: GetServerSideProps = async (context) => {
    try {
        const res = await axios.get('http://localhost:8080/product/no');
        const productNos: number[] = res.data;

        // query → context.query.productNo
        // pathname → context.resolvedUrl
        // cache → context.res.setHeader('Cache-Control', 'public, s-maxage=10, stale-while-revalidate=59');

        return {
            props: {
                productNos,
            },
        };
    } catch (error) {
        return {
            notFound: true,
        };
    }
};

interface Props {
    productNos: number[];
}

const Ssr = (props: Props) => {
    return (
        <div>
            {props.productNos.map((productNo) => (
                <div>
                    <h2>데이터 Fetch로 가져온 상품번호 : {productNo}</h2>
                </div>
            ))}
        </div>
    );
};

export default Ssr;
