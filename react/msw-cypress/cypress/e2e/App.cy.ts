import { rest } from "msw";

describe('app test', () => {
    it('/get-names api msw mocking 처리 확인 테스트 ', () => {
        cy.workerUse(
            // GET method인 /get-names를 해당 페이지에서만 따로 활용
            rest.get('/get-names', (req, res, ctx) => {
                const names = ['app-jimi', 'app-john', 'app-scott', 'app-queen']
            
                return res(
                    ctx.status(200),
                    ctx.json(names),
                )
            })
        )

        cy.visit('/');
        cy.get('[data-cy=person-name-text]').should('have.length', 4);
    });
});