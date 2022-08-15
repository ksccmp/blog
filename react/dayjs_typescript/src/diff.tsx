import * as React from 'react';
import dayjs from 'dayjs';

const Diff = () => {

    const targetDate = dayjs('2023-01-01 00:00:00');

    return (
        <div>
            <p>{targetDate.diff(new Date(), 'second')}</p> {/* 19864970 */}
            <p>{targetDate.diff(new Date(), 'minute')}</p> {/* 331082 */}
            <p>{targetDate.diff(new Date(), 'hour')}</p> {/* 5518 */}
            <p>{targetDate.diff(new Date(), 'day')}</p> {/* 229 */}
            <p>{targetDate.diff(new Date(), 'week')}</p> {/* 32 */}
            <p>{targetDate.diff(new Date(), 'month')}</p> {/* 7 */}
            <p>{targetDate.diff(new Date(), 'year')}</p> {/* 0 */}
        </div>
    )
}

export default Diff;