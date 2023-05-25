type ProductSaveType = {
  name: string;
  level: number;
  info: string;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
};

type ProductModifyInfoType = {
  name: string;
  info: string;
  level: number;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
  imageUrl: string;
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

type ProductInfoType = {
  id: number;
  img: string;
  flagImg: string;
  country: string;
  name: string;
  level: number;
  reviewRate: number;
  reviewCount: number;
  food: PairingFoodType[];
};

type ProductRecommendType = {
  productId: number;
  productName: string;
  productImageUrl: string;
  reviewCount: number;
  reviewRate: number;
  country: string;
  countryId: number;
};

export {
  ProductModifyInfoType,
  ProductSaveType,
  ProductUpdateType,
  PairingFoodType,
  ProductContentType,
  ProductInfoType,
  ProductRecommendType,
};
