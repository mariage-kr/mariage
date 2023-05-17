import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';

import { PairingFoodType, ProductInfoType } from '@/@types/product';
import Reviewer from '@/components/Animation/Reviewer';

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
        <S.Name>{name}</S.Name>
        <S.CountryWrap>
          <S.FlagImg src={flagImg} />
          <S.Country>{country}</S.Country>
        </S.CountryWrap>
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
            <>
              <Reviewer />
              <S.p>당신이 첫번째 리뷰를 올려주세요!</S.p>
            </>
          )}
        </S.FoodWrap>
      </S.Content>
      <S.StarWrap>
        <S.Star>
          <S.StarRateText>{reviewRate}</S.StarRateText>
          <StarRateAverage key={id} averageReviewRate={reviewRate} />
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
