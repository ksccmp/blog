import type { Config } from 'jest';

import nextJest from 'next/jest';

const createJestConfig = nextJest({
    dir: './src', // jest가 동작되는 기본 경로 설정
});

const config: Config = {
    preset: 'ts-jest', // jest 설정에 기반이 되는 preset 등록
    coverageProvider: 'v8', // coverage 코드 추적을 위해 사용되는 provider 설정
    testEnvironment: 'jsdom', // test를 위해 사용되는 환경 등록 (web app 기반을 개발한 경우 jsdom 활용)
    setupFilesAfterEnv: ['<rootDir>/jest.setup.ts'], // jest.setup 환경 등록
    // module들을 다른 resource로 대체하여 사용되고자 할 때 설정
    moduleNameMapper: {
        '^@/(.*)$': '<rootDir>/src/$1', // jest에도 path alias가 적용되기 위해 설정 (tsconfig에 path alias 설정이 되어 있는 경우만 사용)
    },
};

export default createJestConfig(config);
