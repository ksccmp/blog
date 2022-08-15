import * as React from 'react';
import Calc from './calc';
import Diff from './diff';
import Format from './format';
import Get from './get';

const App = (): JSX.Element => {

    // let myNumber: number = '23'; // 정의된 타입에 맞는 데이터가 아니어서 에러 발생

    return (
        <div>
            {/* <Format /> */}
            {/* <Get /> */}
            {/* <Calc /> */}
            <Diff />
        </div>
    )
}

export default App;