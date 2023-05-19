import { useState } from 'react';

import { PairingSelectType } from '@/@types/select';
import { PairingFoodType } from '@/@types/product';
import trophy from '../../../assets/png/trophyIcon.png';

import * as S from './Pairing.styled';

import pairing from './PairingDummyData.json';

function Pairing() {
  const [select, setSelect] = useState<PairingSelectType>({
    selected: true,
    highRate: false,
  });

  const changeSelect = (key: string) => {
    setSelect(prev => {
      return {
        ...Object.fromEntries(
          Object.entries(prev).map(([k]) => [k, k === key]),
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
          <S.TitleIcon src={trophy} />
        </S.Title>
        <S.Title css={S.title_right}>페어링 TOP 5</S.Title>
        <S.HashtagFilter>
          <S.Button
            select={select.selected}
            onClick={() => changeSelect('selected')}
          >
            # 가장 많이 선택된
          </S.Button>
          <S.Button
            select={select.highRate}
            onClick={() => changeSelect('highRate')}
          >
            # 별점이 높은
          </S.Button>
        </S.HashtagFilter>
        <S.PairingFood>
          {pairing.foods.map((food: PairingFoodType) => (
            <S.Food key={food.id}>
              <S.FoodImg src={food.img} />
              <S.NameRate>{food.name}</S.NameRate>
              <S.NameRate css={S.rate}>{food.rate}</S.NameRate>
            </S.Food>
          ))}
        </S.PairingFood>
      </S.Wrapper>
    </S.Container>
  );
}

export default Pairing;
