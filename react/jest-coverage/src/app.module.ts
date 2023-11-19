/* eslint-disable prettier/prettier */
export function increaseValue(value: number) { // statements (1/1), functions (1/1), lines (1/1)
    return value + 1; // statements (1/1), lines (1/1)
}

export const decrease = () => { // statements (2/2), functions (1/1), lines (1/1)
    const decreaseValue = (value: number) => { // statements (1/1), functions (1/1), lines (1/1)
        if (value <= 0) { // statements (1/1), branches (1/1), lines (1/1)
            return 0; // statements (1/1), lines (1/1)
        } else { // branches (1/1)
            return value - 1; // statements (1/1), lines (0/1)
        }
    };

    return { // statements (1/1), lines (1/1)
        decreaseValue,
    };
};

export const multiplyValue = (value: number) => { // statements (2/2), functions (1/1), lines (1/1)
    switch (value) { // statements (1/1), lines (1/1)
        case 1: { // branches (1/1)
            return 1 * 1; // statements (1/1), lines (1/1)
        }
        case 2: { // branches (1/1)
            return 2 * 2; // statements (1/1), lines (1/1)
        }
        default: { // branches (1/1)
            return value * value; // statements (1/1), lines (1/1)
        }
    }
};
