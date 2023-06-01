import { useEffect } from 'react';

import {
  HeaderRegionCategoryType,
  HeaderUpperCategoryType,
} from '@/@types/category';

import { BROWSER_PATH } from '@/constants/path';
import { PARAM } from '@/constants/rule';
import useSearchParam from '@/hooks/useSearchParam';
import { SORT } from '@/constants/option';
import * as S from './DrinkInfo.styled';

function DrinkInfo({ region, value, categories }: HeaderRegionCategoryType) {
  const { value: categoryValue, setValue: setCategoryValue } =
    useSearchParam(value);

  const handleCategoryClick = async (categoryValue: string) => {
    await setCategoryValue(`upper:${categoryValue}`);
    window.location.reload();
  };

  useEffect(() => {
    setCategoryValue(`upper:${categoryValue}`);
  }, []);

  return (
    <>
      <S.Drink>
        <S.RegionText>{region}</S.RegionText>
        {categories.map((category: HeaderUpperCategoryType, index: number) => {
          const categoryValue = category.value.toLowerCase();
          return (
            <div key={index}>
              <S.StyledLink
                to={`${
                  BROWSER_PATH.PRODUCT
                }?upper=${categoryValue.toUpperCase()}&minRate=${
                  PARAM.RATE.MIN
                }&maxRate=${PARAM.RATE.MAX}&minLevel=${
                  PARAM.LEVEL.MIN
                }&maxLevel=${PARAM.LEVEL.MAX}&sort=${SORT.FILTER.RATE}`}
                onClick={() => handleCategoryClick(categoryValue)}
              >
                {category.name}
              </S.StyledLink>
            </div>
          );
        })}
      </S.Drink>
    </>
  );
}

export default DrinkInfo;
