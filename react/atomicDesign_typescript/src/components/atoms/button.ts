import styled, { css } from 'styled-components';

interface Iprops {
    color: 'primary';
    size: 'medium';
    fullWidth?: boolean;
}

export const Button = styled.button<Iprops>`
    border: none;
    border-radius: 8px;

    ${(props) => {
        switch(props.color) {
            case 'primary':
                return css`
                    color: white;
                    background-color: olive;
                `
        }
    }}

    ${(props) => {
        switch(props.size) {
            case 'medium':
                return css`
                    width: 104px;
                    height: 34px;
                    padding: 8px 12px;
                `
        }
    }}

    ${(props) => {
        if(props.fullWidth) {
            return css`
                width: 100%;
            `
        }
    }}
`