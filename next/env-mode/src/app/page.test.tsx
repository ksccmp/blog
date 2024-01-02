import { render, screen } from '@testing-library/react';
import RootPage from './page';

describe('root page test', () => {
    test('check env mode', () => {
        render(<RootPage />);
        console.log(screen.getByTestId('mode-text').textContent);
        console.log(screen.getByTestId('node-env-text').textContent);
    });
});
