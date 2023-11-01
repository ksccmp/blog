import { fireEvent, render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import Change from './change';

describe('change test', () => {
    test('fireEvent test', () => {
        render(<Change />);

        const first = 'first';
        fireEvent.change(screen.getByTestId('input'), {
            target: {
                value: first,
            },
        });

        const second = 'second';
        fireEvent.change(screen.getByTestId('input'), {
            target: {
                value: (screen.getByTestId('input') as HTMLInputElement).value.concat(second),
            },
        });

        expect(screen.getByTestId('data-text').textContent).toEqual(first.concat(second));
    });

    test('userEvent test', async () => {
        render(<Change />);

        const first = 'first';
        await userEvent.type(screen.getByTestId('input'), first);

        const second = 'second';
        await userEvent.type(screen.getByTestId('input'), second);

        expect(screen.getByTestId('data-text').textContent).toEqual(first.concat(second));
    });
});
