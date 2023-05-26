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
  content: ProductContentType;
  rating: ReviewRatingType;
  foodRateRanking: PairingFoodType[];
  foodCountRanking: PairingFoodType[];
};

type ReviewRatingType = {
  reviewAverageRate: number;
  reviewCount: number;
  percentageList: {
    reviewRate: number;
    percentage: number;
  }[];
};

type ProductContentType = {
  imageUrl: string;
  name: string;
  level: number;
  reviewRate: number;
  info: string;
  countryId: number;
  country: string;
};

type PairingFoodType = {
  foodId: number;
  category: string;
  avgFoodRate: number;
  reviewCount: number;
};

export {
  ProductModifyInfoType,
  ProductSaveType,
  ProductUpdateType,
  PairingFoodType,
  ProductRecommendType,
  ProductsType,
  ProductFoodType,
  ReviewRatingType,
  ProductDetailType,
  ProductContentType,
};
