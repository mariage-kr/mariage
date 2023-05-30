import { useState, useCallback, useEffect, useRef } from 'react';
import { useParams } from 'react-router-dom';

import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';
import RateStatistic from './RateStatistic/RateStatistic';
import ReviewEditModal from './ReviewEditModal/ReviewEditModal';
import ReviewEdit from './ReviewEdit/ReviewEdit';
import NoReviews from '@/components/NoReviews/NoReviews';

import { ReviewRatingType } from '@/@types/product';
import { PagingType } from '@/@types/paging';
import { ReviewType } from '@/@types/review';
import { getDetailReviews } from '@/apis/request/review';
import editIcon from '@/assets/png/edit.png';
import useAuth from '@/hooks/useAuth';
import useUserInfo from '@/hooks/useUserInfo';
import useFoodCategory from '@/hooks/useFoodCategory';

import * as S from './Review.styled';
import useIntersectionObserver from '@/hooks/useIntersectionObserver';
import Loading from '@/components/Loading/Loading';
import { PAGING } from '@/constants/rule';

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
  /* 제품 및 사용자 정보 */
  // const { foodCategory, setFoodCategory } = useFoodCategory();
  const productId: number = Number.parseInt(useParams().id!);
  const { userInfo } = useUserInfo();
  const { isLogin } = useAuth();

  /* 무한스크롤 정보 */
  const [reviews, setReviews] = useState<PagingType<ReviewType>>({
    contents: [],
    pageNumber: 1,
    totalCount: 0,
    totalPages: 0,
    pageSize: PAGING.PAGE_SIZE,
    firstPage: true,
    lastPage: false,
  });
  const [pageNumber, setPageNumber] = useState<number>(1);
  const [hasMore, setHasMore] = useState<boolean>(true);
  const [loading, setLoading] = useState<boolean>(true);

  /* 리뷰작성 모달창 띄우는 클릭 이벤트 */
  const [isOpenModal, setOpenModal] = useState<boolean>(false);

  const onClickToggleModal = useCallback(() => {
    if (isLogin()) {
      setOpenModal(!isOpenModal);
    }
  }, [isOpenModal]);

  /* 리뷰 조회 */
  const fetchReview = useCallback(async (userId: number | undefined) => {
    if (!hasMore) {
      return;
    }
    let memberId: number | null = null;

    if (userId !== undefined) {
      memberId = userId;
    }

    await getDetailReviews(productId, memberId, pageNumber, 'liked')
      .then((fetchReviews: PagingType<ReviewType>) => {
        setReviews(prev => ({
          ...fetchReviews,
          contents: [...prev.contents, ...fetchReviews.contents],
        }));
        setHasMore(fetchReviews.lastPage === false);
      })
      .catch(error => {
        console.error(error);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  const lengthIsZero = (): boolean => {
    return reviews.totalCount === 0;
  };

  const target = useRef(null);

  const [observe, unobserve] = useIntersectionObserver(() => {
    setPageNumber(prev => prev + 1);
  });

  useEffect(() => {
    if (loading) {
      unobserve(target.current);
    } else {
      observe(target.current);
    }
  }, [loading]);

  useEffect(() => {
    fetchReview(userInfo?.id);
  }, [pageNumber]);

  return (
    <S.Container>
      <S.Left>
        <ReviewCategory />
        {lengthIsZero() ? (
          <NoReviews />
        ) : (
          reviews.contents.map((review: ReviewType) => {
            return <ReviewContent key={review.id} {...review} />;
          })
        )}
        <S.Target ref={target} />
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
            />
          </ReviewEditModal>
        )}
      </S.ReviewEdit>
    </S.Container>
  );
}

export default Review;
