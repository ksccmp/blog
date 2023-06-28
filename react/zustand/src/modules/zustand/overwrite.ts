import omit from 'lodash-es/omit'; // $ npm install lodash-es
import { create } from 'zustand';

interface UseNumberOverwriteStore {
    numberA: number;
    numberB: number;
    clear: () => void;
    deleteNumberB: () => void;
}

const useNumberOverwriteStore = create<UseNumberOverwriteStore>()((set, get) => ({
    numberA: 2, // store state
    numberB: 3, // store state
    // 초기화
    clear: () => set({}, true),
    // numberB 삭제
    deleteNumberB: () => set((state) => omit(state, ['numberB']), true),
}));

export default useNumberOverwriteStore;
