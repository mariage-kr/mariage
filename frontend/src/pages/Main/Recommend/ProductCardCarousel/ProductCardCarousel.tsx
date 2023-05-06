import { useEffect, useState } from 'react';
import Carousel from 'react-simply-carousel';

import ProductCard from '../ProductCard/ProductCard';
import ChevronRight from '@/components/Button/Chevron/ChevronRight';
import ChevronLeft from '@/components/Button/Chevron/ChevronLeft';

import * as S from './ProductCardCarousel.styled';

import dummy from './ProductCardDummyData.json';

const ProductCardCarousel = () => {
  const [activeSlideIndex, setActiveSlideIndex] = useState<number>(0);

  const getItemCount = (): number => {
    const width: number = window.innerWidth;
    console.log(width);
    if (width >= 1810) {
      return 5;
    } else if (width >= 1490) {
      return 4;
    } else if (width >= 1180) {
      return 3;
    }
    return 2;
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
        itemsToShow={items}
        itemsToScroll={items / 2}
        autoplay={true}
        autoplayDelay={5000}
        forwardBtnProps={{
          style: {
            alignSelf: 'center',
            width: 50,
            height: 50,
            background: 'none',
            marginLeft: 30,
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
            position: 'static',
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
