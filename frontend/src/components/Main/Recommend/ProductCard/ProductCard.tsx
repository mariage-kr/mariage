import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';

import * as S from './ProductCard.styled';
import { ProductRecommendType } from '@/@types/product';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import { CountryType } from '@/@types/category';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';

function ProductCard({
  productId,
  productName,
  productImageUrl,
  reviewCount,
  reviewRate,
  country,
  countryId,
}: ProductRecommendType) {
  return (
    <S.CarouselCard>
      <S.CardContainer>
        <S.Wrapper>
          <S.Inner css={S.inner_left}>
            <S.Img alt="" src={productImageUrl} />
          </S.Inner>
          <S.Inner css={S.inner_right}>
            <S.StarRate>
              <S.StarRateText>{reviewRate}</S.StarRateText>
              <SvgStarRateAverage id={productId} rate={reviewRate} />
            </S.StarRate>
            <S.Review>
              <S.ReviewCount>{reviewCount}</S.ReviewCount> reviews
            </S.Review>
          </S.Inner>
        </S.Wrapper>
        <S.Bottom>
          <S.Name>{productName}</S.Name>
          <S.Country css={S.country_left}>
            <CountryFlagImg id={countryId} />
          </S.Country>
          <S.Country css={S.country_right}>{country}</S.Country>
        </S.Bottom>
      </S.CardContainer>
    </S.CarouselCard>
  );
}

export default ProductCard;
