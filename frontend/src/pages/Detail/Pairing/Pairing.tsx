import { useState } from 'react';
import pairing from './PairingDummyData.json';
import trophy from '@/assets/png/trophyicon.png'

import * as S from './Pairing.styled';

function Pairing() {
  const [select, setSelect] = useState({
    selected: true,
    highRate: false,
  });

  const changeSelect = (key: string) => {
    setSelect(prev => {
      return {
        ...Object.fromEntries(
          Object.entries(prev).map(([k, v]) => [k, k === key]),
        ),
      } as {
        selected: boolean;
        highRate: boolean;
      };
    });
  };

  return (
    <S.Container>
      <S.Wrapper>
        <S.Title css={S.title_left}>
          <S.TitleIcon src={trophy}/>
        </S.Title>
        <S.Title css={S.title_right}>페어링 TOP 5</S.Title>
        <S.HashtagFilter>
          <S.Button select={select.selected} onClick={() => changeSelect('selected')}>
            # 가장 많이 선택된
          </S.Button>
          <S.Button select={select.highRate} onClick={() => changeSelect('highRate')}>
            # 별점이 높은
          </S.Button>
        </S.HashtagFilter>
        
        <S.PairingFood>
        {pairing.foods.map(food => (
          <S.Food>
            <S.FoodImg src={food.img}/>
            <S.NameRate css={S.name}>{food.name}</S.NameRate>
            <S.NameRate css={S.rate}>{food.rate}</S.NameRate>
          </S.Food>
        ))}
        </S.PairingFood>
      </S.Wrapper>
    </S.Container>
  );
};

export default Pairing;