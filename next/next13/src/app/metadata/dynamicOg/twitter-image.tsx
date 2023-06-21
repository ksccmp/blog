import { ImageResponse } from 'next/server';

export const size = { width: 600, height: 300 };
export const alt = 'Dynamic Twiiter';
export const contentType = 'image/png';
export const runtime = 'edge';

export default function () {
    return new ImageResponse(
        (
            <div
                style={{
                    display: 'flex',
                    justifyContent: 'center',
                    alignItems: 'center',
                    fontSize: 128,
                    background: 'white',
                    width: '100%',
                    height: '100%',
                }}
            >
                Dynamic Twitter Image Generation!
            </div>
        ),
    );
}
