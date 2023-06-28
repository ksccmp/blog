import { create } from 'zustand';
import { createJSONStorage, persist } from 'zustand/middleware';

interface UseNumberPersistStore {
    numberA: number;
    numberB: number;
    increaseNumberA: () => void;
    increaseNumberB: (value: number) => void;
}

const useNumberPersistStore = create<UseNumberPersistStore>()(
    persist(
        (set, get) => ({
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
        }),
        {
            name: 'number-store', // 저장소 key값
            storage: createJSONStorage(() => localStorage), // 저장소
            version: 1.0, // version 정보
        },
    ),
);

export default useNumberPersistStore;
