import * as React from 'react';
import styled from 'styled-components';

interface Props {
    value?: number | string;
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

const UseController = React.forwardRef((props: Props, ref: React.LegacyRef<HTMLInputElement>) => {
    return (
        <Wrapper>
            <input type="text" onChange={props.onChange} ref={ref} />
        </Wrapper>
    );
});

export default UseController;

const Wrapper = styled.div``;
