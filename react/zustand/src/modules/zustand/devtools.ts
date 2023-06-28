import { create } from 'zustand';
import { devtools } from 'zustand/middleware';

interface UseNumberDevtoolsStore {
    numberA: number;
    numberB: number;
    increaseNumberA: () => void;
    increaseNumberB: (value: number) => void;
}

const useNumberDevtoolsStore = create<UseNumberDevtoolsStore>()(
    devtools((set, get) => ({
        numberA: 0, // store state
        numberB: 0, // store state
        // numberA 증가 함수
        increaseNumberA: () =>
            set((state) => ({
                numberA: state.numberA + 1, // state를 이용하여 state 값 변경
            })),
        // numberB 증가 함수
        increaseNumberB: (value: number) =>
            set({
                numberB: get().numberB + value, // get을 이용하여 state 값 변경
            }),
    })),
);

export default useNumberDevtoolsStore;
