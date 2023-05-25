import { useEffect, useState } from 'react';
import Carousel from 'react-simply-carousel';

import ProductCard from '../ProductCard/ProductCard';

import { ProductRecommendType } from '@/@types/product';
import {
  requestRecommendDate,
  requestRecommendWeather,
} from '@/apis/request/product';
import DataLoading from '@/components/Animation/DataLoading';

import * as S from './ProductCardCarousel.styled';

type PropsType = {
  option: string;
};

function ProductCardCarousel({ option }: PropsType) {
  const [loading, setLoading] = useState<boolean>(false);
  const [products, setProducts] = useState<ProductRecommendType[]>([]);
  const [activeSlideIndex, setActiveSlideIndex] = useState<number>(0);
  const [items, setItems] = useState<number>(5);

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
        /* TODO: 추후 해당 기능이 구현되면 추가 예정 */
        return null;
      }
      return getRecommendDate(option);
    };

    fetchProducts();
    setLoading(false);
  }, [option]);

  if (loading) {
    return (
      <S.LoadingWrapper>
        <DataLoading />
      </S.LoadingWrapper>
    );
  }

  return (
    <S.Container>
      {products.length !== 0 ? (
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
        /* TODO: 데이터가 존재하지 않을 경우 보여줄 사진 혹은 문구 필요 */
        <h1>데이터가 존재하지 않습니다!</h1>
      )}
    </S.Container>
  );
}

export default ProductCardCarousel;
