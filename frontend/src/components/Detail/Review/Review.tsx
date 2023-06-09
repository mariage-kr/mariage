import { useState, useCallback, useEffect, useRef } from 'react';
import { useParams } from 'react-router-dom';

import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';
import RateStatistic from './RateStatistic/RateStatistic';
import ReviewEditModal from './ReviewEditModal/ReviewEditModal';
import ReviewEdit from './ReviewEdit/ReviewEdit';
import NoReviews from '@/components/NoReviews/NoReviews';

import editIcon from '@/assets/png/edit.png';

import { ReviewRatingType } from '@/@types/product';
import { PagingType } from '@/@types/paging';
import { ReviewType } from '@/@types/review';
import { getDetailReviews } from '@/apis/request/review';
import useIntersectionObserver from '@/hooks/useIntersectionObserver';
import useAuth from '@/hooks/useAuth';
import useUserInfo from '@/hooks/useUserInfo';
import { PAGING } from '@/constants/rule';
import useSnack from '@/hooks/useSnack';

import * as S from './Review.styled';

type PropsType = {
  id: number;
  name: string;
  level: number;
  countryId: number;
  country: string;
  rating: ReviewRatingType;
};

function Review({ id, name, level, countryId, country, rating }: PropsType) {
  const { loginSnackbar, infoSnackbar } = useSnack();
  const queryParam = new URLSearchParams(location.search);
  /* 제품 및 사용자 정보 */
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

  const onClickReviewEdit = useCallback(() => {
    if (isLogin()) {
      setOpenModal(!isOpenModal);
      return;
    }
    loginSnackbar();
  }, [isOpenModal]);

  const onClickReviewCloseEdit = () => {
    setOpenModal(!isOpenModal);
  };

  /* 리뷰 조회 */
  const fetchReview = async (userId: number | undefined) => {
    if (!hasMore) {
      infoSnackbar('리뷰가 더 이상 존재하지 않습니다.');
      return;
    }
    setLoading(true);
    const sort = await queryParam.get('sort');
    const category: string | null = await queryParam.get('category');
    const queryRate = queryParam.get('rate');
    const rate = await (queryRate === null ? 0 : Number.parseInt(queryRate));
    let memberId: number | null = null;
    if (userId !== undefined) {
      memberId = userId;
    }

    await getDetailReviews(
      productId,
      memberId,
      pageNumber,
      sort!,
      category,
      rate,
    )
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
  };

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
        <ReviewCategory productId={productId} />
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
        <RateStatistic {...rating} productId={productId} />
        <S.EditBtn onClick={onClickReviewEdit}>
          <S.Edit css={S.EditSize}>
            <S.EditIcon src={editIcon} />
          </S.Edit>
          <S.Edit>리뷰 작성</S.Edit>
        </S.EditBtn>
      </S.Right>
      <S.ReviewEdit>
        {isOpenModal && (
          <ReviewEditModal onClickReviewEdit={onClickReviewEdit}>
            <ReviewEdit
              id={id}
              name={name}
              level={level}
              country={country}
              countryId={countryId}
              onClickReviewCloseEdit={onClickReviewCloseEdit}
            />
          </ReviewEditModal>
        )}
      </S.ReviewEdit>
    </S.Container>
  );
}

export default Review;
