import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import PercentageBar from './PercentageBar/PercentageBar';
import { ReviewRatingType } from '@/@types/product';
import star from '@/assets/png/staricon.png';

import * as S from './RateStatistic.styled';

type ListType = {
  reviewRate: number;
  percentage: number;
};

function RateStatistic({
  reviewAverageRate,
  reviewCount,
  percentageList,
}: ReviewRatingType) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.Top>
          <S.AverageRate>{reviewAverageRate}</S.AverageRate>
          <S.StarRate>
            <StarRateAverage
              key={'rateAverage'}
              averageReviewRate={reviewAverageRate}
            />
          </S.StarRate>
          <S.TotalRate>
            <S.Span>{reviewCount}</S.Span> Reviews
          </S.TotalRate>
        </S.Top>
        <S.Bottom>
          {percentageList.map(({ reviewRate, percentage }: ListType) => (
            <S.RateOption>
              <S.Star>
                <S.StarWrapper css={S.img}>
                  <S.StarImg src={star} />
                </S.StarWrapper>
                <S.StarWrapper>{reviewRate}</S.StarWrapper>
              </S.Star>
              <S.Graph>
                <S.TempGraph>
                  <PercentageBar percentage={percentage} />
                </S.TempGraph>
              </S.Graph>
              <S.Count>{percentage}%</S.Count>
            </S.RateOption>
          ))}
          <S.InfoClickStar>
            별점 아이콘을 클릭하면
            <br />
            해당 별점의 리뷰를 확인하실 수 있습니다.
          </S.InfoClickStar>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default RateStatistic;
