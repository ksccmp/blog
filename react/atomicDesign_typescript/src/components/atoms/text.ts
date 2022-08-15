import styled, { css } from 'styled-components';

interface Iprops {
    size: 'small' | 'medium' | 'large';
    weight: 'normal' | 'bold';
}

export const Text = styled.span<Iprops>`
    ${(props) => {
        switch(props.size) {
            case 'small':
                return css`
                    font-size: 12px;
                `

            case 'medium':
                return css`
                    font-size: 20px;
                `

            case 'large':
                return css`
                    font-size: 32px;
                `
        }
    }}

    ${(props) => {
        switch(props.weight) {
            case 'normal':
                return css`
                    font-weight: 500;
                `

            case 'bold':
                return css`
                    font-weight: 700;
                `
        }
    }}
`