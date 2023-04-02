import axios from 'axios';
import { useRouter } from 'next/router';
import { useEffect } from 'react';

interface NaverLogin {
    code: string;
}

const Login = () => {
    /**
     * router
     */
    const router = useRouter();

    /**
     * useEffect
     */
    useEffect(() => {
        if (router.isReady) {
            const code = router.query.code as string; // 네이버에서 query문자열로 넘겨준 로그인 code값 추출
            console.log(`code= ${code}`);
            login(code);
        }
    }, [router.isReady]);

    /**
     * login
     */
    const login = async (code: string) => {
        const naverLogin: NaverLogin = {
            code,
        };

        const res = await axios.post('http://localhost:8080/api/naver/login', naverLogin); // 스프링 API서버에 code값을 담아 로그인 요청
        if (res.data) {
            console.log(res.data);
        }
    };

    return <></>;
};

export default Login;
