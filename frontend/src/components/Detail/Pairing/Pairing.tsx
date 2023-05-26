import { useState } from 'react';

import { PairingSelectType } from '@/@types/select';
import trophy from '@/assets/png/trophy.png';
import NoFoodRank from '@/components/NoFoodRank/NoFoodRanking';

import * as S from './Pairing.styled';

import { PairingFoodType } from '@/@types/product';
import FoodImg from '@/assets/Food/FoodImg';

type PropsType = {
  foodRateRanking: PairingFoodType[];
  foodCountRanking: PairingFoodType[];
};

function Pairing({ foodCountRanking, foodRateRanking }: PropsType) {
  const [select, setSelect] = useState<PairingSelectType>({
    count: true,
    rate: false,
  });

  const changeSelect = (key: string) => {
    if (key === 'rate') {
      setSelect({
        rate: true,
        count: false,
      });
    }
    if (key === 'count') {
      setSelect({
        rate: false,
        count: true,
      });
    }
  };

  const lengthIsZero = (): boolean => {
    return foodCountRanking.length === 0;
  };

  return (
    <S.Container>
      <S.Wrapper>
        <S.Title css={S.title_left}>
          <S.TitleIcon src={trophy} />
        </S.Title>
        <S.Title css={S.title_right}>페어링 TOP 5</S.Title>
        <S.HashtagFilter>
          <S.Button select={select.count} onClick={() => changeSelect('count')}>
            # 가장 많이 선택된
          </S.Button>
          <S.Button select={select.rate} onClick={() => changeSelect('rate')}>
            # 별점이 높은
          </S.Button>
        </S.HashtagFilter>
        <S.PairingFood>
          {lengthIsZero() ? (
            <NoFoodRank />
          ) : select.rate ? (
            foodRateRanking.map(
              ({ foodId, category, avgFoodRate }: PairingFoodType) => (
                <S.Food key={foodId}>
                  <FoodImg id={foodId} />
                  <S.NameRate>{category}</S.NameRate>
                  <S.NameRate css={S.rate}>{avgFoodRate} 점</S.NameRate>
                </S.Food>
              ),
            )
          ) : (
            foodCountRanking.map(
              ({ foodId, category, reviewCount }: PairingFoodType) => (
                <S.Food key={foodId}>
                  <FoodImg id={foodId} />
                  <S.NameRate>{category}</S.NameRate>
                  <S.NameRate css={S.rate}>{reviewCount} 번</S.NameRate>
                </S.Food>
              ),
            )
          )}
        </S.PairingFood>
      </S.Wrapper>
    </S.Container>
  );
}

export default Pairing;
