import Button from '@/components/molecules/button/Button';
import { Meta, StoryObj } from '@storybook/react';

const meta = {
    title: 'Molecules/Button',
    component: Button,
    parameters: {
        layout: 'centered',
    },
    tags: ['autodocs'],
    args: {
        type: 'button',
    },
} satisfies Meta<typeof Button>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Color: Story = {
    args: {
        children: 'color',
        color: 'primary',
    },
    parameters: {
        // figma 연동
        design: {
            type: 'figma',
            url: 'https://www.figma.com/file/V4AOEBI7teG5jnQYU191Gl/storybook-sample?type=design&node-id=0-1&mode=design&t=RhV0TsDUOWU7DkSv-0',
        },
    },
};

export const Size: Story = {
    args: {
        children: 'size',
        size: 'medium',
    },
};
