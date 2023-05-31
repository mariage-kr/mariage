import { axios, axiosWithAccessToken } from '../axios';

import { API_PATH } from '@/constants/path';
import {
  ProductDetailType,
  ProductRecommendType,
  ProductSaveType,
  ProductUpdateType,
  ProductsType,
} from '@/@types/product';
import { RECOMMEND_PRODUCT_SIZE } from '@/constants/rule';
import { PagingType } from '@/@types/paging';
import { ProductFIlterParam } from '@/@types/param';
import { OPTION, SORT } from '@/constants/option';

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
  querySearch,
  queryUpperCategory,
  queryLowerCategory,
  queryMinRate,
  queryMaxRate,
  queryMinLevel,
  queryMaxLevel,
}: ProductFIlterParam) => {
  const upperCategory: string | null =
    queryUpperCategory !== 'null' ? queryUpperCategory : null;
  const lowerCategory: string | null =
    queryLowerCategory !== 'null' ? queryLowerCategory : null;
  const search: string | null = querySearch != 'null' ? querySearch : null;
  const minRate: number = Number.parseInt(queryMinRate!);
  const maxRate: number = Number.parseInt(queryMaxRate!);
  const minLevel: number = Number.parseInt(queryMinLevel!);
  const maxLevel: number = Number.parseInt(queryMaxLevel!);

  return axios
    .get<PagingType<ProductsType>>(API_PATH.PRODUCT.FILTER, {
      params: {
        pageNumber,
        pageSize,
        sort,
        search,
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

const requestProductDetailInfo = (id: string) => {
  return axios
    .get<ProductDetailType>(`${API_PATH.PRODUCT.DETAIL}/${id}`)
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
  requestProductDetailInfo,
};
