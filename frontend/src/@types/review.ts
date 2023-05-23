type ReviewType = {
  id: number;
  member: ReviewMemberType;
  content: ReviewContentType;
  like: ReviewLikeType;
  food: ReviewFoodType;
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

type ReviewSaveType = {
  productId: number;
  productRate: number;
  content: string;
  foodRate: number;
  foodCategory: string;
  foodImageId: number;
  hashtags: string[];
};

export {
  ReviewType,
  ReviewMemberType,
  ReviewContentType,
  ReviewLikeType,
  ReviewFoodType,
  ReviewSaveType,
};
