/// <reference types="cypress" />

import { RequestHandler } from 'msw';
import { worker } from '../../src/mocks/browser';

declare global {
    namespace Cypress {
        interface Chainable {
            workerUse(...handlers: RequestHandler[]): void
        }
    }
}

// 테스트를 시작하기 전 worker 동작
before(() => {
    worker.start();
})

// 테스트가 끝날 때 마다 handler reset 처리 (다른 테스트에 영향을 주지 않기 위해)
Cypress.on('test:before:run', () => {
    worker.resetHandlers()
})

// cypress command로 worker에 추가 handler를 등록하기 위해 custom command 등록
Cypress.Commands.add('workerUse', (...handlers: RequestHandler[]) => {
    worker.use(...handlers)
})