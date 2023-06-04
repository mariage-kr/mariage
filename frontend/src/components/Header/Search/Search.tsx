import { useNavigate } from 'react-router-dom';

import { ReactComponent as SearchImg } from '@/assets/svg/search.svg';
import useInput from '@/hooks/useInput';
import { PARAM } from '@/constants/rule';
import { BROWSER_PATH } from '@/constants/path';
import { SORT } from '@/constants/option';

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
      `${BROWSER_PATH.PRODUCT}?search=${search}&minRate=${PARAM.RATE.MIN}&maxRate=${PARAM.RATE.MAX}&minLevel=${PARAM.LEVEL.MIN}&maxLevel=${PARAM.LEVEL.MAX}&sort=${SORT.FILTER.RATE}`,
    );
    window.location.reload();
  };

  return (
    <S.Container>
      <S.SearchWrapper>
        <S.Input
          type={'text'}
          value={search}
          onChange={setSearch}
          autoComplete={'off'}
          placeholder="원하는 주류를 검색하세요"
          onKeyUp={handleOnKeyPress}
        ></S.Input>
        <S.ProdList>
          <S.Prod>아사히 맥주</S.Prod>
          <S.Prod>2</S.Prod>
          <S.Prod>3</S.Prod>
          <S.Prod>4</S.Prod>
          <S.Prod>5</S.Prod>
        </S.ProdList>
      </S.SearchWrapper>
      <S.Wrapper>
        <SearchImg onClick={searchProduct} />
      </S.Wrapper>
    </S.Container>
  );
}

export default Search;
