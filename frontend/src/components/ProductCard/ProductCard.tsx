import { useEffect, useState } from 'react';
import * as S from './ProductCard.styled';
import dummy from './ProductCardDummyData.json';

interface ProductCardProps {
  img: string;
  review: string; 
  flagimg: string;
  country: string;
  name: string;
};

const ProductCard = ({ img, review, flagimg, country, name }: ProductCardProps) => {

  console.log(dummy);

  return (
    <>
    {dummy.cards.map(card => (
      <S.Container>
          <S.Inner css={S.inner_left}>
            <img css={img} src={card.img} /> 
          </S.Inner>
          <S.Inner css={S.inner_right}>
            <S.StarRating>
              별점영역
            </S.StarRating>
            <S.Review>{card.review} reviews</S.Review> 
            <S.Country css={S.country_left}><img css={flagimg} src={card.flagimg} /></S.Country>
            <S.Country css={S.country_right}>{card.country}</S.Country>
          </S.Inner>
          <S.Bottom>{card.name}</S.Bottom>
      </S.Container>
      ))}
    </>
  );
};

export default ProductCard;