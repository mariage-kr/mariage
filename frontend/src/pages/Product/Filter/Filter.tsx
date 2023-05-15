import * as S from './Filter.styled';

import { useState } from 'react';
import RangeMultiSlider_F from '@/components/RangeMultiSlider_F/RangeMultiSlider_F';

interface FilterProps {
  name: string;
  total: number;
}
interface rangeMultiSliderProps {
  css?: string;
  min: number;
  max: number;
  onChange: Function;
}

const Filter: React.FC<FilterProps> = ({ name, total }) => {
  const category = [
    '스카치',
    '아메리칸 ·버번',
    '몰트',
    '아이리시',
    '그레인',
    '포트',
  ];

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
      <p>
        {name} 의 상품 개수는 {total}개 입니다.
      </p>
      <S.FilterWrap>
        <h4>필터</h4>
        <S.CategoryWrap>
          <p>종류</p>
          {category.map(function (a, i) {
            return <S.Category>{category[i]}</S.Category>;
          })}
        </S.CategoryWrap>
        <S.RangeWrap>
          <S.Star>
            별점
            <RangeMultiSlider_F
              min={0}
              max={50}
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
};

export default Filter;
