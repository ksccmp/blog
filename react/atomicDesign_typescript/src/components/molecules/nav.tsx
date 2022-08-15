import * as React from 'react';
import styled from 'styled-components';
import { Text } from '../atoms/text';

const Nav = () => {
    return (
        <Wrapper>
            <Text size='large' weight='bold'>Home</Text>
            <Text size='large' weight='bold'>CardSearch</Text>
            <Text size='large' weight='bold'>Advertise</Text>
        </Wrapper>
    )
}

export default Nav;

const Wrapper = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 36px;

    padding: 20px 0;
`