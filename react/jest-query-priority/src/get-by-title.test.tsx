import { render, screen } from '@testing-library/react';

describe('getByTitle test', () => {
    test('default test', () => {
        render(
            <div>
                <h2 title="fruit">apple</h2>
            </div>,
        );

        expect(screen.getByTitle('fruit')).toBeInTheDocument();
    });
});
