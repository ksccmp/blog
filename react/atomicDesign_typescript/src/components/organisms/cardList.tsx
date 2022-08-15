import * as React from 'react';
import styled from 'styled-components';
import { Text } from '../atoms/text';
import Card from '../molecules/card';

const CardList = () => {
    return (
        <Wrapper>
            <Text size='medium' weight='bold'>선택할 수 있는 카드 목록</Text>
            <Card label='첫번째 카드' />
            <Card label='두번째 카드'/>
            <Card label='세번째 카드'/>
            <Card label='네번째 카드'/>
        </Wrapper>
    )
}

export default CardList;

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
`;