import Head from 'next/head';

const FontGoogle = () => {
    return (
        <>
            <Head>
                <style>
                    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap');
                </style>
            </Head>

            <div style={{ fontFamily: `'Noto Sans KR', sans-serif` }}>
                <h2>Font Google Page</h2>
            </div>
        </>
    );
};

export default FontGoogle;
