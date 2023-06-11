import Link from 'next/link';

const LinkTypedRoutePage = () => {
    return (
        <div>
            <h2>Only Project Route 링크</h2>
            <ul>
                <li>
                    {/* next.config.js 설정에 따라 존재하지 않는 url일 경우 에러 발생 */}
                    <Link href="/fetching/ssr/test">
                        <p>ssr test</p>
                    </Link>
                </li>

                <li>
                    {/* 존재하는 url은 에러 미 발생 */}
                    <Link href="/fetching/ssr">
                        <p>ssr</p>
                    </Link>
                </li>
            </ul>
        </div>
    );
};

export default LinkTypedRoutePage;
