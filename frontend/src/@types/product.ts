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

type ProductsType = {
  id: number;
  name: string;
  level: number;
  imageUrl: string;
  country: {
    countryId: number;
    country: string;
  };
  review: {
    reviewRate: number;
    reviewCount: number;
  };
  foods: ProductFoodType[];
};

type ProductFoodType = {
  id: number;
  name: string;
};

type ProductDetailType = {
  productId: number;
  content: {
    imageId: number;
    imageUrl: string;
    name: string;
    level: number;
    reviewRate: number;
    info: string;
    countryId: number;
    country: string;
  };
  rating: {
    reviewAverageRate: number;
    reviewCount: number;
    percentageList: {
      reviewRate: number;
      percentage: number;
    }[];
  };
  foodRateRanking: {
    foodId: number;
    category: string;
    avgFoodRate: number;
  }[];

  foodCountRanking: {
    foodId: number;
    category: string;
    reviewCount: number;
  }[];
};

export {
  ProductModifyInfoType,
  ProductSaveType,
  ProductUpdateType,
  PairingFoodType,
  ProductContentType,
  ProductInfoType,
  ProductRecommendType,
  ProductsType,
  ProductFoodType,
  ProductDetailType,
};
