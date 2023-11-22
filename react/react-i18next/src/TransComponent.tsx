import { Trans, useTranslation } from 'react-i18next';

export default function TransComponent() {
    const { i18n } = useTranslation();
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
                    <Trans
                        defaultValue="key값이 없는 경우 이곳에 설정한 값이 보입니다."
                        ns="특정 namespace의 언어를 보여주고 싶을 때 설정합니다"
                    >
                        fruitApple
                    </Trans>
                </p>
                <p>
                    <Trans>fruitGraph</Trans>
                </p>
                <p>
                    <Trans>fruitLemon</Trans>
                </p>
            </div>

            <div>
                <h2>Sentence</h2>

                {/* 파라미터 사용 번역 */}
                <p>
                    <Trans
                        i18nKey="sentenceHello"
                        values={{
                            firstName: firstName,
                            lastName: lastName,
                        }}
                    />
                </p>
                {/* 마크업 변경 번역 */}
                <p>
                    <Trans
                        i18nKey="sentenceMarkup"
                        components={{
                            bold: <strong />,
                        }}
                    />
                </p>
            </div>
        </div>
    );
}
