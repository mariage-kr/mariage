import { axios, axiosWithAccessToken } from '../axios';

import { PagingType } from '@/@types/paging';
import { ReviewSaveType, ReviewType } from '@/@types/review';

import { API_PATH } from '@/constants/path';
import { PAGING } from '@/constants/rule';

const getDetailReviews = (
  productId: number,
  memberId: number | null,
  pageNumber: number,
  sort: string,
  category: string | null,
  rate: number | null,
) => {
  return axios
    .get<PagingType<ReviewType>>(`${API_PATH.REVIEW.PRODUCT}/${productId}`, {
      params: {
        pageSize: PAGING.PAGE_SIZE,
        memberId,
        pageNumber,
        sort,
        category,
        rate,
      },
    })
    .then(response => {
      return response.data;
    });
};

const requestSaveReview = ({
  productId,
  productRate,
  content,
  foodRate,
  foodCategory,
  foodImageId,
  hashtags,
}: ReviewSaveType) => {
  return axiosWithAccessToken
    .post(API_PATH.REVIEW.SAVE, {
      productId,
      productRate,
      content,
      foodRate,
      foodCategory,
      foodImageId,
      hashtags,
    })
    .then(response => {
      return response.data;
    });
};

const requestDeleteReview = (reviewId: number) => {
  return axiosWithAccessToken.delete(`${API_PATH.REVIEW.DELETE}/${reviewId}`);
};

export { getDetailReviews, requestSaveReview, requestDeleteReview };
