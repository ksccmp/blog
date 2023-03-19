import axios from 'axios';
import bodyParser from 'body-parser';
import { GetServerSideProps } from 'next';
import { useEffect } from 'react';
import { promisify } from 'util';

/**
 * getServerSideProps와 bodyParser을 이용하여 body 데이터 확인하기
 */
const getBody = promisify(bodyParser.urlencoded());

export const getServerSideProps: GetServerSideProps = async (context) => {
    await getBody(context.req, context.res);

    return {
        props: {
            body: (context.req as any)?.body,
        },
    };
};

/**
 * apple로부터 전달받은 body를 이용하여 api서버와 통신 후 로그인 처리하기
 */
interface AppleLogin {
    code: string;
}

interface Props {
    body: any;
}

const Login = (props: Props) => {
    /**
     * useEffect
     */
    useEffect(() => {
        if (props.body) {
            console.log(props.body);
            login(props.body.code);
        }
    }, [props.body]);

    /**
     * login
     */
    const login = async (code: string) => {
        const appleLogin: AppleLogin = {
            code,
        };

        const res = await axios.post('/api/apple/login', appleLogin);
        if (res.data) {
            console.log(res.data);
        }
    };

    return <></>;
};

export default Login;
