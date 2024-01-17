import App from '@/App'; // 절대경로 사용 (path alias 적용)
import { render, screen } from '@testing-library/react';

describe('app test', () => {
    test('app page text check', async () => {
        render(<App />);
        expect(screen.getByRole('app-page-text').textContent).toEqual('App Page');
    });
});
