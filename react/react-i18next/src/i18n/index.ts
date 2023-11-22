import i18n from 'i18next';
import LanguageDetector from 'i18next-browser-languagedetector';
import { initReactI18next } from 'react-i18next';
import othersEn from './others/en';
import othersKo from './others/ko';
import translationEn from './translation/en';
import translationKo from './translation/ko';

i18n.use(LanguageDetector)
    .use(initReactI18next)
    .init({
        // 언어별 사용될 리소스 설정 (default undefined)
        /*
        resources: {
            [lng]: {
                [ns]: json 파일
            }
        }
        */
        resources: {
            ko: {
                translation: translationKo,
                others: othersKo,
            },
            en: {
                translation: translationEn,
                others: othersEn,
            },
        },
        // default 언어 설정 (default undefined)
        // lng: 'ko', // languagedetector에 의해 자동설정 되기 때문에 사용 x
        // 사용자 기반 언어 설정(ex, LanguageDetector)이 사용 불가능할 경우 사용될 언어 설정 (default dev)
        fallbackLng: 'ko',
        // default namespace 설정 (default translation)
        ns: 'others',
        // react-i18next 처리 로그 콘솔 출력 설정 (default false)
        debug: true,
        // 동적인 데이터 값 할당 설정
        interpolation: {
            escapeValue: false, // react는 XSS에 안전하기 때문에 false로 설정
        },
    });

export default i18n;
