import { render, screen } from '@testing-library/react';

describe('getByDisplayValue test', () => {
    test('default test', () => {
        render(
            <div>
                <input type="text" value="test-value" />
            </div>,
        );

        expect(screen.getByDisplayValue('test-value')).toBeInTheDocument();
    });
});
