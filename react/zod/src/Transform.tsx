import { zodResolver } from '@hookform/resolvers/zod';
import { useForm } from 'react-hook-form';
import { z } from 'zod';

interface Person {
    name: string;
    address: string;
    age: number;
}

const schema = z.object({
    name: z.string().min(1, { message: '이름은 필수값입니다.' }),
    address: z
        .string()
        .transform((address) => address.replace('서울시', ''))
        .refine((address) => address.length >= 1, {
            message: '주소는 필수값입니다.',
        }),
    age: z
        .number({
            invalid_type_error: '나이는 필수값입니다.',
        })
        .min(1, { message: '나이는 1살부터 입력이 가능합니다.' }),
});

export default function Transform() {
    const {
        register,
        formState: { errors },
        handleSubmit,
    } = useForm<Person>({
        resolver: zodResolver(schema),
        defaultValues: {
            name: '',
            address: '',
            age: 0,
        },
    });

    return (
        <form onSubmit={handleSubmit((e) => console.log(e))}>
            <h2>Tramform Validation</h2>

            <div>
                <div>
                    <input type="text" placeholder="이름을 입력해주세요." {...register('name')} />
                    {errors.name && <p>{errors.name.message}</p>}
                </div>

                <div>
                    <input type="text" placeholder="주소를 입력해주세요." {...register('address')} />
                    {errors.address && <p>{errors.address.message}</p>}
                </div>

                <div>
                    <input
                        type="number"
                        placeholder="나이를 입력해주세요."
                        {...register('age', { valueAsNumber: true })}
                    />
                    {errors.age && <p>{errors.age.message}</p>}
                </div>
            </div>

            <button type="submit">submit</button>
        </form>
    );
}
