type ProductInfoType = {
  name: string;
  info: string;
  level: number;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
  imageUrl: string;
};

type ProductSaveType = {
  name: string;
  level: number;
  info: string;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
};

type ProductUpdateType = {
  id: number;
  name: string;
  level: number;
  info: string;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
  newImageId: number;
};

type PairingFoodType = {
  id: number;
  img: string;
  name: string;
  rate: number;
};

type ProductContentType = {
  id: number;
  img: string;
  flagImg: string;
  country: string;
  name: string;
  level: number;
  reviewRate: number;
  content: string;
};

export {
  ProductInfoType,
  ProductSaveType,
  ProductUpdateType,
  PairingFoodType,
  ProductContentType,
};
