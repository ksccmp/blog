import * as React from 'react';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

interface Iform {
    displayYn: string;
    displayContent: string;
}

const Base1 = () => {
    const schema = yup.object().shape({
        displayYn: yup.string().required('displayYn을 선택해주세요'),
        displayContent: yup
            .string()
            .when('displayYn', (displayYn, schema) => 
                displayYn === 'Y' ? schema.required('displayContent를 입력해주세요.') : schema
            )
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
                <select {...register('displayYn')}>
                    <option value="">blank</option>
                    <option value="Y">Yes</option>
                    <option value="N">No</option>
                </select>
                <span>{errors.displayYn && errors.displayYn.message}</span>
            </div>

            <div>
                <input type="text" {...register('displayContent')} />
                <span>{errors.displayContent && errors.displayContent.message}</span>
            </div>

            <button onClick={handleSubmit(clickCheck)}>검증</button>
        </div>
    )
}

export default Base1;