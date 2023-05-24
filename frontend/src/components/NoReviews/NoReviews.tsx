import * as S from './NoReviews.styled';

import NoReview from '@/components/Animation/NoReviews';

function NoReviews() {
  return (
    <S.Container>
      <NoReview />
      <S.TextWrap>
        <p>아직 아무도 리뷰를 남기지 않았어요!</p>
      </S.TextWrap>
    </S.Container>
  );
}

export default NoReviews;
