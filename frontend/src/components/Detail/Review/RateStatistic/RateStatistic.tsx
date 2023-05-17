import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import PercentageBar from './PercentageBar/PercentageBar';

import star from '@/assets/png/staricon.png'

import * as S from './RateStatistic.styled';

function RateStatistic() {
  const rateData = {
    average: 4.7,
    totalCount: 635,
    rate5: 77,
    rate4: 81,
    rate3: 60,
    rate2: 30,
    rate1: 15,
  };

  const rateData2 = [
    {
      id: 5,
      value: 77,
      standard: 5
    },
    {
      id: 4,
      value: 12,
      standard: 4
    },
    {
      id: 3,
      value: 1,
      standard: 3
    },
    {
      id: 2,
      value: 3,
      standard: 2
    },
    {
      id: 1,
      value: 15,
      standard: 1
    },
  ];
  return (
    <S.Container>
      <S.Wrapper>
        <S.Top>
          <S.AverageRate>{rateData.average}</S.AverageRate>
          <S.StarRate>
            <StarRateAverage
              key={'rateAverage'}
              averageReviewRate={rateData.average}
            />
          </S.StarRate>
          <S.TotalRate><S.Span>{rateData.totalCount}</S.Span> Reviews</S.TotalRate>
        </S.Top>
        <S.Bottom>
          {rateData2.map((rate: any) => (
            <S.RateOption>
              <S.Star>
                <S.StarWrapper css={S.img}><S.StarImg src={star} /></S.StarWrapper>
                <S.StarWrapper>{rate.standard}</S.StarWrapper>                
              </S.Star>
              <S.Graph>
                <S.TempGraph><PercentageBar percentage={rate.value}/></S.TempGraph>
              </S.Graph>
              <S.Count>{rate.value}%</S.Count>
            </S.RateOption>
          ))}
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default RateStatistic;
