import { LikedCountType } from '@/@types/liked';
import { axiosWithAccessToken } from '../axios';

import { API_PATH } from '@/constants/path';

const requestAddLike = (reviewId: any) => {
  return axiosWithAccessToken
    .post<LikedCountType>(API_PATH.LIKE, {
      reviewId,
    })
    .then(response => {
      return response.data;
    });
};

const requestRemoveLike = (reviewId: any) => {
  return axiosWithAccessToken
    .delete<LikedCountType>(API_PATH.LIKE, {
      params: {
        reviewId,
      },
    })
    .then(response => {
      return response.data;
    });
};

export { requestAddLike, requestRemoveLike };
