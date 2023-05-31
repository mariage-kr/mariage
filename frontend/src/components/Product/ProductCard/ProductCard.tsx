import { useNavigate } from 'react-router-dom';

import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import Reviewer from '@/components/Animation/Reviewer';

import { ProductFoodType, ProductsType } from '@/@types/product';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './ProductCard.styled';
import { SORT } from '@/constants/option';

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

  const navigate = useNavigate();

  const goProduct = () => {
    navigate(`${BROWSER_PATH.DETAIL}/${id}?sort=${SORT.DETAIL.LIKE}`);
  };

  return (
    <S.Container onClick={goProduct}>
      <S.Image>
        <S.Img src={imageUrl} />
      </S.Image>
      <S.Content>
        <S.Name>{name}</S.Name>
        <S.CountryWrap>
          <S.CountryImgWrapper>
            <CountryFlagImg id={country.countryId} />
          </S.CountryImgWrapper>
          <S.Country>{country.country}</S.Country>
        </S.CountryWrap>
        <S.p>
          알코올 도수&nbsp;&nbsp;&nbsp;<S.ABV>{level}</S.ABV>%
        </S.p>
        <S.ABVSlide type="range" value={level} />
        <S.FoodWrap>
          {hasFood() ? (
            foods.map((food: ProductFoodType) => (
              <S.Food key={food.id}>
                <S.FoodImg>
                  <FoodCategoryImg id={food.id} />
                </S.FoodImg>
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
