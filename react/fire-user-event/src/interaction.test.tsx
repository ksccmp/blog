import { fireEvent, render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import Interaction from './interaction';

describe('interaction test', () => {
    test('fireEvent test', async () => {
        render(<Interaction />);

        fireEvent.click(screen.getByTestId('button'));
        expect(await screen.findByTestId('click-text')).toBeInTheDocument();

        fireEvent.mouseOver(screen.getByTestId('button'));
        expect(await screen.findByTestId('hover-text')).toBeInTheDocument();
    });

    test('userEvent test', async () => {
        render(<Interaction />);
        userEvent.click(screen.getByTestId('button'));

        expect(await screen.findByTestId('click-text')).toBeInTheDocument();
        expect(await screen.findByTestId('hover-text')).toBeInTheDocument();
    });
});
