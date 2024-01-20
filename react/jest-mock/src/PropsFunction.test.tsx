import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import PropsFunction from './PropsFunction';

describe('props function test', () => {
    test('jest fn not use test', async () => {
        render(<PropsFunction />);
        await userEvent.click(screen.getByRole('check-props-function-button'));

        expect((await screen.findByRole('has-props-function-text')).textContent).toEqual('false');
    });

    test('jest fn use test', async () => {
        const onPropsFunction = jest.fn(); // onPropsFunction mock 함수 생성

        render(<PropsFunction onPropsFunction={onPropsFunction} />);
        await userEvent.click(screen.getByRole('check-props-function-button'));

        expect((await screen.findByRole('has-props-function-text')).textContent).toEqual('true');
    });
});
