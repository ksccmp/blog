import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import Number from './Number';
import * as util from './util'; // import의 경우 asterisk를 활용하여 전체 함수를 불러와야 spyOn 동작

// util 모듈에 담겨 있는 함수들을 mocking하여 재 정의
// jest.mock('./util', () => {
//     return {
//         getAddNumber:
//             // mock 함수로 변경
//             jest
//                 .fn()
//                 // mock 함수에 담기는 함수 기능 새롭게 정의
//                 .mockImplementation((number: number) => number + 3),
//     };
// });

describe('number test', () => {
    // test('jest mock not use test', async () => {
    //     render(<Number />);
    //     await userEvent.click(screen.getByRole('add-button'));

    //     expect((await screen.findByRole('number-text')).textContent).toEqual('3');
    // });

    // test('jest mock use test', async () => {
    //     render(<Number />);
    //     await userEvent.click(screen.getByRole('add-button'));

    //     expect((await screen.findByRole('number-text')).textContent).toEqual('4');
    // });

    // test('jest spy use test', async () => {
    //     const getAddNumberSpy = jest.spyOn(util, 'getAddNumber'); // util 모듈에 있는 getAddNumber 함수 실행 추적

    //     render(<Number />);
    //     await userEvent.click(screen.getByRole('add-button'));
    //     await userEvent.click(screen.getByRole('add-button'));

    //     await waitFor(() => {
    //         expect(getAddNumberSpy).toHaveBeenCalled(); // 1번 이상 호출되었는지 확인
    //         expect(getAddNumberSpy).toHaveBeenCalledTimes(2); // 총 2번 호출되었는지 확인
    //     });
    // });

    test('jest spy mocking test', async () => {
        // util 모듈에 있는 getAddNumber 함수 실행 추적하며 mock 함수 생성
        jest.spyOn(util, 'getAddNumber')
            // mock 함수에 담기는 함수 기능 새롭게 정의
            .mockImplementation((number: number) => number + 3);

        render(<Number />);
        await userEvent.click(screen.getByRole('add-button'));

        expect((await screen.findByRole('number-text')).textContent).toEqual('4');
    });
});
