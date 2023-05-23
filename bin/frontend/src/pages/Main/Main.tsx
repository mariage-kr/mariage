import Recommend from '@/components/Main/Recommend/Recommend';
import SearchFilter from '@/components/Main/SearchFilter/SearchFilter';
import Visual from '@/components/Main/Visual/Visual';

import * as S from './Main.styled';

function Main() {
  return (
    <S.Container>
      <Visual />
      <S.Wrapper>
        <Recommend />
        <SearchFilter />
      </S.Wrapper>
    </S.Container>
  );
}

export default Main;
