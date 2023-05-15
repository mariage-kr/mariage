import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';

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
    },
    {
      id: 4,
      value: 12,
    },
    {
      id: 3,
      value: 1,
    },
    {
      id: 2,
      value: 3,
    },
    {
      id: 1,
      value: 15,
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
          <S.TotalRate>{rateData.totalCount} Reviews</S.TotalRate>
        </S.Top>
        <S.Bottom>
          {rateData2.map((rate: any) => (
            <S.RateOption>
              <S.Star>
                <StarRateAverage key={rate.id} averageReviewRate={rate.id} />
              </S.Star>
              <S.Graph>
                <S.TempGraph></S.TempGraph>
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
