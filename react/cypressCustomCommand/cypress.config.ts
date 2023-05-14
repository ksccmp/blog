import { defineConfig } from 'cypress';

export default defineConfig({
    e2e: {
        baseUrl: 'http://localhost:8088', // baseUrl 설정
        setupNodeEvents(on, config) {
            // implement node event listeners here
        },
    },
});
