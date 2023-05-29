import { useState, useCallback, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';
import RateStatistic from './RateStatistic/RateStatistic';
import ReviewEditModal from './ReviewEditModal/ReviewEditModal';
import ReviewEdit from './ReviewEdit/ReviewEdit';
import NoReviews from '@/components/NoReviews/NoReviews';

import { FoodCategoryResponseType } from '@/@types/category';
import { ReviewRatingType } from '@/@types/product';
import { PagingType } from '@/@types/paging';
import { ReviewType } from '@/@types/review';
import { getDetailReviews } from '@/apis/request/review';
import { requestFoodCategory } from '@/apis/request/category';
import useAuth from '@/hooks/useAuth';
import useUserInfo from '@/hooks/useUserInfo';
import editIcon from '@/assets/png/edit.png';

import * as S from './Review.styled';

type PropsType = {
  id: number;
  name: string;
  level: number;
  countryId: number;
  country: string;
  rating: ReviewRatingType;
};

/* 무한 스크롤 참고 : https://tech.kakaoenterprise.com/149 */
function Review({ id, name, level, countryId, country, rating }: PropsType) {
  const productId: number = Number.parseInt(useParams().id!);
  const { userInfo } = useUserInfo();
  const { isLogin } = useAuth();

  const [reviews, setReviews] = useState<ReviewType[]>([]);
  const [page, setPage] = useState<number>(1);
  const [hasMore, setHasMore] = useState<boolean>(true);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  /* 리뷰작성 모달창 띄우는 클릭 이벤트 */
  const [isOpenModal, setOpenModal] = useState<boolean>(false);

  const onClickToggleModal = useCallback(() => {
    if (isLogin()) {
      setOpenModal(!isOpenModal);
    }
  }, [isOpenModal]);

  const fetchReview = useCallback(async (userId: number | undefined) => {
    let memberId: number | null = null;

    if (userId !== undefined) {
      memberId = userId;
    }

    await getDetailReviews(productId, memberId, page, 'liked')
      .then((fetchReviews: PagingType<ReviewType>) => {
        setReviews(prevReviews => [...prevReviews, ...fetchReviews.contents]);
        setHasMore(fetchReviews.lastPage === false);
      })
      .catch(error => {
        console.error(error);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, []);

  const infiniteScroll = useCallback(() => {
    if (
      window.innerHeight + document.documentElement.scrollTop ===
      document.documentElement.offsetHeight
    ) {
      setPage(prevPage => prevPage + 1);
    }
  }, []);

  // TODO: 무한스크롤
  useEffect(() => {
    if (hasMore && !isLoading) {
      setIsLoading(true);
    }
  }, [hasMore, isLoading]);

  useEffect(() => {
    window.addEventListener('scroll', infiniteScroll);
    return () => window.removeEventListener('scroll', infiniteScroll);
  }, [infiniteScroll]);

  const lengthIsZero = (): boolean => {
    return reviews.length === 0;
  };

  /* 음식 카테고리 */
  const [foodCategory, setFoodCategory] = useState<FoodCategoryResponseType>({
    category: [],
    length: 0,
  });

  /* TODO: 추후 Recoil + ReactQuery 로 전환 */
  const fetchFoodCategory = () => {
    setIsLoading(true);
    requestFoodCategory()
      .then(data => {
        setFoodCategory(data);
      })
      .finally(() => {
        setIsLoading(false);
      });
  };

  useEffect(() => {
    fetchReview(userInfo?.id);
    fetchFoodCategory();
  }, []);

  return (
    <S.Container>
      <S.Left>
        <ReviewCategory {...foodCategory} />
        {lengthIsZero() ? (
          <NoReviews />
        ) : (
          reviews.map((review: ReviewType) => {
            return <ReviewContent key={review.id} {...review} />;
          })
        )}
      </S.Left>
      <S.Right>
        <RateStatistic {...rating} />
        <S.EditBtn onClick={onClickToggleModal}>
          <S.Edit css={S.EditSize}>
            <S.EditIcon src={editIcon} />
          </S.Edit>
          <S.Edit>리뷰 작성</S.Edit>
        </S.EditBtn>
      </S.Right>
      <S.ReviewEdit>
        {isOpenModal && (
          <ReviewEditModal onClickToggleModal={onClickToggleModal}>
            <ReviewEdit
              id={id}
              name={name}
              level={level}
              country={country}
              countryId={countryId}
              onClickToggleModal={onClickToggleModal}
              category={foodCategory.category}
            />
          </ReviewEditModal>
        )}
      </S.ReviewEdit>
    </S.Container>
  );
}

export default Review;
