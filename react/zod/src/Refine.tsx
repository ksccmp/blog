import { zodResolver } from '@hookform/resolvers/zod';
import { useForm } from 'react-hook-form';
import { z } from 'zod';

interface School {
    name: string;
    address: string;
}

interface Person {
    name: string;
    age: number;
    hasSchool: boolean;
    school: School;
}

const schema = z
    .object({
        name: z.string().min(1, { message: 'person 이름은 필수값입니다.' }),
        age: z
            .number({
                invalid_type_error: 'person 나이는 필수값입니다.',
            })
            .min(1, { message: 'person 나이는 1살부터 입력이 가능합니다.' }),
        hasSchool: z.boolean(),
        school: z.object({
            name: z.string(),
            address: z.string(),
        }),
    })
    .refine((person) => (person.hasSchool ? person.school.name.length >= 1 : true), {
        message: 'school 이름은 필수값입니다.',
        path: ['school.name'],
    })
    .refine((person) => (person.hasSchool ? person.school.address.length >= 1 : true), {
        message: 'school 주소는 필수값입니다.',
        path: ['school.address'],
    });

export default function Refine() {
    const {
        register,
        formState: { errors },
        handleSubmit,
    } = useForm<Person>({
        resolver: zodResolver(schema),
        defaultValues: {
            name: '',
            age: 0,
            hasSchool: false,
            school: {
                name: '',
                address: '',
            },
        },
    });

    return (
        <form onSubmit={handleSubmit((e) => console.log(e))}>
            <h2>Refine Validation</h2>

            <div>
                <div>
                    <input type="text" placeholder="person 이름을 입력해주세요." {...register('name')} />
                    {errors.name && <p>{errors.name.message}</p>}
                </div>

                <div>
                    <input
                        type="number"
                        placeholder="person 나이를 입력해주세요."
                        {...register('age', { valueAsNumber: true })}
                    />
                    {errors.age && <p>{errors.age.message}</p>}
                </div>

                <div>
                    <label>
                        <span>school 입력 여부를 선택해주세요.</span>
                        <input type="checkbox" {...register('hasSchool')} />
                        {errors.hasSchool && <p>{errors.hasSchool.message}</p>}
                    </label>
                </div>
            </div>

            <div>
                <div>
                    <input type="text" placeholder="school 이름을 입력해주세요." {...register('school.name')} />
                    {errors.school?.name && <p>{errors.school.name.message}</p>}
                </div>

                <div>
                    <input type="text" placeholder="school 주소를 입력해주세요." {...register('school.address')} />
                    {errors.school?.address && <p>{errors.school.address.message}</p>}
                </div>
            </div>

            <button type="submit">submit</button>
        </form>
    );
}
