'use client'; // error 페이지에 필수

interface Props {
    error: Error;
    reset: () => void;
}

const ProductError = (props: Props) => {
    return (
        <div>
            <h1>상품 페이지에 에러가 발생했습니다.</h1>
            <button onClick={() => props.reset()}>ReTry</button>
        </div>
    );
};

export default ProductError;
