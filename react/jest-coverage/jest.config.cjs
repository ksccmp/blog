/** @type {import('ts-jest').JestConfigWithTsJest} */
module.exports = {
    preset: 'ts-jest',
    testEnvironment: 'jest-environment-jsdom',
    setupFilesAfterEnv: ['<rootDir>/jest.setup.cjs'], // jest.setup을 이용하여 환경 설정
    transform: {
        // ts-jest를 이용하여 typescript 사용 환경 설정
        '^.+\\.(ts|tsx)$': [
            'ts-jest',
            {
                tsconfig: '<rootDir>/tsconfig.jest.json', // tsconfig.jest.json 사용 설정
            },
        ],
        // babel-jest를 이용하여 javascrit 사용 환경 설정 (cjs파일에서 import 활용 등)
        '^.+\\.(js|cjs|jsx)$': 'babel-jest',
    },

    // coverage 수집을 위한 범위 설정 (default undefined, 테스트로 실행된 소스 코드에서만 수집이 이루어짐)
    collectCoverageFrom: [
        'src/**/*.{ts,tsx}', // src하위에 있는 모든 ts, tsx 파일들 수집 (테스트 파일은 수집되지 않음)
        // '!src/except/**/*', // src/except 하위에 있는 모든 파일들은 수집 제외
        // '!src/vite-env.d.ts', // src/vite-end.d.ts 파일은 수집 제외
        // '!src/main.tsx', // src/main.tsx 파일은 수집 제외
    ],

    // coverage reporter 파일 directory 설정 (default undefined, <rootDir>/coverage에 coverage reporter 파일을 저장)
    coverageDirectory: '<rootDir>/custom-coverage',

    // coverage 수집 제외 범위 설정 (default ["/node_modules/"])
    coveragePathIgnorePatterns: [
        'src/except/', // src/except 하위에 있는 모든 파일들은 수집 제외
        'src/vite-env.d.ts', // src/vite-end.d.ts 파일은 수집 제외
        'src/main.tsx', // src/main.tsx 파일은 수집 제외
    ],

    // coverage reporter 종류 설정 (default ["clover", "json", "lcov", "text"])
    coverageReporters: ['lcov', 'text'],

    // coverage 비율 한계점 설정 (default undefined)
    coverageThreshold: {
        // 전역 설정
        global: {
            statements: 80, // 구문 실행 비율
            branches: 80, // if-else 등 분기 처리 비율
            functions: 80, // 함수 실행 비율
            lines: 80, // 코드 라인 실행 비율
        },

        // 특정 경로 설정
        'src/**/*.ts': {
            statements: 90, // 구문 실행 비율
            branches: 90, // if-else 등 분기 처리 비율
            functions: 90, // 함수 실행 비율
            lines: 90, // 코드 라인 실행 비율
        },
    },

    // coverage에 기본적으로 담지 않는 파일들도 coverage 대상에 추가되도록 설정 (ex, 테스트 파일)
    // forceCoverageMatch: ['**/*.test.{ts,tsx}'],
};
