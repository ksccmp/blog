import axios from 'axios';
import { useEffect, useState } from 'react';

const Csr = () => {
    /**
     * useState
     */
    const [productNos, setProductNos] = useState<number[]>([]);

    /**
     * useEffect
     */
    useEffect(() => {
        getFetch();
    }, []);

    /**
     * getFetch
     */
    const getFetch = async () => {
        try {
            const res = await axios.get('http://localhost:8080/product/no');
            const productNos: number[] = res.data;

            setProductNos(productNos);
        } catch (error) {
            //
        }
    };
    return (
        <div>
            {productNos.map((productNo) => (
                <div>
                    <h2>데이터 Fetch로 가져온 상품번호 : {productNo}</h2>
                </div>
            ))}
        </div>
    );
};

export default Csr;
