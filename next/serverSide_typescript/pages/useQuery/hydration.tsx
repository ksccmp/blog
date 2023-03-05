import axios from 'axios';
import { GetServerSideProps } from 'next';
import { dehydrate, QueryClient, useQuery } from 'react-query';

export const getServerSideProps: GetServerSideProps = async (context) => {
    const queryClient = new QueryClient();

    try {
        // prefetchQuery에 await 필수
        await queryClient.prefetchQuery('productNo', async () => {
            const res = await axios.get('http://localhost:8080/product/no');
            return res.data;
        });

        return {
            props: {
                dehydratedState: dehydrate(queryClient),
            },
        };
    } catch (error) {
        return {
            notFound: true,
        };
    }
};

const Hydration = () => {
    const queryProductNo = () => {
        const res = useQuery('productNo', async () => {
            const res = await axios.get('http://localhost:8080/product/no');
            return res.data;
        });

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

export default Hydration;
