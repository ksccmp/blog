import axios from "axios";
import { useEffect, useState } from "react";

export default function App() {
  const [personNames, setPersonNames] = useState<string[]>([]);

  async function apiGetNames() {
    const res = await axios.get('/get-names');
    if(res.data) {
      setPersonNames(res.data);
    }
  }

  useEffect(() => {
    apiGetNames();
  }, [])

  return (
    <div>
      <div>
        <h2>사람들의 이름을 호출해보겠습니다 !</h2>
      </div>

      <div>
        {personNames.map((personName, index) => (
          <p key={personName}>{index+1}번째 이름은 {personName}입니다.</p>
        ))}
      </div>
    </div>
  )
}