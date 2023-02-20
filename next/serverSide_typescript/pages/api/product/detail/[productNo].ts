// /pages/api/product/detail/[productNo].ts

import { NextApiRequest, NextApiResponse } from 'next';

const handler = async (req: NextApiRequest, res: NextApiResponse) => {
    try {
        await res.revalidate(`/isr/${req.query.productNo}`); // /isr/{productNo}에 해당되는 페이지에 revalidate 트리거 적용
        return res.json({ revalidated: true });
    } catch (err) {
        return res.status(500).send('Error revalidating');
    }
};

export default handler;
