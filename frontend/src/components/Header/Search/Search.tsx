import { useNavigate } from 'react-router-dom';

import { ReactComponent as SearchImg } from '@/assets/svg/search.svg';
import useInput from '@/hooks/useInput';
import { PARAM } from '@/constants/rule';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './Search.styled';

function Search() {
  const navigate = useNavigate();
  const { value: search, setValue: setSearch } = useInput<string>('');

  const handleOnKeyPress = (e: any) => {
    if (e.key === 'Enter') {
      searchProduct();
      e.target.value = null;
    }
  };

  const searchProduct = () => {
    if (search === '') {
      return;
    }
    navigate(
      `${BROWSER_PATH.PRODUCT}?search=${search}&minRate=${PARAM.RATE.MIN}&maxRate=${PARAM.RATE.MAX}&minLevel=${PARAM.LEVEL.MIN}&maxLevel=${PARAM.LEVEL.MAX}`,
    );
    window.location.reload();
  };

  return (
    <S.Container>
      <S.Input
        type={'text'}
        value={search}
        onChange={setSearch}
        autoComplete={'off'}
        placeholder="원하는 주류를 검색하세요"
        onKeyUp={handleOnKeyPress}
      ></S.Input>
      <S.Wrapper>
        <SearchImg onClick={searchProduct} />
      </S.Wrapper>
    </S.Container>
  );
}

export default Search;
