import * as S from './NoReviews.styled';

// import NoReview from '@/components/Animation/NoReviews';
import { ReactComponent as NoReview } from '@/assets/svg/no-reviews.svg';

function NoReviews() {
  return (
    <S.Container>
      <NoReview />
      <S.TextWrap>
        <p>리뷰가 텅 비었어요</p>
      </S.TextWrap>
    </S.Container>
  );
}

export default NoReviews;
