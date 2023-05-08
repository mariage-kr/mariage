import Recommend from './Recommend/Recommend';
import SearchFilter from './SearchFilter/SearchFilter';
import Visual from './Visual/Visual';

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
