import { useState } from 'react';
import Carousel from 'react-simply-carousel';

import ProductCard from '../ProductCard/ProductCard';

import * as S from './ProductCardCarousel.styled';

import dummy from './ProductCardDummyData.json';

const ProductCardCarousel = () => {
  const [activeSlideIndex, setActiveSlideIndex] = useState(0);

  return (
    <S.Container>
      <Carousel
        activeSlideIndex={activeSlideIndex}
        onRequestChange={setActiveSlideIndex}
        itemsToShow={4}
        itemsToScroll={1}
        autoplay={true}
        autoplayDelay={2000}
        forwardBtnProps={{
          style: {
            alignSelf: 'center',
            background: 'none',
            border: 'none',
            borderRadius: '50%',
            color: '#9C94D0',
            cursor: 'pointer',
            fontSize: '2vw',
            width: 50,
            height: 50,
            lineHeight: 1,
            textAlign: 'center',
          },
          children: <span>{`>`}</span>,
        }}
        backwardBtnProps={{
          style: {
            alignSelf: 'center',
            background: 'none',
            border: 'none',
            borderRadius: '50%',
            color: '#9C94D0',
            cursor: 'pointer',
            fontSize: '2vw',
            width: 50,
            height: 50,
            lineHeight: 1,
            textAlign: 'center',
          },
          children: <span>{`<`}</span>,
        }}
        responsiveProps={[
          {
            itemsToShow: 4,
            itemsToScroll: 2,
            minWidth: 768,
          },
        ]}
        speed={400}
        easing="linear"
      >
        {dummy.cards.map(card => {
          return <ProductCard card={card} />;
        })}
      </Carousel>
    </S.Container>
  );
};

export default ProductCardCarousel;
