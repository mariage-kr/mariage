import { SORT } from '@/constants/option';

import { useState } from 'react';

import * as S from './Option.styled';

type PropsType = {
  changeSort: (option: string) => void;
};

type OptionSelectType = {
  rate: boolean;
  count: boolean;
};

function Option({ changeSort }: PropsType) {
  const changeOption = (option: string) => {
    changeSort(option);
    changeSelect(option);
  };

  const [select, setSelect] = useState<OptionSelectType>({
    rate: true,
    count: false,
  });

  const changeSelect = (key: string) => {
    if (key === 'rate') {
      setSelect({
        rate: true,
        count: false,
      });
    }
    if (key === 'count') {
      setSelect({
        rate: false,
        count: true,
      });
    }
  };

  return (
    <S.Container>
      <S.Btn
        onClick={() => {
          changeOption(SORT.FILTER.RATE);
        }}
        select={select.rate}
      >
        별점순
      </S.Btn>
      <S.Btn
        onClick={() => {
          changeOption(SORT.FILTER.COUNT);
        }}
        select={select.count}
      >
        리뷰순
      </S.Btn>
    </S.Container>
  );
}

export default Option;
