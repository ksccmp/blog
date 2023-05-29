import ProductFooter from './footer';

const getData = async () => {
    const res = await fetch('http://localhost:8080/getData', {
        headers: {
            Accept: 'application/json',
        },
    });

    return res.json();
};

const ProductPage = async () => {
    const data: number[] = await getData();

    return (
        <div>
            <p>Next13 Product Page</p>
            <ProductFooter />

            <div>
                {data.map((value) => {
                    return <span key={value}>{value}</span>;
                })}
            </div>
        </div>
    );
};

export default ProductPage;
