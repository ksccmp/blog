import { TFunction, i18n } from 'i18next';
import { withTranslation } from 'react-i18next';

function Hoc({ t, i18n }: { t: TFunction; i18n: i18n }) {
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
                <p>{t('fruitApple')}</p>
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
                {/* 마크업 변경 번역 (HOC에서 불가) */}
                <p>{t('sentenceMarkup')}</p>
            </div>
        </div>
    );
}

export default withTranslation()(Hoc);
