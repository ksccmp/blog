import { render, screen } from '@testing-library/react';

describe('getByPlaceholderText test', () => {
    test('default test', () => {
        render(
            <div>
                <input type="text" placeholder="my-placeholder" />
            </div>,
        );

        expect(screen.getByPlaceholderText('my-placeholder')).toBeInTheDocument();
        expect(screen.getByPlaceholderText('my-placeholder').getAttribute('type')).toEqual('text');
    });
});
