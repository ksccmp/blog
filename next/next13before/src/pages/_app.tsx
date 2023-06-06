import { AppProps } from 'next/app';
import './font.css';

const App = ({ Component, pageProps }: AppProps) => {
    return <Component {...pageProps} />;
};

export default App;
