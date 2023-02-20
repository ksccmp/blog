import axios from 'axios';
import { GetStaticProps } from 'next';

export const getStaticProps: GetStaticProps = async (context) => {
    try {
        const res = await axios.get('http://localhost:8080/product/no');
        const productNos: number[] = res.data;

        return {
            props: {
                productNos,
            },
            revalidate: 10,
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

const Ssg = (props: Props) => {
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

export default Ssg;
