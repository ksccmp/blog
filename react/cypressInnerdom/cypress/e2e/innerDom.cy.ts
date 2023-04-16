describe('innerDom 테스트', () => {
    it('두번째 wrapper에 있는 첫번째 아이템 텍스트 확인하기', () => {
        // 페이지를 /로 이동
        cy.visit('/');

        // 두번째 wrapper의 첫번째 아이템 텍스트 검증 (X)
        // cy.get('[data-cy=title-wrapper2]').get('[data-cy=item]').first().should('have.text', '두번째 아이템1');

        // 두번째 wrapper의 첫번째 아이템 텍스트 검증 (O)
        // cy.get('[data-cy=title-wrapper2]').find('[data-cy=item]').first().should('have.text', '두번째 아이템1');

        // 두번째 wrapper의 첫번째 아이템 텍스트 검증 (O)
        cy.get('[data-cy=title-wrapper2]').within(($wrapper) => {
            cy.wrap($wrapper).get('[data-cy=item]').first().should('have.text', '두번째 아이템1');
        });
    });
});
