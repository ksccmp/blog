/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ['./src/**/*.{js,ts,jsx,tsx}'],
    theme: {
        extend: {
            keyframes: {
                animationKeyframes: {
                    '0%, 100%': { fontSize: '3rem' },
                    '50%': { fontSize: '1rem' },
                },
            },

            animation: {
                addAnimation: '0.5s ease-out animationKeyframes',
            },
        },
    },
    plugins: [],
};
