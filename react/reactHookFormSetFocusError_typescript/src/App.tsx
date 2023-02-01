import React, { useEffect } from 'react';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

interface UseForm {
    firstPhone: string;
    secondPhone: string;
    thirdPhone: string;
}

const App = () => {

    /**
     * validation
     */
    const schema = yup.object().shape({
        firstPhone: yup.string().nullable().required('전화번호를 입력해주세요.'),
        secondPhone: yup.string().nullable().required('전화번호를 입력해주세요.'),
        thirdPhone: yup.string().nullable().required('전화번호를 입력해주세요.'),
    })

    const { register, setFocus, watch, getValues, reset } = useForm<UseForm>({
        resolver: yupResolver(schema),
    })

    /**
     * useEffect
     */
    useEffect(() => {
        reset({
            firstPhone: '010',
            secondPhone: '1234',
            thirdPhone: '56'
        });
    }, [])

    useEffect(() => {
        if(getValues('firstPhone').length >= 3) { // 첫번째 전화번호의 길이가 3이 넘어가는 경우 두번째 전화번호로 포커싱
            // setTimeout을 이용하여 코드 동작 시점을 변경
            setTimeout(() => {
                setFocus('secondPhone');
            }, 0)
        }
    }, [watch('firstPhone')])

    useEffect(() => {
        if(getValues('secondPhone').length >= 4) { // 두번째 전화번호의 길이가 4를 넘어가는 경우 세번째 전화번호로 포커싱
            // setTimeout을 이용하여 코드 동작 시점을 변경
            setTimeout(() => {
                setFocus('thirdPhone');
            }, 0)
        }
    }, [watch('secondPhone')])

    return (
        <div>
            <h2>
                전화번호 입력 기준치가 되면 다음 입력칸으로 넘어가는 테스트
            </h2>

            <div style={{display: 'flex', gap: '12px'}}>
                <input type="text" maxLength={3} placeholder="첫번째" {...register('firstPhone')} />
                <input type="text" maxLength={4} placeholder="두번째" {...register('secondPhone')} />
                <input type="text" maxLength={4} placeholder="세번째" {...register('thirdPhone')} />
            </div>
        </div>
    )
}

export default App;