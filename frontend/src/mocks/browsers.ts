import { setupWorker } from 'msw';
import detailReviewHandler from './detailReviewHandler';

const worker = setupWorker(...detailReviewHandler);

export default worker;
