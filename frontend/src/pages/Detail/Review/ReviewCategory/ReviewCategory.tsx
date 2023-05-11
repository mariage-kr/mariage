import { useState } from 'react';
import useSelect from '@/hooks/useSelect';
// import reviewicon from '@/assets/png/reviewicon1.png';
import reviewicon2 from '@/assets/png/reviewicon2.png';
import * as S from './ReviewCategory.styled';

function ReviewCategory() {
  // 안주 카테고리 셀렉트
  const reviewOptions = [
    { id: 1, name: '해산물' },
    { id: 2, name: '고기/구이' },
    { id: 3, name: '족발/보쌈' },
    { id: 4, name: '찜/탕/찌개' },
    { id: 5, name: '밥/면' },
    { id: 6, name: '피자' },
    { id: 7, name: '치킨' },
    { id: 8, name: '양식' },
    { id: 9, name: '중식' },
    { id: 10, name: '돈까스/회/일식' },
    { id: 11, name: '아시안' },
    { id: 12, name: '멕시코' },
    { id: 13, name: '햄버거' },
    { id: 14, name: '분식' },
    { id: 15, name: '튀김' },
    { id: 16, name: '스낵' },
    { id: 17, name: '치즈' },
    { id: 18, name: '과일' },
    { id: 19, name: '디저트' },
    { id: 20, name: '기타' }
  ];
  
  const { value: option, setValue: setOption } = useSelect(
    reviewOptions[0].id,
  );

  // 정렬
  const [sort, setSort] = useState({
    sympathy: true,
    newest: false,
  });

  const changeSort = (key: string) => {
    setSort(prev => {
      return {
        ...Object.fromEntries(
          Object.entries(prev).map(([k, v]) => [k, k === key]),
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
          <S.TitleIcon src={reviewicon2}/>
        </S.Title>
        <S.Title css={S.title_right}>Reviews</S.Title>
        <S.Bottom>
          <S.FloatWrap>
            <label>
              <S.SelectBox onChange={setOption}>
                {reviewOptions.map(reviewOption => (
                  <S.Option key={reviewOption.id}>
                    {reviewOption.name}
                  </S.Option>
                ))}
              </S.SelectBox>
            </label>
          </S.FloatWrap>
          <S.FloatWrap>
            <S.Sort>
              <S.Button sort={sort.sympathy} onClick={() => changeSort('sympathy')}>
                공감순
              </S.Button>
              <S.Button sort={sort.newest} onClick={() => changeSort('newest')}>
                최신순
              </S.Button>
            </S.Sort>
          </S.FloatWrap>
        </S.Bottom>
        {/* <S.PairingFood>
        {pairing.foods.map(food => (
          <S.Food>
            <S.FoodImg src={food.img}/>
            <S.Name>{food.name}<S.Rate>{food.rate}</S.Rate></S.Name>
          </S.Food>
        ))}
        </S.PairingFood> */}
      </S.Wrapper>
    </S.Container>
  );
};

export default ReviewCategory;