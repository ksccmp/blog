import * as React from 'react';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

interface Iform {
    displayContent: string;
}

const Self1 = () => {
    const schema = yup.object().shape({
        displayContent: yup
            .string()
            .test({
                message: 'displayContent를 확인해주세요.',
                test: (displayContent) => {
                    if(displayContent?.includes('test') && displayContent.length > 5) {
                        return true;
                    } else {
                        return false;
                    }
                }
            })
    })

    const { register, handleSubmit, formState: { errors } } = useForm<Iform>({
        resolver: yupResolver(schema),
    })

    const clickCheck = () => {
        alert('Success');
    }

    return (
        <div>
            <div>
                <input type="text" {...register('displayContent')} />
                <span>{errors.displayContent && errors.displayContent.message}</span>
            </div>

            <button onClick={handleSubmit(clickCheck)}>검증</button>
        </div>
    )
}

export default Self1;