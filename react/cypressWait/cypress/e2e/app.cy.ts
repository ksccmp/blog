describe('API 호출하기', () => {
    it('getData를 호출하여 데이터 검증하기', () => {
        // 페이지를 /로 이동
        cy.visit('/');

        // 5초 동안 기다리기
        // cy.wait(5000);

        // /getData api intercept alias 처리하기
        cy.intercept({
            method: 'get',
            url: '/getData',
        }).as('getData');
        // /getData api 요청이 완료될때까지 기다리기
        cy.wait('@getData');

        // name dom 요소의 갯수가 4개인지 검증
        cy.get('[data-cy=name]').should('have.length', 4);
        // name dom 마지막 요소의 텍스트가 third인지 검증
        cy.get('[data-cy=name]').last().should('have.text', 'name : third');
        // value dom 마지막 요소의 텍스트가 3인지 검증
        cy.get('[data-cy=value]').last().should('have.text', 'value : 3');
    });
});
