import axios from 'axios';
import { GetServerSideProps } from 'next';
import { useEffect, useRef } from 'react';
import { dehydrate, QueryClient, useInfiniteQuery } from 'react-query';

export const getServerSideProps: GetServerSideProps = async (context) => {
    const queryClient = new QueryClient();

    try {
        // prefetchInfiniteQuery에 await 필수
        await queryClient.prefetchInfiniteQuery('productNo', async () => {
            const res = await axios.get('http://localhost:8080/product/no');
            return res.data;
        });

        return {
            props: {
                // infiniteQuery를 사용하거나 Promise.all을 사용할 경우 JSON처리 필수
                dehydratedState: JSON.parse(JSON.stringify(dehydrate(queryClient))),
            },
        };
    } catch (error) {
        return {
            notFound: true,
        };
    }
};

const InfiniteHydration = () => {
    // ref
    const observerRef = useRef<IntersectionObserver>();
    const boxRef = useRef<HTMLDivElement>(null);

    const infiniteQueryProductNo = () => {
        const res = useInfiniteQuery(
            'productNo',
            async ({ pageParam = 0 }) => {
                const res = await axios.get('http://localhost:8080/product/no');
                return res.data;
            },
            {
                getNextPageParam: (lastPage, allPages) => {
                    // 다음 페이지 요청에 사용될 pageParam값 return 하기
                    return true;
                },
            },
        );

        // IntersectionObserver 설정
        const intersectionObserver = (entries: IntersectionObserverEntry[], io: IntersectionObserver) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    // 관찰하고 있는 entry가 화면에 보여지는 경우
                    io.unobserve(entry.target); // entry 관찰 해제
                    res.fetchNextPage(); // 다음 페이지 데이터 요청
                }
            });
        };

        // useEffect
        useEffect(() => {
            if (observerRef.current) {
                // 기존에 IntersectionObserver이 있을 경우
                observerRef.current.disconnect(); // 연결 해제
            }

            observerRef.current = new IntersectionObserver(intersectionObserver); // IntersectionObserver 새롭게 정의
            boxRef.current && observerRef.current.observe(boxRef.current); // boxRef 관찰 시작
        }, [res]); // res값이 변경될때마다 실행

        if (res.isLoading) return <div>Loading...</div>;
        if (res.data) {
            return (
                <div>
                    {res.data.pages.map((page, pageIndex) => {
                        const productNos: number[] = page;

                        return productNos.map((productNo, productNoIndex) => (
                            // 가장 마지막에 있는 Box를 boxRef로 등록
                            <div
                                key={`${productNo}/${pageIndex}`}
                                ref={
                                    productNos.length * pageIndex + productNoIndex ===
                                    res.data.pages.length * productNos.length - 1
                                        ? boxRef
                                        : null
                                }
                            >
                                <h2>데이터 Fetch로 가져온 상품번호 : {productNo}</h2>
                            </div>
                        ));
                    })}
                </div>
            );
        }
    };
    return <>{infiniteQueryProductNo()}</>;
};

export default InfiniteHydration;
