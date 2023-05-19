import StarRateAverage from 'components/StarRate/Average/StarRateAverage';

import * as S from './ProductCard.styled';
import { ProductRecommendType } from 'types/product';

function ProductCard({
  img,
  reviewCount,
  name,
  flagImg,
  country,
}: ProductRecommendType) {
  return (
    <S.CarouselCard>
      <S.CardContainer>
        <S.Wrapper>
          <S.Inner css={S.inner_left}>
            <S.Img alt="" src={img} />
          </S.Inner>
          <S.Inner css={S.inner_right}>
            <S.StarRate>
              <S.StarRateText>3.6</S.StarRateText>
              <StarRateAverage averageReviewRate={3.6} />
            </S.StarRate>
            <S.Review>
              <S.ReviewCount>{reviewCount}</S.ReviewCount> reviews
            </S.Review>
          </S.Inner>
        </S.Wrapper>
        <S.Bottom>
          <S.Name>{name}</S.Name>
          <S.Country css={S.country_left}>
            <S.FlagImg alt="" src={flagImg} />
          </S.Country>
          <S.Country css={S.country_right}>{country}</S.Country>
        </S.Bottom>
      </S.CardContainer>
    </S.CarouselCard>
  );
}

export default ProductCard;
