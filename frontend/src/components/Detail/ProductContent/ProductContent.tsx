import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';

import { ProductDetailType } from '@/@types/product';

import * as S from './ProductContent.styled';

function ProductContent({ content }: ProductDetailType) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.Left>{/* <S.Img src={content.imageUrl} /> */}</S.Left>
        <S.Right>
          <S.Country css={S.country_left}>
            <CountryFlagImg id={content.countryId}></CountryFlagImg>
          </S.Country>
          <S.Country css={S.country_right}>{content.country}</S.Country>
          <S.Name>{content.country}</S.Name>
          <S.ABV>
            ABV <S.ABVText>{content.level}</S.ABVText>%
          </S.ABV>
          <S.StarRate>
            <S.StarRateText>{content.reviewRate}</S.StarRateText>
          </S.StarRate>
          <S.StarRate>
            {/* TODO: 평균 별점 */}
            <StarRateAverage
              key={'averageRate'}
              averageReviewRate={content.reviewRate}
            />
          </S.StarRate>
          <S.Content>{content.info}</S.Content>
        </S.Right>
      </S.Wrapper>
    </S.Container>
  );
}

export default ProductContent;
