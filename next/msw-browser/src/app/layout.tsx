import { Inter } from 'next/font/google';
import { ReactNode } from 'react';
import MswProvider from './(provider)/MswProvider';
import './globals.css';

const inter = Inter({ subsets: ['latin'] });

export default function RootLayout({ children }: { children: ReactNode }) {
    return (
        <html lang="en">
            <body className={inter.className}>
                <MswProvider>{children}</MswProvider>
            </body>
        </html>
    );
}
