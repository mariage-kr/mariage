import { useEffect, useState } from 'react';
import Carousel from 'react-simply-carousel';

import ProductCard from '../ProductCard/ProductCard';

import { ProductRecommendType } from '@/@types/product';
import {
  requestRecommendDate,
  requestRecommendWeather,
} from '@/apis/request/product';

import * as S from './ProductCardCarousel.styled';

type OptionType = {
  option: string;
};

function ProductCardCarousel({ option }: OptionType) {
  const [loading, setLoading] = useState<boolean>(false);
  const [products, setProducts] = useState<ProductRecommendType[]>([]);
  const [activeSlideIndex, setActiveSlideIndex] = useState<number>(0);
  const [items, setItems] = useState<number>(0);

  const getItemCount = (): number => {
    const width: number = window.innerWidth;
    const productCount: number = products.length;
    if (width >= 1800) {
      return Math.min(Math.floor(width / 320) - 1, productCount);
    } else if (width >= 1570) {
      return Math.min(4, productCount);
    } else if (width >= 1200) {
      return Math.min(3, productCount);
    }
    return Math.min(2, productCount);
  };

  const resizeHandler = () => {
    setItems(getItemCount());
  };

  useEffect(() => {
    window.addEventListener('resize', resizeHandler);
  }, [resizeHandler]);

  const getRecommendWeather = () => {
    requestRecommendWeather().then(data => {
      if (Array.isArray(data)) {
        setProducts(data);
      }
    });
  };

  const getRecommendDate = (option: string) => {
    requestRecommendDate(option).then(data => {
      if (Array.isArray(data)) {
        setProducts(data);
      }
    });
  };

  useEffect(() => {
    const fetchProducts = () => {
      setLoading(true);
      if (option === 'weather') {
        return getRecommendWeather();
      }
      if (option === 'algo') {
        return null;
      }
      return getRecommendDate(option);
    };

    fetchProducts();
    setLoading(false);
  }, [option]);

  return (
    <S.Container>
      {products.length !== 0 || loading === false ? (
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
          {products.map((product: ProductRecommendType) => {
            return <ProductCard key={product.productId} {...product} />;
          })}
        </Carousel>
      ) : (
        <h1>데이터가 존재하지 않습니다!</h1>
      )}
    </S.Container>
  );
}

export default ProductCardCarousel;
