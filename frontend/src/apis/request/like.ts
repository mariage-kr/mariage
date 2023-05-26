import { axiosWithAccessToken } from '../axios';

import { API_PATH } from '@/constants/path';

const requestAddLike = (reviewId: any) => {
  return axiosWithAccessToken.post(API_PATH.LIKE, {
    reviewId,
  });
};

const requestRemoveLike = (reviewId: any) => {
  return axiosWithAccessToken.delete(API_PATH.LIKE, {
    params: {
      reviewId,
    },
  });
};

export { requestAddLike, requestRemoveLike };
