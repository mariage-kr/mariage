import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';

import * as S from './ProductContent.styled';

function ProductContent() {
  const productData = {
    "id": 1,
    "img": "https://i.esdrop.com/d/f/CeyD9bnnT5/9XYNAZN4ZB.png",
    "flagImg": "https://i.esdrop.com/d/f/CeyD9bnnT5/OT0QaqYDkx.png",
    "country": "Japan",
    "name": "산토리 위스키 가쿠빈 :suntory whisky kakubin",
    "abv": 40,
    "reviewRate": 4.6,
    "content":"생산량 순위에서 압도적인 1위를 차지하는 일본의 가장 대중적인 위스키 중 하나로 야마자키와 하쿠슈 증류소의 몰트 위스키 원주와 자체 생산한 그레인 위스키와 배합하여 생산한다. 주로 미즈와리나 하이볼용으로 사용된다. 0000 0000 000000 00000 000000 00000000"
  }; 

  return (
    <S.Container>
      <S.Wrapper>
        <S.Left>
          <S.Img alt="" src={productData.img} />
        </S.Left>
        <S.Right>
          <S.Country css={S.country_left}>
            <S.FlagImg alt="" src={productData.flagImg} />
          </S.Country>
          <S.Country css={S.country_right}>{productData.country}</S.Country>
          <S.Name>{productData.name}</S.Name>
          <S.ABV>ABV <S.ABVText>{productData.abv}</S.ABVText>%</S.ABV>
          <S.StarRate>
            <S.StarRateText>{productData.reviewRate}</S.StarRateText>
          </S.StarRate>
          <S.StarRate>
            <StarRateAverage averageReviewRate={productData.reviewRate} />
          </S.StarRate>
          <S.Content>{productData.content}</S.Content>
        </S.Right>
      </S.Wrapper>
    </S.Container>
  );
}

export default ProductContent;