import { API_PATH } from '@/constants/path';
import { axiosWithAccessToken } from '../axios';
import { ProductSaveType } from '@/types/product';

const requestSaveProduct = ({
  name,
  level,
  info,
  country,
  upperCategory,
  lowerCategory,
  imageId,
}: ProductSaveType) => {
  return axiosWithAccessToken.post(API_PATH.PRODUCT.SAVE, {
    name,
    level,
    info,
    country,
    upperCategory,
    lowerCategory,
    imageId,
  });
};

const requestProductInfo = async (productId: string) => {
  return axiosWithAccessToken.get(API_PATH.PRODUCT.INFO, {
    params: { productId: productId },
  });
};

export { requestSaveProduct, requestProductInfo };
