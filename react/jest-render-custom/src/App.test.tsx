import { screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import App from './App';
import customRender from './custom-render';

describe('app test', () => {
    test('recoil test', async () => {
        customRender(<App />); // customRender 사용으로 RecoilRoot wrapper 제거

        await userEvent.click(screen.getByRole('increase-button'));
        await userEvent.click(screen.getByRole('increase-button'));

        expect((await screen.findByRole('count-text')).textContent).toEqual('Count : 2');
    });
});
