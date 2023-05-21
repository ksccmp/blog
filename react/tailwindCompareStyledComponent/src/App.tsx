import React from 'react';
import styled, { keyframes } from 'styled-components';

const App = () => {
    return (
        <div>
            {/* 색상 */}
            <div>
                <FontColor>글자 색상</FontColor>
                <BackgroundColor>배경 색상</BackgroundColor>
            </div>

            {/* 글자 크기, 두께 등 */}
            <div>
                <FontSize>글자 크기</FontSize>
                <FontWeight>글자 두께</FontWeight>
                <LetterSpacing>문자 간격</LetterSpacing>
                <LineHeight>줄 높이</LineHeight>
            </div>

            {/* 여백 */}
            <div>
                <Margin>외부 여백</Margin>
                <Padding>내부 여백</Padding>
            </div>

            {/* 너비, 높이 */}
            <div>
                <Width>너비</Width>
                <MinWidth>최소 너비</MinWidth>
                <Height>높이</Height>
                <MaxHeight>최대 높이</MaxHeight>
            </div>

            {/* 레이아웃 */}
            <div>
                <Overflow>Overflow</Overflow>
                <Position>Position</Position>
                <BoxSizing>box sizing</BoxSizing>
            </div>

            {/* Border */}
            <div>
                <BorderBase>두께 색상 등 기본 스타일</BorderBase>
                <BorderRadius>반경</BorderRadius>
            </div>

            {/* Flex, Grid */}
            <div>
                <FlexBase>
                    <p>Flex</p>
                    <p>기본 스타일</p>
                </FlexBase>

                <GridBase>
                    <p>Grid</p>
                    <p>기본 스타일</p>
                </GridBase>
            </div>

            {/* Transition */}
            <div>
                <Transition>Transition 기본 스타일</Transition>
            </div>

            {/* Hover, Focus 등 */}
            <div>
                <Hover>Hover</Hover>
                <Focus placeholder="Focus" />
            </div>

            {/* 반응형 */}
            <div>
                <Responsive>반응형</Responsive>
            </div>

            {/* 사용자 임의값 */}
            <div>
                <FontColorArbitary>글자 색상 임의값</FontColorArbitary>
                <FontSizeArbitary>글자 크기 임의값</FontSizeArbitary>
                <MarginArbitary>외부 여백 임의값</MarginArbitary>
            </div>

            {/* 하위 요소 조작 */}
            <div>
                <ChildSelector>
                    <p>Selector 사용</p>
                </ChildSelector>
                <ChildParentSingle>
                    <p>Parent 기반 - 단일 사용</p>
                </ChildParentSingle>
                <ChildParentMultiple1>
                    <ChildParentMultiple2>
                        <p>Parent 기반 - 복수 사용1</p>
                        <p>Parent 기반 - 복수 사용2</p>
                    </ChildParentMultiple2>
                </ChildParentMultiple1>
            </div>

            {/* 애니메이션 */}
            <div>
                <Animation>애니메이션</Animation>
            </div>
        </div>
    );
};

export default App;

const FontColor = styled.p`
    color: #3b82f6;
`;

const BackgroundColor = styled.p`
    background-color: #ef4444;
`;

const FontSize = styled.p`
    font-size: 1.125rem;
`;

const FontWeight = styled.p`
    font-weight: bold;
`;

const LetterSpacing = styled.p`
    letter-spacing: -0.05em;
`;

const LineHeight = styled.p`
    line-height: 2rem;
`;

const Margin = styled.p`
    margin: 1rem;
`;

const Padding = styled.p`
    padding: 1rem;
`;

const Width = styled.p`
    width: 5rem;
`;

const MinWidth = styled.p`
    min-width: 100%;
`;

const Height = styled.p`
    height: 3rem;
`;

const MaxHeight = styled.p`
    max-height: 100%;
`;

const Overflow = styled.p`
    overflow: hidden;
`;

const Position = styled.p`
    position: absolute;
    top: 0;
    left: 0;
`;

const BoxSizing = styled.p`
    box-sizing: border-box;
`;

const BorderBase = styled.p`
    border: 4px solid #94a3b8;
`;

const BorderRadius = styled.p`
    border: 4px solid black;
    border-radius: 0.375rem;
`;

const FlexBase = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 0.5rem;
`;

const GridBase = styled.div`
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    align-items: center;
    gap: 0.5rem;
`;

const Transition = styled.p`
    transition: 0.5s ease-out;
`;

const Hover = styled.p`
    &:hover {
        color: #0ea5e9;
    }
`;

const Focus = styled.input`
    &:focus {
        color: #0ea5e9;
    }
`;

const Responsive = styled.p`
    @media (min-width: 640px) {
        color: #ef4444;
    }

    @media (min-width: 1024px) {
        color: #3b82f6;
    }
`;

const FontColorArbitary = styled.p`
    color: #a3a3a3;
`;

const FontSizeArbitary = styled.p`
    font-size: 7px;
`;

const MarginArbitary = styled.p`
    margin: 5px;
`;

const ChildSelector = styled.div`
    & > p:nth-of-type(2n-1) {
        color: #3b82f6;
    }
`;

const ChildParentSingle = styled.div`
    &:hover {
        & > p {
            color: #ef4444;
        }
    }
`;

const ChildParentMultiple1 = styled.div`
    &:hover {
        & > div > p:nth-of-type(1) {
            color: #ef4444;
        }
    }
`;

const ChildParentMultiple2 = styled.div`
    &:hover {
        & > p:nth-of-type(2) {
            color: #3b82f6;
        }
    }
`;

const animationKeyframes = keyframes`
    0%, 100% {
        font-size: 3rem;
    }

    50% {
        font-size: 1rem;
    }
`;

const Animation = styled.p`
    animation: 0.5s ease-out ${animationKeyframes};
`;
