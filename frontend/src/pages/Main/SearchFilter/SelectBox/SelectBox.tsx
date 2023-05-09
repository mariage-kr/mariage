import { useEffect, useState } from 'react';
import * as S from './SelectBox.styled';

import useSelect from '@/hooks/useSelect';
import { useRecoilValue } from 'recoil';
import { drinkUpperCategoryState } from '@/store/status';
import { CategoryType } from '@/types/category';

interface Options {
  value: string;
  name: string;
}

function SelectBox() {
  const drinkUpperCategory = useRecoilValue(drinkUpperCategoryState);

  const { value: option, setValue: setOption } = useSelect(
    drinkUpperCategory[0].region,
  );

  const [category, setCategory] = useState<CategoryType | undefined>(
    drinkUpperCategory[0],
  );

  const onRegionChangeHandler = (option: string) => {
    setCategory(
      drinkUpperCategory.find(category => category.region === option),
    );
  };

  useEffect(() => {
    onRegionChangeHandler(option);
  }, [option]);

  return (
    <S.Container>
      <label>
        <S.SelectBox onChange={setOption}>
          {drinkUpperCategory.map((category: CategoryType, index: number) => (
            <S.Option key={index} value={category.region}>
              {category.region}
            </S.Option>
          ))}
        </S.SelectBox>
      </label>
      <label>
        <S.SelectBox>
          {category &&
            category.categories.map((category, index) => (
              <S.Option key={index} value={category.value}>
                {category.value}
              </S.Option>
            ))}
        </S.SelectBox>
      </label>
    </S.Container>
  );
}

export default SelectBox;
