import * as React from 'react';
import styled from 'styled-components';
import { Button } from '../atoms/button';
import { Text } from '../atoms/text';

interface Iprops {
    label: string;
}

const Card = (props: Iprops) => {
    return (
        <Wrapper>
            <Text size='medium' weight='bold'>{props.label}</Text>
            <Button color='primary' size='medium' fullWidth>버튼</Button>
        </Wrapper>
    )
}

export default Card;

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    gap: 16px;

    width: 360px;

    padding: 20px;
    margin: 20px 0;

    box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.4);
`