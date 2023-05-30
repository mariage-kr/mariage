import { useState } from 'react';

import reviewIcon from '@/assets/png/review.png';

import useSelect from '@/hooks/useSelect';
import { SortType } from '@/@types/select';
import { FoodCategoryType } from '@/@types/category';
import useFoodCategory from '@/hooks/useFoodCategory';

import * as S from './ReviewCategory.styled';
import { SORT } from '@/constants/option';

function ReviewCategory() {
  const { foodCategory, setFoodCategory } = useFoodCategory();
  const { value: option, setValue: setOption } = useSelect('');

  // 정렬
  const [sort, setSort] = useState<SortType>({
    like: true,
    newest: false,
  });

  const changeSort = (key: string) => {
    setSort(prev => {
      return {
        ...Object.fromEntries(
          Object.entries(prev).map(([k]) => [k, k === key]),
        ),
      } as {
        like: boolean;
        newest: boolean;
      };
    });
  };

  return (
    <S.Container>
      <S.Wrapper>
        <S.Title css={S.title_left}>
          <S.TitleIcon src={reviewIcon} />
        </S.Title>
        <S.Title css={S.title_right}>Reviews</S.Title>
        <S.Bottom>
          <S.FloatWrap>
            <label>
              <S.SelectBox onChange={setOption}>
                {foodCategory &&
                  foodCategory.category.map((category: FoodCategoryType) => {
                    return (
                      <S.Option key={category.id}>{category.name}</S.Option>
                    );
                  })}
              </S.SelectBox>
            </label>
          </S.FloatWrap>
          <S.FloatWrap>
            <S.Sort>
              <S.Button
                sort={sort.like}
                onClick={() => changeSort(SORT.DETAIL.LIKE)}
              >
                공감순
              </S.Button>
              <S.Button
                sort={sort.newest}
                onClick={() => changeSort(SORT.DETAIL.NEWEST)}
              >
                최신순
              </S.Button>
            </S.Sort>
          </S.FloatWrap>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewCategory;
