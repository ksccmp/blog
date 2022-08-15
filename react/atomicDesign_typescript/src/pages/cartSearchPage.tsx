import * as React from 'react';
import styled from 'styled-components';
import Nav from '../components/molecules/nav';
import CardSearch from '../components/templates/cardSearch';

const CardSearchPage = () => {
    return (
        <Wrapper>
            <Nav />
            <CardSearch />
        </Wrapper>
    )
}

export default CardSearchPage;

const Wrapper = styled.div`
    background-color: #DCDABD;
`