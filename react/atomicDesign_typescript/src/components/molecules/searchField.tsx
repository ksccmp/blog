import * as React from 'react';
import styled, { css } from 'styled-components';
import { Button } from '../atoms/button';
import { Input } from '../atoms/input';

interface Iprops {
    margin: number;
}

const SearchField = (props: Iprops) => {
    return (
        <Wrapper margin={props.margin}>
            <Input />
            <Button color='primary' size='medium'>조회</Button>
        </Wrapper>
    )
}

export default SearchField;

const Wrapper = styled.div<Iprops>`
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 12px;

    ${props => css`
        margin: ${props.margin}px;
    `}
`