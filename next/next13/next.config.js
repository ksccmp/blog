/** @type {import('next').NextConfig} */
const nextConfig = {
    experimental: {
        appDir: true, // appDir 사용 필수
        typedRoutes: true, // 정적 타입 Link 적용
    },
};

module.exports = nextConfig;
