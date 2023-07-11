import react from '@vitejs/plugin-react-swc';
import path from 'path';
import { defineConfig, splitVendorChunkPlugin } from 'vite';

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        react(),
        splitVendorChunkPlugin(), // vendor code spliting 설정 (vendor는 공통적으로 사용되는 모듈들을 의미)
    ],

    // console 제거 설정
    build: {
        minify: 'terser',
        terserOptions: {
            compress: {
                drop_console: true,
                drop_debugger: true,
            },
        },
    },

    // proxy 설정
    server: {
        proxy: {
            // /api/getData → http://localhost:8080/getData로 변경
            '/api': {
                target: 'http://localhost:8080', // fetch 요청에 대한 target 경로 설정
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, ''), // /api에 해당하는 경로를 삭제
            },
        },
    },

    // 경로 alias 설정
    resolve: {
        // /src경로를 @로 alias 처리
        alias: [{ find: '@', replacement: path.resolve(__dirname, 'src') }],
    },
});
