import * as React from 'react';
import { UseFormRegisterReturn } from 'react-hook-form';
import styled from 'styled-components';

interface Props {
    register?: UseFormRegisterReturn;
}

const RegisterProps = React.forwardRef((props: Props, ref) => {
    return (
        <Wrapper>
            <input type="text" {...props.register} />
        </Wrapper>
    );
});

export default RegisterProps;

const Wrapper = styled.div``;
