import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import editicon from '@/assets/png/edit.png';
import * as S from './RateStatistic.styled';

function RateStatistic() {
  const rateData  = 
  {
    "average": 4.7,
    "totalCount": 635,
    "rate5": 77,
    "rate4": 81,
    "rate3": 60,
    "rate2": 30,
    "rate1": 15
  }

  return (
    <S.Container>
      <S.Wrapper>
        <S.Top>
          <S.AverageRate>{rateData.average}</S.AverageRate>
          <S.StarRate><StarRateAverage averageReviewRate={rateData.average} /></S.StarRate>
          <S.TotalRate>{rateData.totalCount} Reviews</S.TotalRate>
        </S.Top>
        <S.Bottom>
          <S.RateOption>
            <S.Star><StarRateAverage averageReviewRate={5} /></S.Star>
            <S.Graph><S.TempGraph></S.TempGraph></S.Graph>
            <S.Count>{rateData.rate5}%</S.Count>
          </S.RateOption>
          <S.RateOption>
            <S.Star><StarRateAverage averageReviewRate={4} /></S.Star>
            <S.Graph><S.TempGraph></S.TempGraph></S.Graph>
            <S.Count>{rateData.rate4}%</S.Count>
          </S.RateOption>
          <S.RateOption>
            <S.Star><StarRateAverage averageReviewRate={3} /></S.Star>
            <S.Graph><S.TempGraph></S.TempGraph></S.Graph>
            <S.Count>{rateData.rate3}%</S.Count>
          </S.RateOption>
          <S.RateOption>
            <S.Star><StarRateAverage averageReviewRate={2} /></S.Star>
            <S.Graph><S.TempGraph></S.TempGraph></S.Graph>
            <S.Count>{rateData.rate2}%</S.Count>
          </S.RateOption>
          <S.RateOption>
            <S.Star><StarRateAverage averageReviewRate={1} /></S.Star>
            <S.Graph><S.TempGraph></S.TempGraph></S.Graph>
            <S.Count>{rateData.rate1}%</S.Count>
          </S.RateOption>
        </S.Bottom>
      </S.Wrapper>
      <S.EditBtn>
        <S.Edit css={S.editi}><S.EditIcon src={editicon} /></S.Edit>
        <S.Edit>리뷰 작성</S.Edit>
      </S.EditBtn>
    </S.Container>
  );
};

export default RateStatistic;