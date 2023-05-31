import { useNavigate } from 'react-router-dom';

import reviewIcon from '@/assets/png/review.png';

import { SORT } from '@/constants/option';
import { FoodCategoryType } from '@/@types/category';
import { BROWSER_PATH } from '@/constants/path';
import useSelect from '@/hooks/useSelect';
import useFoodCategory from '@/hooks/useFoodCategory';

import * as S from './ReviewCategory.styled';
import { useEffect } from 'react';
import { PAGING } from '@/constants/rule';

type PropsType = {
  productId: number;
  memberId?: number;
};

function ReviewCategory({ productId, memberId }: PropsType) {
  const navigate = useNavigate();
  const queryParam = new URLSearchParams(location.search);

  const { foodCategory, setFoodCategory } = useFoodCategory();
  const { value: option, setValue: setOption } = useSelect('');

  // 정렬
  const sort = queryParam.get('sort');
  const selectedCategory = queryParam.get('category');

  const findReview = async (sortOption: string) => {
    if ((await sort) === sortOption) {
      return;
    }
    let query = `sort=${sortOption}`;
    if (selectedCategory !== null) {
      query += `&category=${selectedCategory}`;
    }
    navigate(`${BROWSER_PATH.DETAIL}/${productId}?${query}`);
    window.location.reload();
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
                      <S.Option
                        key={category.id}
                        selected={category.value === selectedCategory}
                      >
                        {category.name}
                      </S.Option>
                    );
                  })}
              </S.SelectBox>
            </label>
          </S.FloatWrap>
          <S.FloatWrap>
            <S.Sort>
              <S.Button
                sort={sort === SORT.DETAIL.LIKE}
                onClick={() => findReview(SORT.DETAIL.LIKE)}
              >
                공감순
              </S.Button>
              <S.Button
                sort={sort === SORT.DETAIL.NEWEST}
                onClick={() => findReview(SORT.DETAIL.NEWEST)}
              >
                최신순
              </S.Button>
            </S.Sort>
          </S.FloatWrap>
          <S.FloatWrap>
            <S.StarRate></S.StarRate>
          </S.FloatWrap>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewCategory;
