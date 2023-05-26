import { axios, axiosWithAccessToken } from '../axios';

import { API_PATH } from '@/constants/path';
import {
  ProductRecommendType,
  ProductSaveType,
  ProductUpdateType,
  ProductsType,
} from '@/@types/product';
import { PAGING, RECOMMEND_PRODUCT_SIZE } from '@/constants/rule';
import { PagingType } from '@/@types/paging';
import { ProductFIlterParam } from '@/@types/param';

const requestSaveProduct = (productData: ProductSaveType) => {
  return axiosWithAccessToken.post(API_PATH.PRODUCT.SAVE, {
    ...productData,
  });
};

const requestProductInfo = async (productId: number) => {
  return axiosWithAccessToken.get(API_PATH.PRODUCT.INFO, {
    params: { productId: productId },
  });
};

const requestUpdateProduct = async (productData: ProductUpdateType) => {
  return axiosWithAccessToken.patch(API_PATH.PRODUCT.UPDATE, {
    ...productData,
  });
};

const requestRecommendDate = (option: string) => {
  return axios
    .get<ProductRecommendType[]>(API_PATH.PRODUCT.RECOMMEND.DATE, {
      params: {
        size: RECOMMEND_PRODUCT_SIZE,
        option,
      },
    })
    .then(response => {
      return response.data;
    });
};

const requestRecommendWeather = () => {
  return axios
    .get<ProductRecommendType[]>(API_PATH.PRODUCT.RECOMMEND.WEATHER, {
      params: {
        size: RECOMMEND_PRODUCT_SIZE,
      },
    })
    .then(response => {
      return response.data;
    });
};

const requestProducts = ({
  pageSize,
  pageNumber,
  sort,
  upperCategory,
  lowerCategory,
  minRate,
  maxRate,
  minLevel,
  maxLevel,
}: ProductFIlterParam) => {
  return axios
    .get<PagingType<ProductsType>>(API_PATH.PRODUCT.FILTER, {
      params: {
        pageNumber,
        pageSize,
        sort,
        upperCategory,
        lowerCategory,
        minRate,
        maxRate,
        minLevel,
        maxLevel,
      },
    })
    .then(response => {
      return response.data;
    });
};

export {
  requestSaveProduct,
  requestProductInfo,
  requestUpdateProduct,
  requestRecommendWeather,
  requestRecommendDate,
  requestProducts,
};
