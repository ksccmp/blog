import { ImageResponse } from 'next/server';

export const config = {
    runtime: 'edge',
};

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
                OG Image Generation!
            </div>
        ),
    );
}
