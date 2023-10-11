import '@testing-library/jest-dom';
import { server } from './src/mocks/server';

// 테스트를 시작하기 전 처리 서버 설정
beforeAll(() => server.listen())

// 테스트가 끝날 때 마다 handler reset 처리 (다른 테스트에 영향을 주지 않기 위해)
afterEach(() => server.resetHandlers())

// 테스트가 모두 종료되면 서버 종료
afterAll(() => server.close())