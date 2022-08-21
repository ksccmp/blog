import React from 'react';
import { Link } from 'react-router-dom';

const LinkPage = () => {
    return (
        <div>
            <h2>LinkPage</h2>
            {/* 절대경로 사용 */}
            <Link to="/location">Location 페이지</Link> <br />
            {/* 상대경로 사용 */}
            <Link to="../">부모 페이지</Link> <br />
            <Link to="children">자식 페이지</Link> <br />
        </div>
    );
};

export default LinkPage;
