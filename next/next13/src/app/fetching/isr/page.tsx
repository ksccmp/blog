const getData = async () => {
    const res = await fetch('http://localhost:8080/getData', {
        headers: {
            'Content-Type': 'application/json',
        },
        next: {
            revalidate: 10, // 데이터 유효 시간 10초
        },
    });
    return res.json();
};

const IsrPage = async () => {
    const datas: number[] = await getData();

    return (
        <div>
            {datas.map((data, index) => (
                <div key={data}>
                    <p>
                        {index + 1}번째 값은 {data}입니다.
                    </p>
                </div>
            ))}
        </div>
    );
};

export default IsrPage;
