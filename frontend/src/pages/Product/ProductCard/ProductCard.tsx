import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';

import foodImg from './FoodIconDummyData.json';

import * as S from './ProductCard.styled';

function ProductCard() {
  /* TODO: 임시데이터 입니다. */
  const productData = {
    id: 1,
    img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/9XYNAZN4ZB.png',
    flagImg: 'https://i.esdrop.com/d/f/CeyD9bnnT5/OT0QaqYDkx.png',
    country: 'Japan',
    name: '산토리 위스키 가쿠빈 :suntory whisky kakubin',
    abv: 40,
    reviewRate: 4.6,
    reviewCount: 1406,
  };
  return (
    <S.Container>
      <S.Image>
        <S.Img src={productData.img} />
      </S.Image>
      <S.Content>
        <S.CountryWrap>
          <S.FlagImg src={productData.flagImg} />
          <S.Country>{productData.country}</S.Country>
        </S.CountryWrap>
        <S.Name>{productData.name}</S.Name>
        <p>
          알코올 도수<S.ABV> {productData.abv}</S.ABV>%
        </p>
        <S.ABVSlide type="range" value={productData.abv} />
        <S.FoodWrap>
          {foodImg.foodIcon.map(food => (
            <S.Food>
              <S.FoodImg src={food.icon} />
              <S.FoodName>{food.name}</S.FoodName>
            </S.Food>
          ))}
        </S.FoodWrap>
      </S.Content>
      <S.StarWrap>
        <S.Star>
          <S.StarRateText>{productData.reviewRate}</S.StarRateText>
          <StarRateAverage averageReviewRate={productData.reviewRate} />
        </S.Star>
        <S.Review>
          {[productData.reviewCount]
            .toString()
            .replace(/\B(?=(\d{3})+(?!\d))/g, ',')}
          개의 리뷰
        </S.Review>
      </S.StarWrap>
    </S.Container>
  );
}

export default ProductCard;
