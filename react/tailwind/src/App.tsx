import React from 'react';

const App = () => {
    return (
        <div>
            {/* 색상 */}
            <div>
                <p className="text-blue-500">글자 색상</p>
                <p className="bg-red-500">배경 색상</p>
            </div>

            {/* 글자 크기, 두께 등 */}
            <div>
                <p className="text-lg">글자 크기</p>
                <p className="font-bold">글자 두께</p>
                <p className="tracking-tighter">문자 간격</p>
                <p className="leading-8">줄 높이</p>
            </div>

            {/* 여백 */}
            <div>
                <p className="m-4">외부 여백</p>
                <p className="p-4">내부 여백</p>
            </div>

            {/* 너비, 높이 */}
            <div>
                <p className="w-20">너비</p>
                <p className="min-w-full">최소 너비</p>
                <p className="h-12">높이</p>
                <p className="max-h-full">최대 높이</p>
            </div>

            {/* 레이아웃 */}
            <div>
                <p className="overflow-hidden">Overflow</p>
                <p className="absolute top-0 left-0">Position</p>
                <p className="box-border">box sizing</p>
            </div>

            {/* Border */}
            <div>
                <p className="border-4 border-slate-400 border-solid">두께 색상 등 기본 스타일</p>
                <p className="border-4 border-black border-solid rounded-md">반경</p>
            </div>

            {/* Flex, Grid */}
            <div>
                <div className="flex flex-col justify-center items-center gap-2">
                    <p>Flex</p>
                    <p>기본 스타일</p>
                </div>

                <div className="grid grid-cols-2 items-center gap-2">
                    <p>Grid</p>
                    <p>기본 스타일</p>
                </div>
            </div>

            {/* Transition */}
            <div>
                <p className="duration-500 ease-out">Transition 기본 스타일</p>
            </div>

            {/* Hover, Focus 등 */}
            <div>
                <p className="hover:text-sky-500">Hover</p>
                <input className="focus:text-sky-500" placeholder="Focus" />
            </div>

            {/* 반응형 */}
            <div>
                <p className="sm:text-red-500 lg:text-blue-500">반응형</p>
            </div>

            {/* 사용자 임의값 */}
            <div>
                <p className="text-[#a3a3a3]">글자 색상 임의값</p>
                <p className="text-[7px]">글자 크기 임의값</p>
                <p className="m-[5px]">외부 여백 임의값</p>
            </div>

            {/* 하위 요소 조작 */}
            <div>
                <div className="[&>p:nth-child(2n-1)]:text-blue-500">
                    <p>Selector 사용</p>
                </div>
                <div className="group">
                    <p className="group-hover:text-red-500">Parent 기반 - 단일 사용</p>
                </div>
                <div className="group/aaa">
                    <div className="group/bbb">
                        <p className="group-hover/aaa:text-red-500">Parent 기반 - 복수 사용1</p>
                        <p className="group-hover/bbb:text-blue-500">Parent 기반 - 복수 사용2</p>
                    </div>
                </div>
            </div>

            {/* 애니메이션 */}
            <div>
                <p className="animate-addAnimation">애니메이션</p>
            </div>
        </div>
    );
};

export default App;
