import { render, screen } from '@testing-library/react';

describe('getByText test', () => {
    test('default test', () => {
        render(
            <div>
                <h2>my text</h2>
            </div>,
        );

        expect(screen.getByText('my text')).toBeInTheDocument();
    });
});
