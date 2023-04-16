import React from 'react';

const App = () => {
    return (
        <div>
            <div data-cy="title-wrapper1">
                <h2>첫번째 타이틀</h2>

                <ul>
                    <li data-cy="item">첫번째 아이템1</li>
                    <li data-cy="item">첫번째 아이템2</li>
                </ul>
            </div>

            <div data-cy="title-wrapper2">
                <h2>두번째 타이틀</h2>

                <ul>
                    <li data-cy="item">두번째 아이템1</li>
                    <li data-cy="item">두번째 아이템2</li>
                </ul>
            </div>
        </div>
    );
};

export default App;
