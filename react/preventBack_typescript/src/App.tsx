import React, { useEffect, useState } from 'react';

const App = () => {
    const [toggle, setToggle] = useState<boolean>(false);

    useEffect(() => {
        if (toggle) {
            history.pushState(null, '', ''); // 현재 페이지 history stack 한개 더 쌓기
            window.onpopstate = () => {
                // 뒤로가기가 실행될 경우 추가 action 등록
                alert('뒤로가기를 막고 alert를 띄워봅니다.');
            };
        } else {
            window.onpopstate = () => {
                // 초기화
            };
        }
    }, [toggle]);

    const clickButton = () => {
        setToggle(!toggle);
    };

    return (
        <div>
            <h2>Toggle: {String(toggle)}</h2>
            <button onClick={clickButton}>Prevent Toggle</button>
        </div>
    );
};

export default App;
