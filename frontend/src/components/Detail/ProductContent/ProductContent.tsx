import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';

import { ProductContentType } from '@/@types/product';

import * as S from './ProductContent.styled';

function ProductContent({
  imageUrl,
  name,
  level,
  reviewRate,
  info,
  countryId,
  country,
}: ProductContentType) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.Left>
          <S.Img src={imageUrl} />
        </S.Left>
        <S.Right>
          <S.Country css={S.country_left}>
            <CountryFlagImg id={countryId}></CountryFlagImg>
          </S.Country>
          <S.Country css={S.country_right}>{country}</S.Country>
          <S.Name>{name}</S.Name>
          <S.ABV>
            ABV <S.ABVText>{level}</S.ABVText>%
          </S.ABV>
          <S.StarRate>
            <S.StarRateText>{reviewRate}</S.StarRateText>
          </S.StarRate>
          <S.StarRate>
            <StarRateAverage
              key={'averageRate'}
              averageReviewRate={reviewRate}
            />
          </S.StarRate>
          <S.Content>{info}</S.Content>
        </S.Right>
      </S.Wrapper>
    </S.Container>
  );
}

export default ProductContent;
