import { Meta, StoryObj } from '@storybook/react';
import RootPage from './page';

const meta: Meta<typeof RootPage> = {
    title: 'Default/RootPage',
    component: RootPage,
};

export default meta;
type Story = StoryObj<typeof RootPage>;

export const Default: Story = {
    args: {},
};
