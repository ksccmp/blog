import { RenderOptions, render } from '@testing-library/react';
import { ReactElement } from 'react';
import { RecoilRoot } from 'recoil';

const customRender = (ui: ReactElement, options?: RenderOptions) =>
    render(ui, {
        wrapper: ({ children }) => <RecoilRoot>{children}</RecoilRoot>,
        ...options,
    });

export default customRender;
