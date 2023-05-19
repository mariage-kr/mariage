import { axiosWithAccessToken } from '../axios';

import { API_PATH } from 'constants/path';
import { ProductSaveType, ProductUpdateType } from 'types/product';

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

export { requestSaveProduct, requestProductInfo, requestUpdateProduct };
