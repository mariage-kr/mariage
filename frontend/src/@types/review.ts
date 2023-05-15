type ReviewResponseType = {
  reviews: ReviewType[];
  pageNumber: number;
  totalCount: number; // 해당 제품의 전체 리뷰 수
  pageSize: number;
  totalPages: number;
  isFirstPage: boolean;
  isLastPage: boolean;
};

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

export {
  ReviewResponseType,
  ReviewType,
  ReviewMemberType,
  ReviewContentType,
  ReviewLikeType,
  ReviewFoodType,
};
