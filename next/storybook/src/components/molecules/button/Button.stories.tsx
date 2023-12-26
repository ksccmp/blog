import { Meta, StoryObj } from '@storybook/react';
import Button from './Button';

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
};

export const Size: Story = {
    args: {
        children: 'size',
        size: 'medium',
    },
};
