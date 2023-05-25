import { ProductRecommendType } from '@/@types/product';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';

import * as S from './ProductCard.styled';
import { useNavigate } from 'react-router-dom';
import { BROWSER_PATH } from '@/constants/path';

function ProductCard({
  productId,
  productName,
  productImageUrl,
  reviewCount,
  reviewRate,
  country,
  countryId,
}: ProductRecommendType) {
  const navigate = useNavigate();

  const goProduct = () => {
    navigate(`${BROWSER_PATH.DETAIL}/${productId}`);
  };

  return (
    <S.CarouselCard onClick={goProduct}>
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
