import { useState, useCallback, useEffect } from 'react';
import axios from 'axios';

import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';
import RateStatistic from './RateStatistic/RateStatistic';
import ReviewEditModal from './ReviewEditModal/ReviewEditModal';
import ReviewEdit from './ReviewEdit/ReviewEdit';

import editIcon from '@/assets/png/edit.png';
import { ReviewType } from '@/@types/review';
import { ProductContentType } from '@/@types/product';

import * as S from './Review.styled';

import reviewsData from './ReviewContent/ReviewsData.json';
import { PagingType } from '@/@types/paging';
import { API_PATH } from '@/constants/path';

/* 무한 스크롤 참고 : https://tech.kakaoenterprise.com/149 */
function Review(productContent: ProductContentType) {
  /* 무한스크롤 */
  const [result, setResult] = useState<ReviewType[]>([]);
  // const [item, setItem] = useState<ReviewType[]>([]);
  const [isLoading, setIsLoading] = useState<boolean>(true);
  const [page, setPage] = useState<number>(1);
  const [hasMore, setHasMore] = useState<boolean>(true);

  /* 리뷰작성 모달창 띄우는 클릭 이벤트 */
  const [isOpenModal, setOpenModal] = useState<boolean>(false);

  const onClickToggleModal = useCallback(() => {
    setOpenModal(!isOpenModal);
  }, [isOpenModal]);

  // const data: PagingType<ReviewType> = reviewsData;

  /* 무한스크롤 */
  const getFetchData = useCallback(async () => {
    try {
      const response = await axios.get(API_PATH.REVIEW.PRODUCT);
      const data: PagingType<ReviewType> = response.data;
      setResult(prevResult => [...prevResult, ...data.content]);
      setHasMore(data.isLastPage === false); 
      setIsLoading(false);
    } catch (error) {
      console.error('Error fetching reviews:', error);
    }  }, [page]);

  const infiniteScroll = useCallback(() => {
    if (window.innerHeight + document.documentElement.scrollTop === document.documentElement.offsetHeight) {
      setPage(prevPage => prevPage + 1);
    }
  }, []);

  useEffect(() => {
    if (hasMore && !isLoading) {
      setIsLoading(true);
      getFetchData();
    }
  }, [hasMore, isLoading, getFetchData]);

  useEffect(() => {
    window.addEventListener('scroll', infiniteScroll);
    return () => window.removeEventListener('scroll', infiniteScroll);
  }, [infiniteScroll]);


  return (
    <S.Container>
      <S.Left>
        <ReviewCategory />
        {result.map((review: ReviewType) => {
          return <ReviewContent key={review.id} {...review} />;
        })}
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
