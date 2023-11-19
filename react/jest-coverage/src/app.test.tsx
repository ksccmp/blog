import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import App from './App';

describe('app test', () => {
    test('render test', () => {
        render(<App />);
    });

    test('increase button one time test', async () => {
        render(<App />);
        await userEvent.click(screen.getByTestId('increase-button'));
    });

    test('decrease button one time test', async () => {
        render(<App />);
        await userEvent.click(screen.getByTestId('decrease-button'));
    });

    test('increase button three time, decrease button one time test', async () => {
        render(<App />);
        await userEvent.click(screen.getByTestId('increase-button'));
        await userEvent.click(screen.getByTestId('increase-button'));
        await userEvent.click(screen.getByTestId('increase-button'));
        await userEvent.click(screen.getByTestId('increase-button'));

        await userEvent.click(screen.getByTestId('decrease-button'));
        await userEvent.click(screen.getByTestId('decrease-button'));
    });
});
