import Visual from './Visual/Visual';
import Recommend from './Recommend/Recommend';

import * as S from './Main.styled';

function Main() {
  return (
    <S.Container>
      <Visual />
      <S.Wrapper>
        <Recommend />
      </S.Wrapper>
    </S.Container>
  );
}

export default Main;
