import * as React from 'react';

const Index = () => {

    React.useEffect(() => {
        console.log('console test...');
    }, [])

    return (
        <div>
            <h2>Console Test...</h2>
        </div>
    );
};

export default Index;