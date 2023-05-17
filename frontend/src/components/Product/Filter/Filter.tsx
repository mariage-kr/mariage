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

  const [selectedUpperCategory, setSelectedUpperCategory] =
    useState<DrinkUpperCategoryType | null>(null);
  const [selectedLowerCategory, setSelectedLowerCategory] = useState<string[]>(
    [],
  );

  const handleUpperCategoryClick = (
    upperCategory: DrinkUpperCategoryType,
  ): void => {
    setSelectedUpperCategory(upperCategory);
    setSelectedLowerCategory([]);
  };

  const handleLowerCategoryClick = (
    lowerCategory: DrinkLowerCategoryType,
  ): void => {
    setSelectedLowerCategory(prevSelectedLowerCategory => {
      if (prevSelectedLowerCategory.includes(lowerCategory.value)) {
        return prevSelectedLowerCategory.filter(
          value => value !== lowerCategory.value,
        );
      }
      return [...prevSelectedLowerCategory, lowerCategory.value];
    });
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
                {/* 상위 카테고리 전체를 버튼으로 map */}
                {category.categories.map(
                  (
                    upperCategory: DrinkUpperCategoryType,
                    upperIndex: number,
                  ) => (
                    <S.Category
                      key={upperIndex}
                      onClick={() => handleUpperCategoryClick(upperCategory)}
                    >
                      {category.region} {upperCategory.name}
                    </S.Category>
                  ),
                )}
              </div>
            ),
          )}

          {selectedUpperCategory && (
            <div>
              <p>하위 카테고리</p>
              {selectedUpperCategory.subCategories.map(
                (lowerCategory: DrinkLowerCategoryType, lowerIndex: number) => (
                  <S.Category
                    key={lowerIndex}
                    onClick={() => handleLowerCategoryClick(lowerCategory)}
                    style={{
                      background: selectedLowerCategory.includes(
                        lowerCategory.value,
                      )
                        ? 'lightblue'
                        : 'transparent',
                    }}
                  >
                    {lowerCategory.name}
                  </S.Category>
                ),
              )}
            </div>
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
