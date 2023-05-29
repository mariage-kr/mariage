import { ReactComponent as SearchImg } from '@/assets/svg/search.svg';

import * as S from './Search.styled';

function Search() {
  return (
    <S.Container>
      <S.Input
        type={'text'}
        placeholder="원하는 주류를 검색하세요"
        autoComplete={'off'}
      ></S.Input>
      <SearchImg />
    </S.Container>
  );
}

export default Search;
