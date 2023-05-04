import * as S from './Search.styled';
import { ReactComponent as SearchImg } from '../../../assets/svg/search.svg';

function Search() {
  return (
    <>
      <S.SearchBox>
        <S.Search type="text" />
        <SearchImg css={S.SearchImg} />
      </S.SearchBox>
    </>
  );
}

export default Search;
