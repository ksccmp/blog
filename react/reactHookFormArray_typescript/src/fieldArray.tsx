import * as React from 'react';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { useFieldArray, useForm } from 'react-hook-form';

// obj interface
interface Iobj {
    name: string;
    age: number;
}

// form interface
interface Iform {
    objList: Iobj[];
}

const FieldArray = () => {
    // 유효성 검증 조건
    const schema = yup.object().shape({
        objList: yup.array().of(
            yup.object().shape({
                name: yup.string().required('아이디를 입력해주세요.'), 
                age: yup.number().min(3, '3이상 값을 입력해주세요.').max(10, '10이하 값을 입력해주세요.'),
            })
        )
    })
    
    // useForm (* 수정)
    const { 
        register, 
        handleSubmit, 
        formState: { errors } ,
        control,
        watch,
    } = useForm<Iform>({
        resolver: yupResolver(schema),
        defaultValues: {
            objList: []
        }
    })

    // useFieldArray (* 추가)
    const {fields, append, remove } = useFieldArray({
        control,
        name: 'objList',
    })

    // handler
    const handle = {
        // 추가 (* 수정)
        clickAdd: () => {
            append({
                name: '',
                age: 0,
            })
        },

        // 삭제 (* 수정)
        clickDelete: (index: number) => {
            remove(index);
        },

        // 검증
        clickCheck: () => {
            alert('Success');
            console.log(watch());
        }
    }

    return (
        <div>
            <div>
                <button onClick={handle.clickAdd}>추가</button>
                <button onClick={handleSubmit(handle.clickCheck)}>검증</button>
            </div>

            <div>
                {/* (* 수정) */}
                {fields.map((obj, index) => (
                    <div key={index}>
                        <div>
                            <input type="text" placeholder='input name ...' {...register(`objList.${index}.name`)} />
                            {errors.objList?.[index]?.name && errors.objList?.[index]?.name?.message}
                        </div>

                        <div>
                            <input type="number" placeholder='input age ...' {...register(`objList.${index}.age`)} />
                            {errors.objList?.[index]?.age && errors.objList?.[index]?.age?.message}
                        </div>

                        <button onClick={() => handle.clickDelete(index)}>삭제</button>
                    </div>
                ))}
            </div>
        </div>
    )
}

export default FieldArray;