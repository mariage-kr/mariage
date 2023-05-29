import { useState } from 'react';

import useSelect from '@/hooks/useSelect';
import { SortType } from '@/@types/select';
import { FoodCategoryResponseType, FoodCategoryType } from '@/@types/category';

import reviewIcon from '@/assets/png/review.png';

import * as S from './ReviewCategory.styled';

function ReviewCategory({ category }: FoodCategoryResponseType) {
  const { value: option, setValue: setOption } = useSelect('');

  // 정렬
  const [sort, setSort] = useState<SortType>({
    sympathy: false,
    newest: true,
  });

  const changeSort = (key: string) => {
    setSort(prev => {
      return {
        ...Object.fromEntries(
          Object.entries(prev).map(([k]) => [k, k === key]),
        ),
      } as {
        sympathy: boolean;
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
                {category &&
                  category.map((category: FoodCategoryType) => {
                    return (
                      <S.Option key={category.id}>{category.name}</S.Option>
                    );
                  })}
                {/* {reviewOptions &&
                  reviewOptions.map((reviewOption: FoodCategoryType) => (
                    <S.Option key={reviewOption.id}>
                      {reviewOption.name}
                    </S.Option>
                  ))} */}
              </S.SelectBox>
            </label>
          </S.FloatWrap>
          <S.FloatWrap>
            <S.Sort>
              <S.Button
                sort={sort.sympathy}
                onClick={() => changeSort('sympathy')}
              >
                공감순
              </S.Button>
              <S.Button sort={sort.newest} onClick={() => changeSort('newest')}>
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
