import { render, screen } from '@testing-library/react';

describe('getByAltText test', () => {
    test('default test', () => {
        render(
            <div>
                <img src="/assets/react.svg" alt="react-image" />
            </div>,
        );

        expect(screen.getByAltText('react-image')).toBeInTheDocument();
    });
});
