import Head from 'next/head';

const Index = () => {
    /**
     * handle
     */
    const handle = {
        clickAppleLogin: () => {
            const client_id = 'org.nextjs.jforj'; // Service IDs 생성할 때 등록한 identifer
            const redirect_uri = 'https://jforj.store/apple/login'; // Service IDs 생성할 때 등록한 Return URLs

            // response_type (required) → 응답 유형을 선택, "code" or "code id_token"
            // response_mode (required) → 응답 모드를 선택, "query" or "fragment" or "form_post"
            // scope → 로그인을 통해 확인하고 싶은 정보를 선택, "email" or "name" or "email name" (scope를 사용할 경우 response_mode는 form_post가 필수)
            location.href = `https://appleid.apple.com/auth/authorize?response_type=code&response_mode=form_post&scope=email&client_id=${client_id}&redirect_uri=${redirect_uri}`;
        },
    };

    return (
        <>
            <Head>
                <title>apple login</title>
            </Head>

            <div>
                <button onClick={handle.clickAppleLogin}>애플 로그인</button>
            </div>
        </>
    );
};

export default Index;
