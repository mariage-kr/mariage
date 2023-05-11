import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';

import * as S from './Review.styled';

function Review() {
  return (
    <S.Container>
      <S.Left>
        <ReviewCategory />
        <ReviewContent />
      </S.Left>
      <S.Right></S.Right>
    </S.Container>
  );
}

export default Review;