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
  data: string;
  rate: number;
  content: string;
  img: string;
};

type ReviewLikeType = {
  isLiked: boolean;
  likeCount: number;
};

type ReviewFoodType = {
  name: string;
  rate: number;
  img: string;
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
