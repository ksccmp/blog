import { render, screen } from '@testing-library/react';

describe('getByLabelText test', () => {
    test('default test', () => {
        render(
            <div>
                <label htmlFor="my-checkbox">
                    <input type="checkbox" id="my-checkbox" />
                    my label
                    <button>cancle</button>
                </label>
            </div>,
        );

        expect(screen.getByLabelText('my label')).toBeInTheDocument();
        expect(screen.getByLabelText('my label').getAttribute('type')).toEqual('checkbox');
    });

    test('only use label test', () => {
        render(
            <div>
                <label>my label</label>
            </div>,
        );

        expect(screen.getByLabelText('my label')).toBeInTheDocument(); // Fail !!! (Make sure you're using the "for" attribute or "aria-labelledby" attribute correctly.)
    });
});
