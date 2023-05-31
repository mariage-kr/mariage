import { useEffect } from 'react';

import {
  HeaderRegionCategoryType,
  HeaderUpperCategoryType,
} from '@/@types/category';
import { BROWSER_PATH } from '@/constants/path';
import { PARAM } from '@/constants/rule';
import useSearchParam from '@/hooks/useSearchParam';

import * as S from './Dropdown.styled';
import { SORT } from '@/constants/option';

function Dropdown({ region, value, categories }: HeaderRegionCategoryType) {
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
