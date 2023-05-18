import { useState } from 'react';
import RangeMultiSlider_F from '@/components/Slider/RangeMultiSlider_F/RangeMultiSlider_F';
import { Range } from '@/@types/slider';
import * as S from './Filter.styled';

import {
  DrinkUpperCategoryType,
  DrinkRegionCategoryType,
  DrinkLowerCategoryType,
} from '@/@types/category';

type FilterProps = {
  count: number;
  categories: DrinkRegionCategoryType[];
};

type Option = {
  rate: Range;
  level: Range;
};

function Filter({ count, categories }: FilterProps) {
  const [selectedUpperCategory, setSelectedUpperCategory] = useState<
    string | undefined
  >();

  const [selectedLowerCategory, setSelectedLowerCategory] = useState<
    string | null
  >(null);

  const handleUpperCategoryClick = (
    category: string | undefined,
    categoryRegion: string,
  ) => {
    setSelectedUpperCategory(category);
    setSelectedLowerCategory(null);
  };

  const handleLowerCategoryClick = (
    lowerCategory: DrinkLowerCategoryType,
  ): void => {};

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

  const changeRateOption = (selectRateRange: Range) => {
    setOption({ ...option, rate: selectRateRange });
  };

  const changeLevelOption = (selectLevelRange: Range) => {
    setOption({ ...option, level: selectLevelRange });
  };

  return (
    <S.Container>
      <p>조회한 상품 개수는 {count}개 입니다.</p>
      <S.FilterWrap>
        <h4>필터</h4>
        <S.CategoryWrap>
          <p>상위 카테고리</p>
          {categories.map(
            (category: DrinkRegionCategoryType, index: number) => (
              <div key={index}>
                {category.categories.map(
                  (upperCategory: DrinkUpperCategoryType, index: number) => (
                    <S.Category
                      key={index}
                      onClick={() =>
                        handleUpperCategoryClick(
                          upperCategory.value,
                          category.region,
                        )
                      }
                    >
                      {category.region} {upperCategory.name}
                    </S.Category>
                  ),
                )}
              </div>
            ),
          )}
          <p>하위 카테고리</p>
          {categories.map(
            (category: DrinkRegionCategoryType, index: number) => (
              <div key={index}>
                {category.categories
                  .filter(
                    (upperCategory: DrinkUpperCategoryType) =>
                      upperCategory.value === selectedUpperCategory,
                  )
                  .map(
                    (
                      upperCategory: DrinkUpperCategoryType,
                      upperIndex: number,
                    ) => (
                      <div key={upperIndex}>
                        {upperCategory.subCategories.map(
                          (
                            lowerCategory: DrinkLowerCategoryType,
                            lowerIndex: number,
                          ) => (
                            <S.Category
                              key={lowerIndex}
                              onClick={() =>
                                handleLowerCategoryClick(lowerCategory)
                              }
                            >
                              {lowerCategory.name}
                            </S.Category>
                          ),
                        )}
                      </div>
                    ),
                  )}
              </div>
            ),
          )}
        </S.CategoryWrap>
        <S.RangeWrap>
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
        <S.FilterBtn>필터적용</S.FilterBtn>
      </S.FilterWrap>
    </S.Container>
  );
}

export default Filter;
