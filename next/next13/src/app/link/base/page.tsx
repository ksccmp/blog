'use client';

import Link from 'next/link';
import styled from 'styled-components';

const LinkBasePage = () => {
    return (
        <div>
            <h2>기본 링크</h2>
            <ul>
                <li>
                    <Link href="/fetching/ssr">
                        <Text>ssr</Text>
                    </Link>
                </li>

                <li>
                    <Link href="/fetching/ssg">
                        <Text>ssg</Text>
                    </Link>
                </li>

                <li>
                    <Link href="/fetching/isr">
                        <Text>isr</Text>
                    </Link>
                </li>
            </ul>
        </div>
    );
};

export default LinkBasePage;

const Text = styled.p`
    color: olive;
`;
