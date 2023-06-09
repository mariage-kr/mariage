import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

import RangeMultiSlider_F from '@/components/Slider/RangeMultiSlider_F/RangeMultiSlider_F';

import { Range } from '@/@types/slider';
import {
  DrinkUpperCategoryType,
  DrinkRegionCategoryType,
  DrinkLowerCategoryType,
} from '@/@types/category';
import { BROWSER_PATH } from '@/constants/path';
import { PARAM } from '@/constants/rule';
import { REGION, SORT } from '@/constants/option';
import { useProductCategory } from '@/hooks/useProductCategory';

import * as S from './Filter.styled';

type FilterProps = {
  search: string | null;
  upperCategory: string | null;
  lowerCategory: string | null;
  count: number;
};

type Option = {
  rate: Range;
  level: Range;
};

function Filter({ search, upperCategory, lowerCategory, count }: FilterProps) {
  const navigate = useNavigate();

  const { value: category } = useProductCategory();

  const [selectUpperCategory, setSelectUpperCategory] = useState<string | null>(
    upperCategory,
  );
  const [selectLowerCategory, setSelectLowerCategory] = useState<string | null>(
    lowerCategory,
  );

  const [option, setOption] = useState<Option>({
    rate: {
      max: PARAM.RATE.MAX,
      min: PARAM.RATE.MIN,
    },
    level: {
      max: PARAM.LEVEL.MAX,
      min: PARAM.LEVEL.MIN,
    },
  });

  const handleUpperCategoryClick = (category: string | null) => {
    if (selectUpperCategory === category) {
      setSelectUpperCategory(null);
      setSelectLowerCategory(null);
      return;
    }
    setSelectUpperCategory(category);
    setSelectLowerCategory(null);
  };

  const handleLowerCategoryClick = (
    lowerCategory: DrinkLowerCategoryType,
  ): void => {
    if (selectLowerCategory === lowerCategory.value) {
      setSelectLowerCategory(null);
      return;
    }
    setSelectLowerCategory(lowerCategory.value);
  };

  const changeRateOption = (selectRateRange: Range) => {
    setOption({ ...option, rate: selectRateRange });
  };

  const changeLevelOption = (selectLevelRange: Range) => {
    setOption({ ...option, level: selectLevelRange });
  };

  const findProductsByFilter = () => {
    let query = `minRate=${option.rate.min}&maxRate=${option.rate.max}&minLevel=${option.level.min}&maxLevel=${option.level.max}&sort=${SORT.FILTER.RATE}`;
    if (selectUpperCategory !== null) {
      query += `&upper=${selectUpperCategory}`;
    }
    if (selectLowerCategory !== null) {
      query += `&lower=${selectLowerCategory}`;
    }
    if (search !== null) {
      query += `&search=${search}`;
    }
    navigate(`${BROWSER_PATH.PRODUCT}?${query}`);
    window.location.reload();
  };

  return (
    <S.Container>
      <S.FilterWrap>
        <S.CategoryWrap>
          <S.UpperCategory>
            <S.CategoryTitle>상위 카테고리</S.CategoryTitle>
            <S.Domestic>
              <S.p>국내</S.p>
              {category
                .filter(category => category.region === REGION.LOCAL)
                .map((category: DrinkRegionCategoryType, index: number) => (
                  <div key={index}>
                    {category.categories.map(
                      (
                        drinkUpperCategory: DrinkUpperCategoryType,
                        index: number,
                      ) => (
                        <S.Category
                          valid={
                            drinkUpperCategory.value === selectUpperCategory
                          }
                          key={index}
                          onClick={() =>
                            handleUpperCategoryClick(drinkUpperCategory.value)
                          }
                        >
                          {drinkUpperCategory.name}
                        </S.Category>
                      ),
                    )}
                  </div>
                ))}
            </S.Domestic>
            <S.Overseas>
              <S.p css={S.p2}>해외</S.p>
              {category
                .filter(category => category.region === REGION.FOREIGN)
                .map((category: DrinkRegionCategoryType, index: number) => (
                  <div key={index}>
                    {category.categories.map(
                      (
                        drinkUpperCategory: DrinkUpperCategoryType,
                        index: number,
                      ) => (
                        <S.Category
                          valid={
                            drinkUpperCategory.value === selectUpperCategory
                          }
                          key={index}
                          onClick={() =>
                            handleUpperCategoryClick(drinkUpperCategory.value)
                          }
                        >
                          {drinkUpperCategory.name}
                        </S.Category>
                      ),
                    )}
                  </div>
                ))}
            </S.Overseas>
          </S.UpperCategory>
          <S.LowerCategory>
            <S.CategoryTitle>하위 카테고리</S.CategoryTitle>
            <S.LowerCategoryWrap>
              {category.map(
                (category: DrinkRegionCategoryType, index: number) => (
                  <div key={index}>
                    {category.categories
                      .filter(
                        (drinkUpperCategory: DrinkUpperCategoryType) =>
                          drinkUpperCategory.value === selectUpperCategory,
                      )
                      .map(
                        (
                          upperCategory: DrinkUpperCategoryType,
                          upperIndex: number,
                        ) => (
                          <div key={upperIndex}>
                            {upperCategory.subCategories.map(
                              (
                                drinkLowerCategory: DrinkLowerCategoryType,
                                lowerIndex: number,
                              ) => (
                                <S.Category
                                  valid={
                                    drinkLowerCategory.value ===
                                    selectLowerCategory
                                  }
                                  key={lowerIndex}
                                  onClick={() =>
                                    handleLowerCategoryClick(drinkLowerCategory)
                                  }
                                >
                                  {drinkLowerCategory.name}
                                </S.Category>
                              ),
                            )}
                          </div>
                        ),
                      )}
                  </div>
                ),
              )}
            </S.LowerCategoryWrap>
          </S.LowerCategory>
        </S.CategoryWrap>
        <S.RangeWrap>
          <S.h4>필터</S.h4>
          <S.Star>
            별점
            <RangeMultiSlider_F
              min={PARAM.RATE.MIN}
              max={PARAM.RATE.MAX}
              onChange={({ min, max }: { min: number; max: number }) =>
                changeRateOption({
                  max: max,
                  min: min,
                })
              }
            />
          </S.Star>
          <S.ABV>
            알코올 도수(%, ABV)
            <RangeMultiSlider_F
              min={PARAM.LEVEL.MIN}
              max={PARAM.LEVEL.MAX}
              onChange={({ min, max }: { min: number; max: number }) =>
                changeLevelOption({
                  max: max,
                  min: min,
                })
              }
            />
          </S.ABV>
        </S.RangeWrap>
        <S.BtnWrap>
          <S.FilterBtn onClick={findProductsByFilter}>필터적용</S.FilterBtn>
        </S.BtnWrap>
      </S.FilterWrap>
    </S.Container>
  );
}

export default Filter;
