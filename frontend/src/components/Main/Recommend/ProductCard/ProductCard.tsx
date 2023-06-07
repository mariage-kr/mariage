import { useNavigate } from 'react-router-dom';

import { ProductRecommendType } from '@/@types/product';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import { SORT } from '@/constants/option';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './ProductCard.styled';

type PropsType = {
  product: ProductRecommendType;
  option?: string;
};

function ProductCard({ product, option }: PropsType ) {
  const navigate = useNavigate();

  const goProduct = () => {
    navigate(`${BROWSER_PATH.DETAIL}/${product.productId}?sort=${SORT.DETAIL.LIKE}`);
  };

  // 상품명 마스킹
  const name =
  product.productName.length > 8 ? product.productName.substring(0, 8) + '...' : product.productName;

  return (
    <S.CarouselCard onClick={goProduct}>
      <S.CardContainer>
        <S.Wrapper>
          <S.Inner css={S.inner_left}>
            <S.Img alt="" src={product.productImageUrl} />
          </S.Inner>
          <S.Inner css={S.inner_right}>
            {option === 'algo' && <S.Recommend>추천점수</S.Recommend>}
            <S.StarRate>
              <S.StarRateText>{product.reviewRate}</S.StarRateText>
              <SvgStarRateAverage id={product.productId} rate={product.reviewRate} />
            </S.StarRate>
            <S.Review>
              <S.ReviewCount>{product.reviewCount}</S.ReviewCount> reviews
            </S.Review>
          </S.Inner>
        </S.Wrapper>
        <S.Bottom>
          <S.Name>{name}</S.Name>
          <S.Country css={S.country_left}>
            <CountryFlagImg id={product.countryId} />
          </S.Country>
          <S.Country css={S.country_right}>{product.country}</S.Country>
        </S.Bottom>
      </S.CardContainer>
    </S.CarouselCard>
  );
}

export default ProductCard;
