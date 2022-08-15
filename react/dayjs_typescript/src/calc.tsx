import * as React from 'react';
import dayjs from 'dayjs';

const Calc = () => {
    return (
        <div>
            <p>{dayjs(new Date()).format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/05/16 01:38:48 */}
            <p>{dayjs(new Date()).add(1, 'second').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/05/16 01:38:49 */}
            <p>{dayjs(new Date()).add(1, 'minute').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/05/16 01:39:48 */}
            <p>{dayjs(new Date()).add(1, 'hour').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/05/16 02:38:48 */}
            <p>{dayjs(new Date()).add(1, 'day').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/05/17 01:38:48 */}
            <p>{dayjs(new Date()).add(1, 'week').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/05/23 01:38:48 */}
            <p>{dayjs(new Date()).add(1, 'month').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2022/06/16 01:38:48 */}
            <p>{dayjs(new Date()).add(1, 'year').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2023/05/16 01:38:48 */}

            <p>{dayjs(new Date()).subtract(1, 'year').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2021/05/16 01:38:48 */}
            <p>{dayjs(new Date()).add(-1, 'year').format('YYYY/MM/DD hh:mm:ss')}</p> {/* 2021/05/16 01:38:48 */}
        </div>
    )
}

export default Calc;