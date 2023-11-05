import { render, screen } from '@testing-library/react';
import Footer from './footer';
import Header from './header';

describe('app test', () => {
    test('render query test', () => {
        const headerUtil = render(<Header />);
        render(<Footer />);

        expect(headerUtil.getByTestId('header-text')).toBeInTheDocument();
        expect(headerUtil.getByTestId('footer-text')).toBeInTheDocument();
    });

    test('screen query test', () => {
        render(<Header />);
        render(<Footer />);

        expect(screen.getByTestId('header-text')).toBeInTheDocument();
        expect(screen.getByTestId('footer-text')).toBeInTheDocument();
    });
});
