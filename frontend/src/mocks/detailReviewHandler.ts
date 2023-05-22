import { rest } from 'msw';
import { detailReviewData } from './data/detailReviewData';


const detailReviewHandler = [
  rest.get("/detailReview", async (req, res, ctx) => {
      await sleep(200);

      return res(ctx.status(200), ctx.json(detailReviewData));
  }),
  // rest.post("/detailReview", async (req, res, ctx) => {
  //     await sleep(200);
  //     detailReviewData.push({
  //         id: "345",
  //         name: "son",
  //         country: "asia",
  //         lang: "php",
  //     });

  //     return res(ctx.status(201), ctx.json(detailReviewData));
  // }),
];

async function sleep(timeout: number) {
  return new Promise((resolve) => {
      setTimeout(resolve, timeout);
  });
}

export default detailReviewHandler;