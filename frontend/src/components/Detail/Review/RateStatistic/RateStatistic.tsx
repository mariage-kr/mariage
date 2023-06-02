import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import PercentageBar from './PercentageBar/PercentageBar';
import { ReviewRatingType } from '@/@types/product';
import star from '@/assets/png/star_icon.png';

import * as S from './RateStatistic.styled';
import { useNavigate } from 'react-router-dom';
import { BROWSER_PATH } from '@/constants/path';

type ListType = {
  reviewRate: number;
  percentage: number;
};

function RateStatistic({
  reviewAverageRate,
  reviewCount,
  percentageList,
  productId,
}: ReviewRatingType) {
  const navigate = useNavigate();
  const queryParam = new URLSearchParams(location.search);
  const sort = queryParam.get('sort');
  const selectedCategory = queryParam.get('category');

  const findReview = async (
    sortOption: string,
    selectOption?: string | null,
    rate?: string | number | null,
  ) => {
    let query = `sort=${sortOption}`;
    console.log(selectedCategory);
    if (selectOption !== null && selectOption !== 'null') {
      query += `&category=${selectOption}`;
    }
    if (rate !== undefined && rate !== null && rate !== '0' && rate !== 0) {
      query += `&rate=${rate}`;
    }
    navigate(`${BROWSER_PATH.DETAIL}/${productId}?${query}`);
    window.location.reload();
  };

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
            <S.RateOption
              key={reviewRate}
              onClick={() => findReview(sort!, selectedCategory, reviewRate)}
            >
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
