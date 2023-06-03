export const getStaticProps = async () => {
    const res = await fetch('http://localhost:8080/getData', {
        headers: {
            'Content-Type': 'application/json',
        },
    });
    const datas: number[] = await res.json();

    return {
        props: {
            datas,
        },
        revalidate: 10, // 데이터 유효 시간 10초
    };
};

interface Props {
    datas: number[];
}

const Isr = (props: Props) => {
    return (
        <div>
            {props.datas.map((data, index) => (
                <div key={data}>
                    <p>
                        {index + 1}번째 값은 {data}입니다.
                    </p>
                </div>
            ))}
        </div>
    );
};

export default Isr;
