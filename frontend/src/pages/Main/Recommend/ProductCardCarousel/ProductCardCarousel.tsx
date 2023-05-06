import { useState } from 'react';
import Carousel from 'react-simply-carousel';

import ProductCard from '../ProductCard/ProductCard';

import * as S from './ProductCardCarousel.styled';

import dummy from './ProductCardDummyData.json';
import ChevronRight from '@/components/Button/Chevron/ChevronRight';
import ChevronLeft from '@/components/Button/Chevron/ChevronLeft';

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
        autoplayDelay={5000}
        forwardBtnProps={{
          style: {
            alignSelf: 'center',
            width: 50,
            height: 50,
            background: 'none',
            marginLeft: 15,
          },
          children: <ChevronRight />,
          // style: {
          //   alignSelf: 'center',
          //   background: 'none',
          //   border: 'none',
          //   borderRadius: '50%',
          //   color: '#9C94D0',
          //   cursor: 'pointer',
          //   fontSize: '2rem',
          //   width: 50,
          //   height: 50,
          //   lineHeight: 1,
          //   textAlign: 'center',
          // },
          // children: <span>{`>`}</span>,
        }}
        backwardBtnProps={{
          style: {
            alignSelf: 'center',
            width: 50,
            height: 50,
            background: 'none',
            marginRight: 30,
          },
          children: <ChevronLeft />,
          // style: {
          //   alignSelf: 'center',
          //   background: 'none',
          //   border: 'none',
          //   borderRadius: '50%',
          //   color: '#9C94D0',
          //   cursor: 'pointer',
          //   fontSize: '2rem',
          //   width: 50,
          //   height: 50,
          //   lineHeight: 1,
          //   textAlign: 'center',
          // },
          // children: <span>{`<`}</span>,
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
        {dummy.cards.map((card, index: number) => {
          return <ProductCard card={card} keys={index} />;
        })}
      </Carousel>
    </S.Container>
  );
};

export default ProductCardCarousel;
