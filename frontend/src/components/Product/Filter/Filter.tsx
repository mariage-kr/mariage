import { useState } from 'react';

import RangeMultiSlider_F from '@/components/Slider/RangeMultiSlider_F/RangeMultiSlider_F';
import { Range } from '@/@types/slider';

import {
  DrinkUpperCategoryType,
  DrinkRegionCategoryType,
  DrinkLowerCategoryType,
} from '@/@types/category';
import { useNavigate } from 'react-router-dom';
import { BROWSER_PATH } from '@/constants/path';
import { useProductCategory } from '@/hooks/useProductCategory';

import * as S from './Filter.styled';

type FilterProps = {
  search: string | null;
  count: number;
};

type Option = {
  rate: Range;
  level: Range;
};

function Filter({ search, count }: FilterProps) {
  const navigate = useNavigate();

  const { value: category } = useProductCategory();

  const [selectUpperCategory, setSelectUpperCategory] = useState<string | null>(
    null,
  );
  const [selectLowerCategory, setSelectLowerCategory] = useState<string | null>(
    null,
  );

  const [option, setOption] = useState<Option>({
    rate: {
      max: 50,
      min: 0,
    },
    level: {
      max: 70,
      min: 0,
    },
  });

  const handleUpperCategoryClick = (category: string | null) => {
    setSelectUpperCategory(category);
    setSelectLowerCategory(null);
  };

  const handleLowerCategoryClick = (
    lowerCategory: DrinkLowerCategoryType,
  ): void => {
    setSelectLowerCategory(lowerCategory.value);
  };

  const changeRateOption = (selectRateRange: Range) => {
    setOption({ ...option, rate: selectRateRange });
  };

  const changeLevelOption = (selectLevelRange: Range) => {
    setOption({ ...option, level: selectLevelRange });
  };

  const findProductsByFilter = () => {
    let query = `minRate=${option.rate.min}&maxRate=${option.rate.max}&minLevel=${option.level.min}&maxLevel=${option.level.max}`;
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

  const resetFilter = () => {
    setSelectUpperCategory(null);
    setSelectLowerCategory(null);
  };

  return (
    <S.Container>
      <S.Count>
        조회한 상품 개수는 <S.Color>{count}개</S.Color> 입니다.
      </S.Count>
      <S.FilterWrap>
        <S.CategoryWrap>
          <S.UpperCategory>
            <S.CategoryTitle>상위 카테고리</S.CategoryTitle>
            <S.Domestic>
              <S.p>국내</S.p>
              {category
                .filter(category => category.region === '국내')
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
                .filter(category => category.region === '해외')
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
              min={0}
              max={5}
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
              min={0}
              max={70}
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
          <S.FilterBtn onClick={resetFilter}>초기화</S.FilterBtn>
        </S.BtnWrap>
      </S.FilterWrap>
    </S.Container>
  );
}

export default Filter;
