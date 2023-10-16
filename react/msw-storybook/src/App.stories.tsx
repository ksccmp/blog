import { Meta, StoryObj } from '@storybook/react';
import { rest } from 'msw';
import App from "./App";

const meta: Meta<typeof App> = {
    title: 'Default/App',
    component: App,
};

export default meta;
type Story = StoryObj<typeof App>;

export const Default: Story = {
    args: {},
};

export const MswOverride: Story = {
    args: {},
}
MswOverride.parameters = {
    msw: {
        handlers: [
            // GET method인 /get-names를 해당 component에서만 따로 활용
            rest.get('/get-names', (req, res, ctx) => {
                const names = ['storybook-jimi', 'storybook-john', 'storybook-scott', 'storybook-queen']

                return res(
                    ctx.status(200),
                    ctx.json(names),
                )
            })
        ]
    }
}