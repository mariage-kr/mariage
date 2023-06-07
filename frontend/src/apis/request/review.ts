import { axios, axiosWithAccessToken } from '../axios';

import { PagingType } from '@/@types/paging';
import {
  ReviewPageType,
  ReviewReportType,
  ReviewSaveType,
  ReviewType,
  ReviewUpdateInfoType,
  ReviewUpdateRequestType,
  ReviewUpdateResponseType,
} from '@/@types/review';

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

const requestReportReview = (reviewId: number) => {
  return axiosWithAccessToken
    .post<ReviewReportType>(`${API_PATH.REVIEW.REPORT}/${reviewId}`)
    .then(response => {
      return response.data;
    });
};

const requestWriteReview = (
  pageNumber: number,
  memberId: number,
  visitMemberId?: number,
) => {
  return axios
    .get<PagingType<ReviewPageType>>(`${API_PATH.REVIEW.MY}/${memberId}`, {
      params: {
        pageNumber,
        pageSize: PAGING.PAGE_SIZE,
        visitMemberId,
      },
    })
    .then(response => {
      return response.data;
    });
};

const requestLikeReview = (
  pageNumber: number,
  memberId: number,
  visitMemberId?: number,
) => {
  return axios
    .get<PagingType<ReviewPageType>>(`${API_PATH.REVIEW.LIKE}/${memberId}`, {
      params: {
        pageNumber,
        pageSize: PAGING.PAGE_SIZE,
        visitMemberId,
      },
    })
    .then(response => {
      return response.data;
    });
};

const requestReviewUpdateInfo = (reviewId: number) => {
  return axiosWithAccessToken
    .get<ReviewUpdateInfoType>(`${API_PATH.REVIEW.UPDATE}/${reviewId}`)
    .then(response => {
      return response.data;
    });
};

const requestUpdateReview = (request: ReviewUpdateRequestType) => {
  return axiosWithAccessToken
    .patch<ReviewUpdateResponseType>(API_PATH.REVIEW.UPDATE, request)
    .then(response => {
      return response.data;
    });
};

export {
  getDetailReviews,
  requestSaveReview,
  requestDeleteReview,
  requestReportReview,
  requestWriteReview,
  requestLikeReview,
  requestReviewUpdateInfo,
  requestUpdateReview,
};
