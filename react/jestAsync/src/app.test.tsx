import { render, screen, waitFor } from '@testing-library/react';
import App from './App';

describe('app test', () => {
    test('getPersons api 호출 테스트 (none)', () => {
        render(<App />);

        const personNameTexts = screen.getAllByTestId('person-name-text');
        expect(personNameTexts.length).toEqual(4);
    })

    test('getPersons api 호출 테스트 (setTimeout)', () => {
        render(<App />);

        setTimeout(() => {
            const personNameTexts = screen.getAllByTestId('person-name-text');
            expect(personNameTexts.length).toEqual(4);
        }, 2000)
    })

    test('getPersons api 호출 테스트 (waitFor)', async () => {
        render(<App />);

        await waitFor(() => expect(screen.getAllByTestId('person-name-text')[0]).toBeInTheDocument());

        const personNameTexts = screen.getAllByTestId('person-name-text');
        expect(personNameTexts.length).toEqual(4);
    })

    test('getPersons api 호출 테스트 (find)', async () => {
        render(<App />);

        const personNameTexts = await screen.findAllByTestId('person-name-text');
        expect(personNameTexts.length).toEqual(4);
    })
})