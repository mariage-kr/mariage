import { useEffect, useState } from 'react';
import { useRecoilValue } from 'recoil';

import useSelect from '@/hooks/useSelect';
import { CategoryType } from '@/types/category';
import { drinkUpperCategoryState } from '@/store/status';

import * as S from './SelectBox.styled';

/**
 * 1. [Typescript] React - useState를 props로 전달할 때의 타입 선언
 * https://velog.io/@rkio/Typescript-React-useState%EB%A5%BC-props%EB%A1%9C-%EC%A0%84%EB%8B%AC%ED%95%A0-%EB%95%8C%EC%9D%98-%ED%83%80%EC%9E%85-%EC%84%A0%EC%96%B8
 *
 * 2. React + Typescript 프롭스 타입 정의 하기
 * https://velog.io/@ovogmap/React-Typescript-2
 *
 * 3. typescript에서 undefined value 처리하기
 * https://blog.toycrane.xyz/typescript%EC%97%90%EC%84%9C-undefined-value-%EC%B2%98%EB%A6%AC%ED%95%98%EA%B8%B0-181035b5ee47
 */

type Props = {
  changeRegion(region: string): void;
  changeCategory(category: string): void;
};

function SelectBox({ changeRegion, changeCategory }: Props) {
  const drinkUpperCategory = useRecoilValue(drinkUpperCategoryState);
  const [category, setCategory] = useState<CategoryType | undefined>(
    drinkUpperCategory[0],
  );

  const { value: region, setValue: setRegion } = useSelect<string>(
    drinkUpperCategory[0].region,
  );
  const { value: selectCategory, setValue: setSelectCategory } =
    useSelect<string>('');

  const onRegionChangeHandler = (region: string) => {
    setCategory(
      drinkUpperCategory.find(category => category.region === region),
    );
  };

  /* TODO: Region 변경시 하위 카테고리도 자동으로 변경하는 로직 작성 */
  useEffect(() => {
    changeRegion(region);
    onRegionChangeHandler(region);
  }, [region]);

  useEffect(() => {
    changeCategory(selectCategory);
  }, [selectCategory]);

  return (
    <S.Container>
      <label>
        <S.SelectBox onChange={setRegion}>
          {drinkUpperCategory.map((category: CategoryType, index: number) => (
            <S.Option key={index} value={category.region}>
              {category.region}
            </S.Option>
          ))}
        </S.SelectBox>
      </label>
      <label>
        <S.SelectBox onChange={setSelectCategory}>
          {category &&
            category.categories.map((category, index) => (
              <S.Option key={index} value={category.name}>
                {category.value}
              </S.Option>
            ))}
        </S.SelectBox>
      </label>
    </S.Container>
  );
}

export default SelectBox;
