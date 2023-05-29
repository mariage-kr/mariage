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
) => {
  return axios
    .get<PagingType<ReviewType>>(`${API_PATH.REVIEW.PRODUCT}/${productId}`, {
      params: {
        pageSize: PAGING.PAGE_SIZE,
        memberId: memberId,
        pageNumber: pageNumber,
        sort: sort,
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

export { getDetailReviews, requestSaveReview };
