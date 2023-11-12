import { render } from '@testing-library/react';

describe('not recommend test', () => {
    test('use className', () => {
        const { container } = render(
            <div>
                <h2 className="subject">이번 주제는 className의 사용을 추천하지 않는 것입니다.</h2>
            </div>,
        );

        expect(container.querySelector('.subject')).toBeInTheDocument();
    });

    test('use id', () => {
        const { container } = render(
            <div>
                <h2 id="subject">이번 주제는 id의 사용을 추천하지 않는 것입니다.</h2>
            </div>,
        );

        expect(container.querySelector('#subject')).toBeInTheDocument();
    });

    test('use tag', () => {
        const { container } = render(
            <div>
                <h2>이번 주제는 tag의 사용을 추천하지 않는 것입니다.</h2>
            </div>,
        );

        expect(container.querySelector('h2')).toBeInTheDocument();
    });
});
