/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ['./src/**/*.{js,ts,jsx,tsx}'],
    theme: {
        extend: {
            colors: {
                myColor: {
                    100: '#a3a3a3',
                },
            },
            fontSize: {
                mySize: '3rem',
            },
            width: {
                myWidth: '15rem',
            },
            screens: {
                myScreen: '999px',
            },
            // keyframes: {
            //     animationKeyframes: {
            //         '0%, 100%': { fontSize: '3rem' },
            //         '50%': { fontSize: '1rem' },
            //     },
            // },
            // animation: {
            //     addAnimation: '0.5s ease-out animationKeyframes',
            // },
        },
    },
    plugins: [],
};
