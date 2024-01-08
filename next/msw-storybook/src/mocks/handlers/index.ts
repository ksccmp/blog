import { personHandlers } from './person-handler';

// 여러 handler를 한 곳에 묶어서 return
export const handlers = [...personHandlers];
