import { render, screen } from '@testing-library/react';

describe('getByTestId test', () => {
    test('default test', () => {
        render(
            <div>
                <input data-testid="my-input" type="text" />
            </div>,
        );

        expect(screen.getByTestId('my-input')).toBeInTheDocument();
        expect(screen.getByTestId('my-input').getAttribute('type')).toEqual('text');
    });
});
