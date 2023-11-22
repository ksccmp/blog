import { useTranslation } from 'react-i18next';

export default function Hook() {
    const { t, i18n } = useTranslation();
    const firstName = 'react';
    const lastName = 'i18next';

    return (
        <div>
            {/* 언어 변경 */}
            <button onClick={() => i18n.changeLanguage('ko')}>korean</button>
            <button onClick={() => i18n.changeLanguage('en')}>english</button>

            <div>
                <h2>Fruit</h2>

                {/* 일반적인 번역 */}
                <p>
                    {t('fruitApple', {
                        defaultValue: 'key값이 없는 경우 이곳에 설정한 값이 보입니다.',
                        fallbackLng: '사용자 기반 언어 설정이 사용 불가능한 경우 사용될 언어를 설정합니다.',
                        lng: 'i18next의 현재 언어와 상관없이 고정된 언어를 적용하고 싶을 때 설정합니다.',
                        ns: '특정 namespace의 언어를 보여주고 싶을 때 설정합니다',
                    })}
                </p>
                <p>{t('fruitGraph')}</p>
                <p>{t('fruitLemon')}</p>
            </div>

            <div>
                <h2>Sentence</h2>

                {/* 파라미터 사용 번역 */}
                <p>
                    {t('sentenceHello', {
                        firstName: firstName,
                        lastName: lastName,
                    })}
                </p>
                {/* 마크업 변경 번역 (hook에서 불가) */}
                <p>{t('sentenceMarkup')}</p>
            </div>
        </div>
    );
}
