import * as React from 'react';
import styled from 'styled-components';
import SearchField from '../molecules/searchField';
import CardList from '../organisms/cardList';

const CardSearch = () => {
    return (
        <Wrapper>
            <SearchField margin={32} />
            <CardList />
        </Wrapper>
    )
}

export default CardSearch;

const Wrapper = styled.div``