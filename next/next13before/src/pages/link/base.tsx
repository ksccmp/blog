import Link from 'next/link';
import styled from 'styled-components';

const LinkBase = () => {
    return (
        <div>
            <h2>기본 링크</h2>
            <ul>
                <li>
                    <Link href="/fetching/ssr">
                        <a>
                            <Text>ssr</Text>
                        </a>
                    </Link>
                </li>

                <li>
                    <Link href="/fetching/ssg">
                        <a>
                            <Text>ssg</Text>
                        </a>
                    </Link>
                </li>

                <li>
                    <Link href="/fetching/isr">
                        <a>
                            <Text>isr</Text>
                        </a>
                    </Link>
                </li>
            </ul>
        </div>
    );
};

export default LinkBase;

const Text = styled.p`
    color: olive;
`;
