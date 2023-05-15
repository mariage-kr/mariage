import { useState } from 'react';
import * as S from './FoodCategory.styled';

type FunctionProps = {
  category: string | null;
  changeCategory: (category: string) => void;
};

function FoodCategory({ category, changeCategory }: FunctionProps) {
  // 안주 카테고리 셀렉트
  const foodOptions = [
    {
      id: 1,
      name: '해산물',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/RLnWBhKnwU.png',
    },
    {
      id: 2,
      name: '고기/구이',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/BSwxb7W8Yb.png',
    },
    {
      id: 3,
      name: '족발/보쌈',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/mQMlYuxEwS.png',
    },
    {
      id: 4,
      name: '찜/탕/찌개',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/priDlILxzy.png',
    },
    {
      id: 5,
      name: '밥/면',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/gAGjv4mHKZ.png',
    },
    {
      id: 6,
      name: '피자',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/SIapKORjQr.png',
    },
    {
      id: 7,
      name: '치킨',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/MwzoQSDVo3.png',
    },
    {
      id: 8,
      name: '양식',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/0FqURXwWoi.png',
    },
    {
      id: 9,
      name: '중식',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/w7p7jgF51R.png',
    },
    {
      id: 10,
      name: '돈까스/회/일식',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/NEUdCmsFva.png',
    },
    {
      id: 11,
      name: '아시안',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/tYCRkl9x0C.png',
    },
    {
      id: 12,
      name: '멕시코',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/3uTSohhOlG.png',
    },
    {
      id: 13,
      name: '햄버거',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/EbPAaa37ZV.png',
    },
    {
      id: 14,
      name: '분식',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/6V8BzBItcO.png',
    },
    {
      id: 15,
      name: '튀김',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/GDZ5XpdDw9.png',
    },
    {
      id: 16,
      name: '스낵',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/ygl89X0Nm1.png',
    },
    {
      id: 17,
      name: '치즈',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/9d5PyHTsce.png',
    },
    {
      id: 18,
      name: '과일/샐러드',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/QjWhPNZUpJ.png',
    },
    {
      id: 19,
      name: '디저트',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/V4tiIztiRl.png',
    },
    {
      id: 20,
      name: '기타',
      img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/K1JKW6jC2h.png',
    },
  ];

  const [radioChecked, setRadioChecked] = useState<number | undefined>();

  const handleRadioBtn = (e: React.ChangeEvent<HTMLInputElement>) => {
    const selectedValue = parseInt(e.target.value);
    const category = foodOptions.find(
      category => category.id === selectedValue,
    )!.name;
    changeCategory(category);
  };

  return (
    <S.Container>
      <S.Wrapper>
        {foodOptions.map(foodOption => (
          <S.FoodRadioBtn>
            <S.BtnLabel key={foodOption.id}>
              <S.Btn
                type="radio"
                key={foodOption.id}
                value={foodOption.id}
                checked={category === foodOption.name}
                onChange={handleRadioBtn}
              />
              <S.Label>
                <S.ImgText css={S.btnImg}>
                  <S.Img src={foodOption.img} />
                </S.ImgText>
                <S.ImgText css={S.btnText}>{foodOption.name}</S.ImgText>
              </S.Label>
            </S.BtnLabel>
          </S.FoodRadioBtn>
        ))}
      </S.Wrapper>
    </S.Container>
  );
}

export default FoodCategory;
