import { axios } from '../axios';

import { PagingType } from '@/@types/paging';
import { ReviewType } from '@/@types/review';

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

export { getDetailReviews };
