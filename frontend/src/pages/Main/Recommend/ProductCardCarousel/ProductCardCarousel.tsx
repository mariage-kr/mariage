import { useEffect, useState } from 'react';
import Carousel from 'react-simply-carousel';

import ProductCard from '../ProductCard/ProductCard';

import * as S from './ProductCardCarousel.styled';

import dummy from './ProductCardDummyData.json';
import ChevronRight from '@/components/Button/Chevron/ChevronRight';
import ChevronLeft from '@/components/Button/Chevron/ChevronLeft';

const ProductCardCarousel = () => {
  const screenWidth: number = window.screen.width;
  const [activeSlideIndex, setActiveSlideIndex] = useState<number>(0);

  const getItemCount = (): number => {
    const width: number = window.innerWidth;
    if (width >= screenWidth - screenWidth / 10) {
      return 4;
    } else if (width >= screenWidth - (screenWidth / 10) * 3) {
      return 3;
    } else {
      return 2;
    }
  };

  const [items, setItems] = useState<number>(getItemCount());

  const resizeHandler = () => {
    setItems(getItemCount());
  };

  useEffect(() => {
    window.addEventListener('resize', resizeHandler);
  }, [resizeHandler]);

  return (
    <S.Container>
      <Carousel
        activeSlideIndex={activeSlideIndex}
        onRequestChange={setActiveSlideIndex}
        // itemsToShow={4}
        // itemsToScroll={1}
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
            position: 'unset',
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
            itemsToShow: items,
            itemsToScroll: items / 2,
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
