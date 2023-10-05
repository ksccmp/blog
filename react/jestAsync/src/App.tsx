import axios from 'axios';
import { useEffect, useState } from 'react';

interface Person {
  name: string;
  position: string;
}

export default function App() {
  const [persons, setPersons] = useState<Person[]>([]);

  async function apiGetPersons() {
    const res = await axios.get('http://localhost:8080/getPersons');
    if(res) {
      setPersons(res.data);
    }
  }

  useEffect(() => {
    apiGetPersons();
  }, [])

  return (
    <main>
      <div>
        <h2>API로부터 호출된 Person</h2>
      </div>

      <div>
        {persons.map((person) => (
          <div>
            <h4 data-testid='person-name-text'>{person.name}</h4>
            <p>{person.position}</p>
          </div>
        ))}
      </div>
    </main>
  )
}