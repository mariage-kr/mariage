import { useState, useCallback,useEffect } from "react";
import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';
import RateStatistic from './RateStatistic/RateStatistic';
import ReviewEditModal from './ReviewEditModal/ReviewEditModal';
import ReviewEdit from './ReviewEdit/ReviewEdit';
import editicon from '@/assets/png/edit.png';

import * as S from './Review.styled';

type PropsType = {
	id: number;
	flagImg: string;
	country: string;
	name: string;
	level: number;
}

function Review(productData: PropsType) {

  // 리뷰작성 모달창 띄우는 클릭 이벤트
  const [isOpenModal, setOpenModal] = useState<boolean>(false);

  const onClickToggleModal = useCallback(() => {
    setOpenModal(!isOpenModal);
    // document.body.style.overflow = "hidden";
  }, [isOpenModal]);

  

  return (
    <S.Container>
      <S.Left>
        <ReviewCategory />
        <ReviewContent />
      </S.Left>
      <S.Right>
        <RateStatistic />
        <S.EditBtn onClick={onClickToggleModal}>
          <S.Edit css={S.editi}><S.EditIcon src={editicon} /></S.Edit>
          <S.Edit>리뷰 작성</S.Edit>
        </S.EditBtn>
      </S.Right>
      <S.ReviewEdit>
        {isOpenModal && (
          <ReviewEditModal onClickToggleModal={onClickToggleModal}>
            <ReviewEdit {...productData} />
          </ReviewEditModal>
        )}
      </S.ReviewEdit>
    </S.Container>
  );
}

export default Review;