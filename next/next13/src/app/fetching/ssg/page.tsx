const getData = async () => {
    const res = await fetch('http://localhost:8080/getData', {
        headers: {
            'Content-Type': 'application/json',
        },
        cache: 'force-cache', // or 미 입력
    });
    return res.json();
};

const SsgPage = async () => {
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

export default SsgPage;
