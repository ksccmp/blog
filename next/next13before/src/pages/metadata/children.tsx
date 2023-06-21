import Head from 'next/head';
import MetadataLayout from '../../layouts/metadata/layout';

const MetadataChildren = () => {
    return (
        <MetadataLayout>
            <Head>
                <title>children title 테스트</title>
                <meta name="description" content="children description 테스트" />

                <meta property="og:title" content="og children title 테스트" />
                <meta property="og:description" content="og children description 테스트" />
                <meta property="og:site_name" content="og children site name 테스트" />
            </Head>

            <div>
                <h2>Metadata Children Page</h2>
            </div>
        </MetadataLayout>
    );
};

export default MetadataChildren;
