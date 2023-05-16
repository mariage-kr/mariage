import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import star5 from '@/assets/png/star5.png'
import star4 from '@/assets/png/star4.png'
import star3 from '@/assets/png/star3.png'
import star2 from '@/assets/png/star2.png'
import star1 from '@/assets/png/star1.png'

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
      img: star5
    },
    {
      id: 4,
      value: 12,
      img: star4
    },
    {
      id: 3,
      value: 1,
      img: star3
    },
    {
      id: 2,
      value: 3,
      img: star2
    },
    {
      id: 1,
      value: 15,
      img: star1
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
                <S.StarImg src={rate.img} />
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
