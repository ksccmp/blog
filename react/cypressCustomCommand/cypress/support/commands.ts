/// <reference types="cypress" />

/**
 * cypress login command
 */
Cypress.Commands.add('login', () => {
    // 페이지를 /login으로 이동
    cy.visit('/login');

    // id-input dom 요소에 '입력한 아이디'값을 입력
    cy.get('[data-cy=id-input]').type('입력한 아이디');
    // password-input dom 요소에 '1234'값을 입력
    cy.get('[data-cy=password-input]').type('1234');

    // login-button dom 요소가 존재하는지 확인 후 클릭 이벤트 발생
    cy.get('[data-cy=login-button]').should('exist').click();
});

/**
 * cypress get text field input dom
 */
Cypress.Commands.add('getTextFieldInput', (dataCy: string) => {
    cy.get(`[data-cy=${dataCy}] > input`);
});
