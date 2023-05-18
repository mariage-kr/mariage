import { useEffect, useState } from 'react';
import {
  HeaderRegionCategoryType,
  HeaderUpperCategoryType,
} from '@/@types/category';
import { BROWSER_PATH } from '@/constants/path';
import * as S from './Dropdown.styled';
import useSearchParam from '@/hooks/useSearchParam';

function Dropdown({ region, value, categories }: HeaderRegionCategoryType) {
  const { value: categoryValue, setValue: setCategoryValue } =
    useSearchParam(value);

  const handleCategoryClick = (categoryValue: string) => {
    setCategoryValue(`upper:${categoryValue}`); // 예시: upper:local_soju
  };

  useEffect(() => {
    setCategoryValue(`upper:${categoryValue}`);
  }, []);

  console.log('categoryValue:', categoryValue);

  return (
    <S.Container>
      <S.Dropdown>
        <S.DropBtn>
          <span css={S.UnderBar}>{region}</span>
        </S.DropBtn>
        <S.DropContent>
          {categories.map(
            (category: HeaderUpperCategoryType, index: number) => {
              const categoryValue = category.value.toLowerCase();
              return (
                <S.DropList key={index}>
                  <S.StyledLink
                    to={`${BROWSER_PATH.PRODUCT}?upper=${categoryValue}`}
                    onClick={() => handleCategoryClick(categoryValue)}
                  >
                    {category.name}
                  </S.StyledLink>
                </S.DropList>
              );
            },
          )}
        </S.DropContent>
      </S.Dropdown>
    </S.Container>
  );
}

export default Dropdown;
