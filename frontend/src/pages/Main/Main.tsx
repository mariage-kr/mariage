import Visual from './Visual/Visual';
import Recommend from './Recommend/Recommend';
import * as S from './Main.styled';


function Main() {
  return (
    <>
      <S.Header>header</S.Header>
      <Visual/>
      <Recommend/>
    </>
  );
}

export default Main;
