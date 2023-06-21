import { ReactNode } from 'react';

interface Props {
    children: ReactNode;
}

const MetadataDynamicMetadataLayout = (props: Props) => {
    return <div>{props.children}</div>;
};

export default MetadataDynamicMetadataLayout;
