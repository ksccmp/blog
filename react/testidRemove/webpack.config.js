/* eslint-disable @typescript-eslint/no-var-requires */
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    // 개발모드, development or production
    mode: 'development',

    // entry를 기준으로 연관된 모든 파일들을 번들링
    entry: './src/index',

    // 번들링 될 파일 확장자 등록
    resolve: {
        extensions: ['.js', '.jsx', '.ts', '.tsx'],
    },

    // 로더 등록
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: ['ts-loader', 'babel-loader'], // ts-loader를 사용하는 경우 ts-loader보다 우측에 babel-loader 설정
                exclude: ['/node_modules/'],
            },
        ],
    },

    // 빌드 설정
    output: {
        path: path.resolve(__dirname, 'build'), // 빌드되는 파일들이 만들어지는 위치, __dirname: 현재 디렉토리
        filename: 'bundle.js', // 번들파일 이름
    },

    // webpack 서버 설정
    devServer: {
        static: path.join(__dirname, 'build'), // 이 경로에 있는 파일이 변경될 때 번들을 다시 컴파일
        port: 8088,
    },

    plugins: [
        new HtmlWebpackPlugin({
            // index.html에 output에서 만들어진 bundle.js를 적용하여, build에 새로운 html 파일 생성
            template: `./public/index.html`,
        }),
    ],
};
