import { render, screen } from '@testing-library/react';
import RootPage from './page';

describe('root page test', () => {
    test('API call test', async () => {
        render(<RootPage />);
        expect(await screen.findAllByTestId('name-list-item')).toHaveLength(4);
    });
});
