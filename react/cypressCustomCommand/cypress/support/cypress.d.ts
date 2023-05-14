declare namespace Cypress {
    interface Chainable {
        login(): Chainable<JQuery<HTMLElement>>;
        getTextFieldInput(dataCy: string): Chainable<JQuery<HTMLElement>>;
    }
}
