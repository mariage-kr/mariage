import Visual from './Visual/Visual';
import Recommend from './Recommend/Recommend';
import SearchFilter from './SearchFilter/SearchFilter';
import * as S from './Main.styled';


function Main() {
  return (
    <>
      <S.Header>header</S.Header>
      <Visual/>
      <Recommend/>
      <SearchFilter/>
      <S.Footer>Footer</S.Footer>
    </>
  );
}

export default Main;
