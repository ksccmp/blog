import * as React from 'react';
import dayjs from 'dayjs';

const Get = () => {

    React.useEffect(() => {
        console.log(dayjs(new Date()).toObject());
    }, [])

    return (
        <div>
            <p>{dayjs(new Date()).format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/05/16 01:44:49 */}
            <p>{dayjs(new Date()).get('second')}</p> {/* 49 */}
            <p>{dayjs(new Date()).get('minute')}</p> {/* 44 */}
            <p>{dayjs(new Date()).get('hour')}</p> {/* 1 */}
            <p>{dayjs(new Date()).get('date')}</p> {/* 16 */}
            <p>{dayjs(new Date()).get('month') + 1}</p> {/* 5, 월은 0부터 시작 */}
            <p>{dayjs(new Date()).get('year')}</p> {/* 2022 */}
        </div>
    )
}

export default Get;