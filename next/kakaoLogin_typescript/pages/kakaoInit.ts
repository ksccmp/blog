export const kakaoInit = () => {
    const kakao = (window as any).Kakao;
    if(!kakao.isInitialized()) {
        kakao.init('5591227afe9cef648f3c2db76844523b');
    }

    return kakao;
}