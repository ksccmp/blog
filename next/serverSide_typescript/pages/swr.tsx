import axios from 'axios';
import swr from 'swr';

const Swr = () => {
    /**
     * getFetch
     */
    const getFetch = () => {
        try {
            const res = swr('http://localhost:8080/product/no', (url) => axios.get(url).then((res) => res.data));

            if (res.isLoading) return <div>Loading...</div>;
            if (res.error) return <div>Error</div>;
            if (res.data) {
                const productNos: number[] = res.data;
                return (
                    <div>
                        {productNos.map((productNo) => (
                            <div>
                                <h2>데이터 Fetch로 가져온 상품번호 : {productNo}</h2>
                            </div>
                        ))}
                    </div>
                );
            }
        } catch (error) {
            //
        }
    };

    return <div>{getFetch()}</div>;
};

export default Swr;
