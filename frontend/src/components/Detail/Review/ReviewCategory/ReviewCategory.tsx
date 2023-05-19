import { useState } from 'react';

import useSelect from 'hooks/useSelect';
import { SortType } from 'types/select';
import { FoodCategoryType } from 'types/category';

import ReviewIcon from 'assets/png/reviewIcon.png';

import * as S from './ReviewCategory.styled';

function ReviewCategory() {
  // 안주 카테고리 셀렉트
  const reviewOptions: FoodCategoryType[] = [
    {
      id: 1,
      name: '해산물',
      value: 'SEAFOOD',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/RLnWBhKnwU.png',
    },
    {
      id: 2,
      name: '고기/구이',
      value: 'ROAST',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/BSwxb7W8Yb.png',
    },
    {
      id: 3,
      name: '족발/보쌈',
      value: 'JOKBAL',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/mQMlYuxEwS.png',
    },
    {
      id: 4,
      name: '찜/탕/찌개',
      value: 'JJIGAE',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/priDlILxzy.png',
    },
    {
      id: 5,
      name: '밥/면',
      value: 'RICE',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/gAGjv4mHKZ.png',
    },
    {
      id: 6,
      name: '피자',
      value: 'PIZZA',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/SIapKORjQr.png',
    },
    {
      id: 7,
      name: '치킨',
      value: 'CHICKEN',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/MwzoQSDVo3.png',
    },
    {
      id: 8,
      name: '양식',
      value: 'ITALIAN',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/0FqURXwWoi.png',
    },
    {
      id: 9,
      name: '중식',
      value: 'CHINESE',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/w7p7jgF51R.png',
    },
    {
      id: 10,
      name: '돈까스/회/일식',
      value: 'JAPANESE',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/NEUdCmsFva.png',
    },
    {
      id: 11,
      name: '아시안',
      value: 'ASIAN',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/tYCRkl9x0C.png',
    },
    {
      id: 12,
      name: '멕시코',
      value: 'MEXICAN',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/3uTSohhOlG.png',
    },
    {
      id: 13,
      name: '햄버거',
      value: 'BURGER',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/EbPAaa37ZV.png',
    },
    {
      id: 14,
      name: '분식',
      value: 'BUNSIK',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/6V8BzBItcO.png',
    },
    {
      id: 15,
      name: '튀김',
      value: 'FRIES',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/GDZ5XpdDw9.png',
    },
    {
      id: 16,
      name: '스낵',
      value: 'SNACK',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/ygl89X0Nm1.png',
    },
    {
      id: 17,
      name: '치즈',
      value: 'CHEESE',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/9d5PyHTsce.png',
    },
    {
      id: 18,
      name: '과일/샐러드',
      value: 'FRUIT',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/QjWhPNZUpJ.png',
    },
    {
      id: 19,
      name: '디저트',
      value: 'DESSERT',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/V4tiIztiRl.png',
    },
    {
      id: 20,
      name: '기타',
      value: 'ETC',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/K1JKW6jC2h.png',
    },
  ];

  const { value: option, setValue: setOption } = useSelect(reviewOptions[0].id);

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
          <S.TitleIcon src={ReviewIcon} />
        </S.Title>
        <S.Title css={S.title_right}>Reviews</S.Title>
        <S.Bottom>
          <S.FloatWrap>
            <label>
              <S.SelectBox onChange={setOption}>
                {reviewOptions.map(reviewOption => (
                  <S.Option key={reviewOption.id}>{reviewOption.name}</S.Option>
                ))}
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
