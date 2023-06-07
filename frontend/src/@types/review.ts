type ReviewType = {
  id: number;
  member: ReviewMemberType;
  review: ReviewContentType;
  like: ReviewLikeType;
  food: ReviewFoodType;
  hashtags: string[];
};

type ReviewMemberType = {
  id: number;
  nickname: string;
  img: string;
};

type ReviewContentType = {
  date: string;
  rate: number;
  content: string;
  img: string;
  weather: string;
};

type ReviewLikeType = {
  liked: boolean;
  count: number;
};

type ReviewFoodType = {
  id: number;
  name: string;
  rate: number;
};

/**
 * @property {number} productId: 제품의 식별자
 * @property {number} productRate: 제품의 평가 점수
 * @property {string} content: 제품의 리뷰
 * @property {number} foodRate(Optional): 궁합 안주의 평가 점수
 * @property {string} foodCategory(Optional) : 궁합 안주의 종류
 * @property {number} foodImageId(Optional) : 리뷰 사진
 * @property {string[]} hashtags(Optional) : 해시 태그
 */
type ReviewSaveType = {
  productId: number;
  productRate: number;
  content: string;
  foodRate: number | null;
  foodCategory: string | null;
  foodImageId: number | null;
  hashtags: string[] | null;
};

type ReviewReportType = {
  report: boolean;
};

type reviewProfileType = {
  nickname: string;
  email: string;
  imagePath: string;
  reviews: number;
  likes: number;
};

type ReviewPageType = {
  productInfo: ReviewProductInfo;
  reviewInfo: ReviewInfoType;
};

type ReviewProductInfo = {
  id: number;
  imageUrl: string;
  name: string;
  level: number;
  reviewRate: number;
  info: string;
  countryId: number;
  country: string;
};

type ReviewInfoType = {
  id: number;
  member: {
    id: number;
    nickname: string;
    img: string;
  };
  review: {
    date: string;
    rate: number;
    content: string;
    img: string | null;
  };
  like: {
    count: number;
    liked: boolean;
  };
  food: {
    id: number;
    name: string;
    rate: number;
  };
  hashtags: string[];
};

type ReviewUpdateInfoType = {
  productName: string;
  productLevel: number;
  countryName: string;
  countryId: number;
  reviewProductRate: number;
  reviewContent: string;
  foodCategoryId?: number;
  foodCategoryName?: string;
  foodCategoryValue?: string;
  foodCategoryRate?: number;
  imageUrl?: string;
  hashtags?: string[];
};

type ReviewUpdateRequestType = {
  reviewId: number;
  productRate: number;
  content: string;
  foodRate: number | null;
  foodCategory: string | null;
  newImageId: number | null;
  hashtags: string[] | null;
};

type ReviewUpdateResponseType = {
  reviewId: number;
  productRate: number;
  content: string;
  foodRate: number | null;
  foodCategory: string | null;
  imagePath: string | null;
  hashtags: string[] | null;
};

export {
  ReviewType,
  ReviewMemberType,
  ReviewContentType,
  ReviewLikeType,
  ReviewFoodType,
  ReviewSaveType,
  ReviewReportType,
  reviewProfileType,
  ReviewPageType,
  ReviewProductInfo,
  ReviewInfoType,
  ReviewUpdateInfoType,
  ReviewUpdateRequestType,
  ReviewUpdateResponseType,
};
