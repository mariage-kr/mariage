import ReviewCategory from './ReviewCategory/ReviewCategory';
import ReviewContent from './ReviewContent/ReviewContent';
import RateStatistic from './RateStatistic/RateStatistic'

import * as S from './Review.styled';

function Review() {
  return (
    <S.Container>
      <S.Left>
        <ReviewCategory />
        <ReviewContent />
      </S.Left>
      <S.Right>
        <RateStatistic />
      </S.Right>
    </S.Container>
  );
}

export default Review;