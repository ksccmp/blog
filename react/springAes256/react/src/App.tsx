import * as React from 'react';
import { decrypt, encrypt } from './aes256';

const App = () => {
    return (
        <div>
            <h2>암호화 : {encrypt('react-java aes256')}</h2>
            <h2>복호화: {decrypt('2CCcc2H0c6LpIZymYYcqD7VvKkA/6XwxJacNENaVE+M=')}</h2>
        </div>
    )
}

export default App;