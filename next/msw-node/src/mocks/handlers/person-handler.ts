import { rest } from 'msw';

export const personHandlers = [
    // GET method인 /get-names를 호출하면 다음과 같이 response가 되도록 mocking 정의
    rest.get('/get-names', (req, res, ctx) => {
        const names = ['jimi', 'john', 'scott', 'queen'];

        return res(ctx.status(200), ctx.json(names));
    }),
];
