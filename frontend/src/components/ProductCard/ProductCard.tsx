import { useEffect, useState } from 'react';
import * as S from './ProductCard.styled';
import dummy from './ProductCardDummyData.json';
interface ProductCardProps {
  img: string;
  review: number;
  flagimg: string;
  country: string;
  name: string;
}

const ProductCard = ({
  img,
  review,
  flagimg,
  country,
  name,
}: ProductCardProps) => {
  return (
    <>
      {dummy.cards.map(card => (
        <S.Container>
          <S.Inner css={S.inner_left}>
            <img
              css={img}
              alt=""
              src={'../../assets/ProductCardDummyData/chamisul.png'}
            />
          </S.Inner>
          <S.Inner css={S.inner_right}>
            <S.StarRating>별점영역</S.StarRating>
            <S.Review>{card.review} reviews</S.Review>
            <S.Country css={S.country_left}>
              <img css={flagimg} alt="" src={card.flagimg} />
            </S.Country>
            <S.Country css={S.country_right}>{card.country}</S.Country>
          </S.Inner>
          <S.Bottom>{card.name}</S.Bottom>
        </S.Container>
      ))}
    </>
  );
};

export default ProductCard;
