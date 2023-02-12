import { NextApiRequest, NextApiResponse } from 'next';

const handler = async (req: NextApiRequest, res: NextApiResponse) => {
    // Check for secret to confirm this is a valid request
    if (req.query.secret !== 'revalidationTest') {
        return res.status(401).json({ message: 'Invalid token' });
    }

    if (req.method !== 'GET') {
        return res.status(405).json({ message: 'Method not allowed' });
    }

    try {
        // this should be the actual path not a rewritten path
        // e.g. for "/blog/[slug]" this should be "/blog/post-1"
        await res.revalidate(`/isr/${req.query.productNo}`);
        return res.json({ revalidated: true });
    } catch (err) {
        // If there was an error, Next.js will continue
        // to show the last successfully generated page
        return res.status(500).send('Error revalidating');
    }
};

export default handler;
