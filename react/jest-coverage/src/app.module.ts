export const increaseValue = (value: number) => {
    return value + 1;
};

export const decreaseValue = (value: number) => {
    if (value <= 0) {
        return 0;
    } else {
        return value - 1;
    }
};
