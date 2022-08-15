import * as React from 'react';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

interface Iobj {
    addObjYn: string;
    name: string;
    age: number;
}

interface Iform {
    objYn: string;
    obj: Iobj;
}

const ObjectInObject = () => {
    const schema = yup.object().shape({
        objYn: yup.string().required('objYn 선택해주세요'),
        obj: yup
            .mixed()
            .when('objYn', {
                is: (objYn: string) => objYn === 'Y',
                then: yup.object().shape({
                    name: yup.string().when('addObjYn', (addObjYn, schema) => 
                        addObjYn === 'Y' ? schema.required('name을 입력해주세요.') : schema
                    ),
                    age: yup.number().min(3, 'age를 3이상 입력해주세요.')
                })
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
                <select {...register('objYn')}>
                    <option value="">blank</option>
                    <option value="Y">Yes</option>
                    <option value="N">No</option>
                </select>
                <span>{errors.objYn && errors.objYn.message}</span>
            </div>

            <div>
                <div>
                    <select {...register('obj.addObjYn')}>
                        <option value="">blank</option>
                        <option value="Y">Yes</option>
                        <option value="N">No</option>
                    </select>
                </div>

                <div>
                    <input type="text" {...register('obj.name')} />
                    <span>{errors.obj?.name && errors.obj.name.message}</span>
                </div>

                <div>
                    <input type="number" {...register('obj.age')} />
                    <span>{errors.obj?.age && errors.obj.age.message}</span>
                </div>
            </div>

            <button onClick={handleSubmit(clickCheck)}>검증</button>
        </div>
    )
}

export default ObjectInObject;