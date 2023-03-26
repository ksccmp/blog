import Head from 'next/head';

const Index = () => {
    /**
     * handle
     */
    const handle = {
        clickKakaoLogin: () => {
            const clientId = '77ec86776bd405c9dc07c04db6e697a8'; // 앱 키 중 JavaScript 키
            const redirectUri = 'http://localhost:8088/kakao/login'; // 등록한 Redirect URI

            location.href = `https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}`;
        },
    };

    return (
        <>
            <Head>
                <title>kakao login</title>
            </Head>

            <div>
                <button onClick={handle.clickKakaoLogin}>카카오 로그인</button>
            </div>
        </>
    );
};

export default Index;
