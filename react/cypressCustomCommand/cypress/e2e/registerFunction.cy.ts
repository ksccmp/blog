import { getTextFieldInput, login } from '../support/commandFunction';

describe('상품 등록 테스트', () => {
    before(() => {
        // 로그인
        login();
    });

    it('상품 정보를 입력하기', () => {
        // 페이지를 /register로 이동
        cy.visit('/register');

        // 이름 입력
        cy.get('[data-cy=name-input]').type('테스트 상품명');
        // 가격 입력
        cy.get('[data-cy=price-input]').type('2000');
        // 텍스트 필드 입력
        getTextFieldInput('textField-container').type('텍스트 필드');
    });
});
