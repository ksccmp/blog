import { useEffect, useState } from 'react';
import ProductFooter from '../../components/product/footer';
import ProductLoading from '../../components/product/loading';
import ProductLayout from '../../layouts/product/layout';

const Product = () => {
    const [data, setData] = useState<number[]>([]);
    const [isLoading, setIsLoading] = useState<boolean>(false);

    const getData = async () => {
        setIsLoading(true);

        const res = await fetch('http://localhost:8080/getData', {
            headers: {
                Accept: 'application/json',
            },
        });

        if (res) {
            setData(await res.json());
            setIsLoading(false);
        }
    };

    useEffect(() => {
        getData();
    }, []);

    return (
        <ProductLayout>
            {isLoading ? (
                <ProductLoading />
            ) : (
                <div>
                    <p>Next13 Before Product Page</p>
                    <ProductFooter />

                    <div>
                        {data.map((value) => {
                            return <span key={value}>{value}</span>;
                        })}
                    </div>
                </div>
            )}
        </ProductLayout>
    );
};

export default Product;
