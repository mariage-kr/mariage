import { useState } from 'react';

import Filter from './Filter/Filter';
import Weather from './Weather/Weather';
import ProductCardCarousel from './ProductCardCarousel/ProductCardCarousel';

import * as S from './Recommend.styled';

const Recommend = () => {
  // TODO: algo ,weather, week, month, total
  const [option, setOption] = useState<string>('');

  const changeOption = (option: string) => {
    setOption(option);
  };

  return (
    <S.Container>
      <Filter changeOption={changeOption} />
      <Weather />
      <ProductCardCarousel option={option} />
    </S.Container>
  );
};

export default Recommend;
