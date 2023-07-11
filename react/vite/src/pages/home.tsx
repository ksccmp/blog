import axios from 'axios';
import { useEffect } from 'react';

const Home = () => {
    const getData = async () => {
        const res = await axios.get('/api/getData'); // proxy를 이용하여 api 호출
        console.log(res.data);
    };

    useEffect(() => {
        getData();
    }, []);

    return (
        <div>
            <h2>Home Page</h2>
        </div>
    );
};

export default Home;
