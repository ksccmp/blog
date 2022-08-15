import { useRouter } from 'next/router';
import * as React from 'react';

const No = () => {
    const router = useRouter();

    React.useEffect(() => {
        if(router.isReady) {
            console.log(router.query);
        }
    }, [router.isReady])

    return (
        <div>
            <h2>/Board/:no 확인하는 페이지</h2>
        </div>
    )
}

export default No;