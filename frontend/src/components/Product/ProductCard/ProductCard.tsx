import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';

import { PairingFoodType, ProductInfoType } from '@/@types/product';

import * as S from './ProductCard.styled';

function ProductCard({
  id,
  img,
  flagImg,
  country,
  name,
  level,
  reviewRate,
  reviewCount,
  food,
}: ProductInfoType) {
  const hasFood = (): boolean => {
    return food.length > 0;
  };

  return (
    <S.Container>
      <S.Image>
        <S.Img src={img} />
      </S.Image>
      <S.Content>
        <S.CountryWrap>
          <S.FlagImg src={flagImg} />
          <S.Country>{country}</S.Country>
        </S.CountryWrap>
        <S.Name>{name}</S.Name>
        <p>
          알코올 도수<S.ABV> {level}</S.ABV>%
        </p>
        <S.ABVSlide type="range" value={level} />
        <S.FoodWrap>
          {hasFood() ? (
            food.map((food: PairingFoodType) => (
              <S.Food key={food.id}>
                <S.FoodImg src={food.img} />
                <S.FoodName>{food.name}</S.FoodName>
              </S.Food>
            ))
          ) : (
            <p>아무것도 없을 때</p>
          )}
        </S.FoodWrap>
      </S.Content>
      <S.StarWrap>
        <S.Star>
          <S.StarRateText>{reviewRate}</S.StarRateText>
          <SvgStarRateAverage key={id} id={id} rate={reviewRate} />
        </S.Star>
        <S.Review>
          {[reviewCount].toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')}
          개의 리뷰
        </S.Review>
      </S.StarWrap>
    </S.Container>
  );
}

export default ProductCard;
