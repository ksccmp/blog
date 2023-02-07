import { GetServerSideProps } from 'next';
import { getServerSideSitemap, ISitemapField } from 'next-sitemap';

export const getServerSideProps: GetServerSideProps = async (context) => {
    const productNos: number[] = [1, 2, 3, 4, 5, 6, 7, 8]; // fetch를 통해 데이터 가져오는 구간
    const sitemapFields: ISitemapField[] = productNos.map((productNo) => {
        return {
            loc: `http://localhost:8088/product/${productNo}`, // 페이지 경로
            lastmod: new Date().toISOString(), // 최근변경일자
            changefreq: 'daily', // 페이지 주소 변경 빈도 (검색엔진에 제공됨) - always, daily, hourly, monthly, never, weekly, yearly 중 택 1
            priority: 1, // 페이지 주소 우선순위 (검색엔진에 제공됨, 우선순위가 높은 순서대로 크롤링함)
        }
    });

    return getServerSideSitemap(context, sitemapFields);
}

export default () => {
    //
};