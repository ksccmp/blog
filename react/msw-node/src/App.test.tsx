import { render, screen } from '@testing-library/react';
import { rest } from 'msw';
import App from './App';
import { server } from './mocks/server';

describe('app test', () => {
    test('/get-names api msw mocking 처리 확인 테스트', async () => {
        render(<App />);

        const personNameTexts = await screen.findAllByTestId('person-name-text');
        expect(personNameTexts.length).toEqual(4);
    })

    test('/get-names api msw mocking 처리 확인 테스트 (override)', async () => {
        server.use(
            // GET method인 /get-names를 해당 페이지에서만 따로 활용
            rest.get('/get-names', (req, res, ctx) => {
              const names = ['override']
      
              return res(
                  ctx.status(200),
                  ctx.json(names),
              )
            })
          )

        render(<App />);

        const personNameTexts = await screen.findAllByTestId('person-name-text');
        expect(personNameTexts.length).toEqual(1);
    })
})