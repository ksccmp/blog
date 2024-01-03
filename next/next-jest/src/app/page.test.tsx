import RootPage from '@/app/page';
import { render, screen } from '@testing-library/react';

describe('root page test', () => {
    test('check title', () => {
        render(<RootPage />);
        expect(screen.getByTestId('root-page-title-text')).toBeInTheDocument();
    });
});
