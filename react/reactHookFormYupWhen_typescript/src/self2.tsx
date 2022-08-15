import * as React from 'react';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

interface Iobj {
    name: string;
    age: number;
}

interface Iform {
    objList: Iobj[];
}

const Self2 = () => {
    const schema = yup.object().shape({
        objList: yup.array().test({
            message: 'objList를 확인해주세요.',
            test: (objList) => {
                if(objList) {
                    const filterObjList = objList?.filter((obj) => obj.name.includes('test'));
                    return filterObjList.length > 0;
                }

                return false;
            }
        })
    })

    const { 
        register, 
        handleSubmit, 
        formState: { errors }, 
        setValue, 
        getValues,
        watch 
    } = useForm<Iform>({
        resolver: yupResolver(schema),
        defaultValues: {
            objList: []
        }
    })

    const clickAdd = () => {
        setValue('objList', [...getValues('objList'), { name: '', age: 0 }])
    }

    const clickCheck = () => {
        alert('Success');
    }

    return (
        <div>
            <div>
                {watch('objList')?.map((obj, index) => (
                    <div key={index}>
                        <input type="text" {...register(`objList.${index}.name`)} />
                        <input type="number" {...register(`objList.${index}.age`)} />
                    </div>
                ))}

                <span>{errors.objList && errors.objList.message}</span>
            </div>

            <button onClick={clickAdd}>추가</button>
            <button onClick={handleSubmit(clickCheck)}>검증</button>
        </div>
    )
}

export default Self2;