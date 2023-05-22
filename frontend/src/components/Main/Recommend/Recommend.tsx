import { useState } from 'react';

import Filter from './Filter/Filter';
import Weather from './Weather/Weather';
import ProductCardCarousel from './ProductCardCarousel/ProductCardCarousel';

import * as S from './Recommend.styled';

const Recommend = () => {
  // TODO: weather, recommend, week, month, total
  const [type, setType] = useState<string>('weather');

  const changeType = (type: string) => {
    setType(type);
  };

  return (
    <S.Container>
      <Filter />
      <Weather />
      <ProductCardCarousel />
    </S.Container>
  );
};

export default Recommend;
