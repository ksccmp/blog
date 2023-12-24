import { zodResolver } from '@hookform/resolvers/zod';
import { useFieldArray, useForm } from 'react-hook-form';
import { z } from 'zod';

interface Person {
    name: string;
    address: string;
    age: number;
}

interface UseForm {
    persons: Person[];
}

const schema = z.object({
    persons: z.array(
        z.object({
            name: z.string().min(1, { message: '이름은 필수값입니다.' }),
            address: z.string().min(1, { message: '주소는 필수값입니다.' }),
            age: z
                .number({
                    invalid_type_error: '나이는 필수값입니다.',
                })
                .min(1, { message: '나이는 1살부터 입력이 가능합니다.' }),
        }),
    ),
});

export default function Array() {
    const {
        register,
        formState: { errors },
        handleSubmit,
        control,
    } = useForm<UseForm>({
        resolver: zodResolver(schema),
        defaultValues: {
            persons: [],
        },
    });

    const { fields, append } = useFieldArray({
        control,
        name: 'persons',
    });

    return (
        <form onSubmit={handleSubmit((e) => console.log(e))}>
            <h2>Array Validation</h2>

            <div>
                {fields.map((_person, index) => (
                    <div key={index}>
                        <div>
                            <input
                                type="text"
                                placeholder="이름을 입력해주세요."
                                {...register(`persons.${index}.name`)}
                            />
                            {errors.persons?.[index]?.name && <p>{errors.persons?.[index]?.name?.message}</p>}
                        </div>

                        <div>
                            <input
                                type="text"
                                placeholder="주소를 입력해주세요."
                                {...register(`persons.${index}.address`)}
                            />
                            {errors.persons?.[index]?.address && <p>{errors.persons?.[index]?.address?.message}</p>}
                        </div>

                        <div>
                            <input
                                type="number"
                                placeholder="나이를 입력해주세요."
                                {...register(`persons.${index}.age`, { valueAsNumber: true })}
                            />
                            {errors.persons?.[index]?.age && <p>{errors.persons?.[index]?.age?.message}</p>}
                        </div>
                    </div>
                ))}
            </div>

            <button
                onClick={() =>
                    append({
                        name: '',
                        address: '',
                        age: 0,
                    })
                }
            >
                add
            </button>
            <button type="submit">submit</button>
        </form>
    );
}
