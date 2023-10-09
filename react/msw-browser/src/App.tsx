import axios from "axios";
import { rest } from "msw";
import { useEffect, useState } from "react";
import { worker } from "./mocks/browser";

export default function App() {
  const [personNames, setPersonNames] = useState<string[]>([]);

  function mswConfig() {
    worker.use(
      // GET method인 /get-names를 해당 페이지에서만 따로 활용
      rest.get('/get-names', (req, res, ctx) => {
        const names = ['app-jimi', 'app-john', 'app-scott', 'app-queen']

        return res(
            ctx.status(200),
            ctx.json(names),
        )
      })
    )
  }

  async function apiGetNames() {
    const res = await axios.get('/get-names');
    if(res.data) {
      setPersonNames(res.data);
    }
  }

  useEffect(() => {
    mswConfig();
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