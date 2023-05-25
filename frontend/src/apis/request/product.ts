import { axios, axiosWithAccessToken } from '../axios';

import { API_PATH } from '@/constants/path';
import {
  ProductRecommendType,
  ProductSaveType,
  ProductUpdateType,
} from '@/@types/product';
import { RECOMMEND_PRODUCT_SIZE } from '@/constants/rule';

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
    })
    .catch(error => {
      console.error(error);
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
    })
    .catch(error => {
      console.error(error);
    });
};

export {
  requestSaveProduct,
  requestProductInfo,
  requestUpdateProduct,
  requestRecommendWeather,
  requestRecommendDate,
};
