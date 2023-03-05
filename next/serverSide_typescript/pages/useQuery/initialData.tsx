import axios, { AxiosResponse } from 'axios';
import { GetServerSideProps } from 'next';
import { useQuery } from 'react-query';

export const getServerSideProps: GetServerSideProps = async (context) => {
    try {
        const res = await axios.get('http://localhost:8080/product/no');

        return {
            props: {
                res: res.data,
            },
        };
    } catch (error) {
        return {
            notFound: true,
        };
    }
};

interface Props {
    res: AxiosResponse<any, any>;
}

const InitialData = (props: Props) => {
    const queryProductNo = () => {
        const res = useQuery(
            'productNo',
            async () => {
                const res = await axios.get('http://localhost:8080/product/no');
                return res.data;
            },
            {
                initialData: props.res,
            },
        );

        if (res.isLoading) return <div>Loading...</div>;
        if (res.data) {
            const productNos: number[] = res.data as unknown as number[];
            return (
                <div>
                    {productNos.map((productNo) => (
                        <div key={productNo}>
                            <h2>데이터 Fetch로 가져온 상품번호 : {productNo}</h2>
                        </div>
                    ))}
                </div>
            );
        }
    };
    return <>{queryProductNo()}</>;
};

export default InitialData;
