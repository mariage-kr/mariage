import { useState, useCallback } from 'react';

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

/* 무한 스크롤 참고 : https://tech.kakaoenterprise.com/149 */
function Review(productContent: ProductContentType) {
  /* 리뷰작성 모달창 띄우는 클릭 이벤트 */
  const [isOpenModal, setOpenModal] = useState<boolean>(false);

  const onClickToggleModal = useCallback(() => {
    setOpenModal(!isOpenModal);
  }, [isOpenModal]);

  const data: PagingType<ReviewType> = reviewsData;

  return (
    <S.Container>
      <S.Left>
        <ReviewCategory />
        {data.content.map((review: ReviewType) => {
          return <ReviewContent {...review} />;
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
