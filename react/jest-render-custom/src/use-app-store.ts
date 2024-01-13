import { atom, useRecoilState } from 'recoil';

const useAppStore = () => {
    const [count, setCount] = useRecoilState<number>(
        atom<number>({
            key: 'count',
            default: 0,
        }),
    );

    return {
        count,
        increase: () => {
            setCount(count + 1);
        },
        decrease: () => {
            setCount(count - 1);
        },
    };
};

export default useAppStore;
