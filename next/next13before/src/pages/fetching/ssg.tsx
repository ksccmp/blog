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
    };
};

interface Props {
    datas: number[];
}

const Ssg = (props: Props) => {
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

export default Ssg;
