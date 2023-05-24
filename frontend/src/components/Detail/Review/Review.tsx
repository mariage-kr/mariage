import { useState, useCallback, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';
import RateStatistic from './RateStatistic/RateStatistic';
import ReviewEditModal from './ReviewEditModal/ReviewEditModal';
import ReviewEdit from './ReviewEdit/ReviewEdit';
import NoReviews from '@/components/NoReviews/NoReviews';

import useUserInfo from '@/hooks/useUserInfo';
import { PagingType } from '@/@types/paging';
import { ReviewType } from '@/@types/review';
import { ProductContentType } from '@/@types/product';
import { getDetailReviews } from '@/apis/request/review';
import editIcon from '@/assets/png/edit.png';

import * as S from './Review.styled';

/* 무한 스크롤 참고 : https://tech.kakaoenterprise.com/149 */
function Review(productContent: ProductContentType) {
  const productId: number = Number.parseInt(useParams().id!);
  const { userInfo } = useUserInfo();

  const [reviews, setReviews] = useState<ReviewType[]>([]);
  const [page, setPage] = useState<number>(1);
  const [hasMore, setHasMore] = useState<boolean>(true);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  /* 리뷰작성 모달창 띄우는 클릭 이벤트 */
  const [isOpenModal, setOpenModal] = useState<boolean>(false);

  const onClickToggleModal = useCallback(() => {
    setOpenModal(!isOpenModal);
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

  useEffect(() => {
    fetchReview(userInfo?.id);
  }, []);

  // TODO: 무한스크롤
  useEffect(() => {
    if (hasMore && !isLoading) {
      setIsLoading(true);
      // getFetchData();
    }
  }, [hasMore, isLoading]);

  useEffect(() => {
    window.addEventListener('scroll', infiniteScroll);
    return () => window.removeEventListener('scroll', infiniteScroll);
  }, [infiniteScroll]);

  const lengthIsZero = (): boolean => {
    return reviews.length === 0;
  };

  return (
    <S.Container>
      <S.Left>
        <ReviewCategory />
        {lengthIsZero() ? (
          <NoReviews />
        ) : (
          reviews.map((review: ReviewType) => {
            return <ReviewContent key={review.id} {...review} />;
          })
        )}
      </S.Left>
      <S.Right>
        <RateStatistic />
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
              {...productContent}
              onClickToggleModal={onClickToggleModal}
            />
          </ReviewEditModal>
        )}
      </S.ReviewEdit>
    </S.Container>
  );
}

export default Review;
