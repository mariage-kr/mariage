import { useEffect, useState } from 'react';
import Carousel from 'react-simply-carousel';

import ProductCard from '../ProductCard/ProductCard';

import { ProductRecommendType } from '@/@types/product';
import {
  requestRecommendDate,
  requestRecommendWeather,
} from '@/apis/request/product';
import { OPTION } from '@/constants/option';

import * as S from './ProductCardCarousel.styled';

import dummy from './ProductCardDummyData.json';

const ProductCardCarousel = () => {
  const [products, setProducts] = useState<ProductRecommendType[]>([]);
  const [activeSlideIndex, setActiveSlideIndex] = useState<number>(0);
  const getItemCount = (): number => {
    const width: number = window.innerWidth;

    if (width >= 1800) {
      return Math.floor(width / 320) - 1;
    } else if (width >= 1570) {
      return 4;
    } else if (width >= 1200) {
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

  const getRecommendWeather = () => {
    requestRecommendWeather().then(data => {
      console.log(data);
    });
  };

  const getRecommendDate = () => {
    requestRecommendDate(OPTION.RECOMMEND_DATE.WEEK).then(data => {
      if (Array.isArray(data)) {
        setProducts(data);
      }
    });
  };

  useEffect(() => {
    getRecommendDate();
  }, []);

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
            background: 'none',
            border: 'none',
            borderRadius: '50%',
            color: '#9C94D0',
            cursor: 'pointer',
            fontSize: '3rem',
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
            fontSize: '3rem',
            width: 50,
            height: 50,
            lineHeight: 1,
            textAlign: 'center',
          },
          children: <span>{`<`}</span>,
        }}
        speed={1000}
        easing="linear"
      >
        {products &&
          products.map((product: ProductRecommendType) => {
            return <ProductCard key={product.productId} {...product} />;
          })}
      </Carousel>
    </S.Container>
  );
};

export default ProductCardCarousel;
