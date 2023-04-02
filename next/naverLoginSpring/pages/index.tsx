import Head from 'next/head';

const Index = () => {
    /**
     * handle
     */
    const handle = {
        clickNaverLogin: () => {
            const clientId = '_3tRIBHGjSjo_rm44DWf'; // 앱 키 중 Client ID
            const redirectUri = 'http://localhost:8088/naver/login'; // 등록한 Callback URL

            location.href = `https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}`;
        },
    };

    return (
        <>
            <Head>
                <title>naver login</title>
            </Head>

            <div>
                <button onClick={handle.clickNaverLogin}>네이버 로그인</button>
            </div>
        </>
    );
};

export default Index;
