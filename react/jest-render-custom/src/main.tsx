import React from 'react';
import ReactDOM from 'react-dom/client';
import { RecoilRoot } from 'recoil';
import App from './App.tsx';

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        {/* recoil 사용을 위한 RecoilRoot 설정 */}
        <RecoilRoot>
            <App />
        </RecoilRoot>
    </React.StrictMode>,
);
