import StarRateAverage from 'components/StarRate/Average/StarRateAverage';

import { ProductContentType } from 'types/product';

import * as S from './ProductContent.styled';

function ProductContent({
  id,
  img,
  flagImg,
  country,
  name,
  level,
  reviewRate,
  content,
}: ProductContentType) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.Left>
          <S.Img src={img} />
        </S.Left>
        <S.Right>
          <S.Country css={S.country_left}>
            <S.FlagImg src={flagImg} />
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
            {/* TODO: 평균 별점 */}
            <StarRateAverage
              key={'averageRate'}
              averageReviewRate={reviewRate}
            />
          </S.StarRate>
          <S.Content>{content}</S.Content>
        </S.Right>
      </S.Wrapper>
    </S.Container>
  );
}

export default ProductContent;
