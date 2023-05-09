import { useEffect, useState } from 'react';

import SelectBox from './SelectBox/SelectBox';
import RangeMultiSlider_M_Star from '@/components/RangeMultiSlider_M/RangeMultiSlider_M_Star';
import RangeMultiSlider_M_ABV from '@/components/RangeMultiSlider_M/RangeMultiSlider_M_ABV';

import * as S from './SearchFilter.styled';

type Option = {
  region: string;
  category: string;
  rate: Range;
  level: Range;
};

type Range = {
  max: number;
  min: number;
};

function SearchFilter() {
  /**
   * useState object 형태 업데이트하기
   * https://jaddong.tistory.com/entry/useState-object-%ED%98%95%ED%83%9C-%EC%97%85%EB%8D%B0%EC%9D%B4%ED%8A%B8%ED%95%98%EA%B8%B0
   */
  const [option, setOption] = useState<Option>({
    region: '',
    category: '',
    rate: {
      max: 0,
      min: 0,
    },
    level: {
      max: 0,
      min: 0,
    },
  });

  const changeRegionOption = (selectRegion: string) => {
    setOption({ ...option, region: selectRegion });
  };

  const changeCategoryOption = (selectCategory: string) => {
    setOption({ ...option, category: selectCategory });
  };

  const changeRateOption = (selectRateRange: Range) => {
    setOption({ ...option, rate: selectRateRange });
  };

  const changeLevelOption = (selectLevelRange: Range) => {
    setOption({ ...option, level: selectLevelRange });
  };

  useEffect(() => {
    console.log(option);
  }, [option]);

  return (
    <S.Container>
      <S.Wrapper>
        <S.Inner>
          <S.Left>
            <S.Drinks>
              <S.FilterTitle>주종</S.FilterTitle>
              <SelectBox
                changeRegion={(region: string) => changeRegionOption(region)}
                changeCategory={(category: string) =>
                  changeCategoryOption(category)
                }
              />
            </S.Drinks>
          </S.Left>
          <S.Right>
            <S.StarRate>
              <S.FilterTitle css={S.FilterTitle2}>별점</S.FilterTitle>
              <S.RangeMultiSlider>
                <RangeMultiSlider_M_Star
                  min={0}
                  max={50}
                  onChange={({ min, max }: { min: number; max: number }) =>
                    console.log(`min = ${min}, max = ${max}`)
                  }
                />
              </S.RangeMultiSlider>
            </S.StarRate>
            <S.ABV>
              <S.FilterTitle css={S.FilterTitle2}>도수</S.FilterTitle>
              <S.RangeMultiSlider>
                <RangeMultiSlider_M_ABV
                  min={0}
                  max={70}
                  onChange={({ min, max }: { min: number; max: number }) =>
                    console.log(`min = ${min}, max = ${max}`)
                  }
                />
              </S.RangeMultiSlider>
            </S.ABV>
          </S.Right>
        </S.Inner>
        <S.Bottom>
          <S.FindButton type={'submit'}>Find</S.FindButton>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default SearchFilter;
