import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';

import * as S from './ProductContent.styled';

type DetailProductType = {
	id: number;
	img: string;
	flagImg: string;
	country: string;
	name: string;
	level: number;
	reviewRate: number;
	content: string;
}

function ProductContent({
  id, 
  img, 
  flagImg,
  country,
  name,
  level,
  reviewRate,
  content
}: DetailProductType) {

  return (
    <S.Container>
      <S.Wrapper>
        <S.Left>
          <S.Img alt="" src={img} />
        </S.Left>
        <S.Right>
          <S.Country css={S.country_left}>
            <S.FlagImg alt="" src={flagImg} />
          </S.Country>
          <S.Country css={S.country_right}>{country}</S.Country>
          <S.Name>{name}</S.Name>
          <S.ABV>ABV <S.ABVText>{level}</S.ABVText>%</S.ABV>
          <S.StarRate>
            <S.StarRateText>{reviewRate}</S.StarRateText>
          </S.StarRate>
          <S.StarRate>
            <StarRateAverage averageReviewRate={reviewRate} />
          </S.StarRate>
          <S.Content>{content}</S.Content>
        </S.Right>
      </S.Wrapper>
    </S.Container>
  );
}

export default ProductContent;