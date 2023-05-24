import * as S from './NoFoodRanking.styled';

import NoFoodRank from '@/components/Animation/NoFoodRank';

function NoFoodRanking() {
  return (
    <S.Container>
      <NoFoodRank />
      <S.TextWrap>
        <p>아직 TOP 5가 없어요!</p>
      </S.TextWrap>
    </S.Container>
  );
}

export default NoFoodRanking;
