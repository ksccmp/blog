import { defineConfig } from "cypress";

export default defineConfig({
  e2e: {
    baseUrl: 'http://localhost:5173', // mockServiceWorker 사용을 위한 서버 실행 경로 baseUrl 설정
  },
});
