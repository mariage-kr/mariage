import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

import reviewIcon from '@/assets/png/review.png';

import { SORT } from '@/constants/option';
import { FoodCategoryType } from '@/@types/category';
import { BROWSER_PATH } from '@/constants/path';
import useSelect from '@/hooks/useSelect';
import useFoodCategory from '@/hooks/useFoodCategory';

import star from '@/assets/png/star_icon.png';
import XIcon from '@/assets/png/XIcon.png';

import * as S from './ReviewCategory.styled';

type PropsType = {
  productId: number;
  memberId?: number;
  selectRate: number;
  changeSelectRate: (rate: number) => void;
};

function ReviewCategory({
  productId,
  memberId,
  selectRate,
  changeSelectRate,
}: PropsType) {
  const navigate = useNavigate();
  const [loading, setLoading] = useState<boolean>(false);
  // 정렬
  const queryParam = new URLSearchParams(location.search);
  const sort = queryParam.get('sort');
  const selectedCategory = queryParam.get('category');

  const { foodCategory } = useFoodCategory();
  const { value: option, setValue: setOption } = useSelect<string | null>(null);

  const findReview = async (
    sortOption: string,
    selectOption?: string | null,
  ) => {
    let query = `sort=${sortOption}`;
    if (selectOption !== null && selectOption !== 'null') {
      query += `&category=${selectOption}`;
    }
    navigate(`${BROWSER_PATH.DETAIL}/${productId}?${query}`);
    window.location.reload();
  };

  useEffect(() => {
    if (option !== null) {
      findReview(sort!, option);
    }
  }, [option]);

  const isZero = (value: number) => {
    return value === 0;
  };

  const onClickX = () => {
    changeSelectRate(0);
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
                <S.Option value={'null'}>전체</S.Option>
                {foodCategory &&
                  foodCategory.category.map((category: FoodCategoryType) => {
                    return (
                      <S.Option
                        key={category.id}
                        selected={category.value === selectedCategory}
                        value={category.value}
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
                onClick={() => findReview(SORT.DETAIL.LIKE, selectedCategory)}
              >
                공감순
              </S.Button>
              <S.Button
                sort={sort === SORT.DETAIL.NEWEST}
                onClick={() => findReview(SORT.DETAIL.NEWEST, selectedCategory)}
              >
                최신순
              </S.Button>
            </S.Sort>
          </S.FloatWrap>
          <S.FloatWrap2>
            {!isZero(selectRate) && (
              <S.StarRate>
                <S.Star>
                  <S.StarWrapper css={S.img}>
                    <S.StarImg src={star} />
                  </S.StarWrapper>
                  <S.StarWrapper css={S.rateText}>{selectRate}</S.StarWrapper>
                </S.Star>
                <S.X onClick={onClickX}>
                  <S.XIcon src={XIcon} />
                </S.X>
              </S.StarRate>
            )}
          </S.FloatWrap2>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewCategory;
