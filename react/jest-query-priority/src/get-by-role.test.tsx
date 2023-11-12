import { render, screen } from '@testing-library/react';

describe('getByRole test', () => {
    test('default test', () => {
        render(
            <div>
                <button>button</button>
            </div>,
        );

        expect(screen.getByRole('button')).toBeInTheDocument();
    });

    test('name option use test', () => {
        render(
            <div>
                <button name="submit">submit</button>
                <button name="cancle">cancle</button>
            </div>,
        );

        expect(
            screen.getByRole('button', {
                name: 'submit',
            }),
        ).toBeInTheDocument();
        expect(
            screen.getByRole('button', {
                name: 'cancle',
            }),
        ).toBeInTheDocument();
    });

    test('custom role definition test', () => {
        render(<div role="wrapper"></div>);

        expect(screen.getByRole('wrapper')).toBeInTheDocument();
    });
});
