import { ProductFoodType, ProductsType } from '@/@types/product';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import Reviewer from '@/components/Animation/Reviewer';

import * as S from './ProductCard.styled';

function ProductCard({
  id,
  name,
  level,
  imageUrl,
  country,
  review,
  foods,
}: ProductsType) {
  const hasFood = (): boolean => {
    return foods.length > 0;
  };

  return (
    <S.Container>
      <S.Image>
        <S.Img src={imageUrl} />
      </S.Image>
      <S.Content>
        <S.Name>{name}</S.Name>
        <S.CountryWrap>
          <CountryFlagImg id={country.countryId} />
          <S.Country>{country.country}</S.Country>
        </S.CountryWrap>
        <S.p>
          알코올 도수<S.ABV> {level}</S.ABV>%
        </S.p>
        <S.ABVSlide type="range" value={level} />
        <S.FoodWrap>
          {hasFood() ? (
            foods.map((food: ProductFoodType) => (
              <S.Food key={food.id}>
                <FoodCategoryImg id={food.id} />
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
          <S.StarRateText>{review.reviewRate}</S.StarRateText>
          <SvgStarRateAverage key={id} id={id} rate={review.reviewRate} />
        </S.Star>
        <S.Review>
          {[review.reviewCount]
            .toString()
            .replace(/\B(?=(\d{3})+(?!\d))/g, ',')}
          개의 리뷰
        </S.Review>
      </S.StarWrap>
    </S.Container>
  );
}

export default ProductCard;
