import * as React from 'react';
import { Controller, useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import RegisterProps from './registerProps';
import UseController from './useController';
import { TextField } from '@material-ui/core';

interface Form {
    name: string;
}

const App = () => {
    const schema = yup.object().shape({
        name: yup.string().required('이름을 입력해주세요.'),
    });

    const {
        handleSubmit,
        formState: { errors },
        control,
    } = useForm<Form>({
        resolver: yupResolver(schema),
        defaultValues: {
            name: '',
        },
    });

    const clickCheck = () => {
        alert('Success');
    };

    return (
        <>
            <button onClick={handleSubmit(clickCheck)}>검증</button>
            {/* <RegisterProps register={register('name')} /> */}
            {/* <Controller
                control={control}
                name="name"
                render={({ field: { onChange, onBlur, value, ref } }) => (
                    <UseController ref={ref} value={value} onChange={onChange} />
                )}
            /> */}
            <Controller
                control={control}
                name="name"
                render={({ field: { onChange, onBlur, value, ref } }) => (
                    <TextField inputRef={ref} label="Standard" variant="standard" value={value} onChange={onChange} />
                )}
            />
            {errors.name && errors.name.message}
        </>
    );
};

export default App;
