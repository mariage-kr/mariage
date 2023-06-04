import { useEffect, useRef, useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { ReactComponent as SearchImg } from '@/assets/svg/search.svg';
import useInput from '@/hooks/useInput';
import { PARAM } from '@/constants/rule';
import { BROWSER_PATH } from '@/constants/path';
import { SORT } from '@/constants/option';
import { requestProductSearch } from '@/apis/request/product';

import * as S from './Search.styled';

function Search() {
  const navigate = useNavigate();
  const { value: search, setValue: setSearch } = useInput<string>('');
  const [products, setProducts] = useState<string[]>([]);
  const timerRef = useRef<null | NodeJS.Timeout>(null);
  const [isFocused, setIsFocused] = useState(false);
  const [isMouseOver, setIsMouseOver] = useState(false);

  const handleOnKeyPress = (e: any) => {
    if (e.key === 'Enter') {
      searchProduct(search);
      e.target.value = null;
    }
  };

  const searchProduct = (name: string) => {
    if (name === '') {
      return;
    }
    navigate(
      `${BROWSER_PATH.PRODUCT}?search=${name}&minRate=${PARAM.RATE.MIN}&maxRate=${PARAM.RATE.MAX}&minLevel=${PARAM.LEVEL.MIN}&maxLevel=${PARAM.LEVEL.MAX}&sort=${SORT.FILTER.RATE}`,
    );
    window.location.reload();
  };

  const fetchProductName = () => {
    requestProductSearch(search).then(data => {
      setProducts(data.products);
    });
  };

  useEffect(() => {
    if (search === '' || timerRef.current) {
      return;
    }

    timerRef.current = setTimeout(() => {
      fetchProductName();
      timerRef.current = null;
    }, 250);

    return () => {
      if (timerRef.current) {
        clearTimeout(timerRef.current);
        timerRef.current = null;
      }
    };
  }, [search]);

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
          onFocus={() => setIsFocused(true)}
          onBlur={() => setIsFocused(false)}
        ></S.Input>
        {(isFocused || isMouseOver) && (
          <S.ProdList
            onMouseEnter={() => setIsMouseOver(true)}
            onMouseLeave={() => setIsMouseOver(false)}
          >
            {search !== '' && (
              <>
                {products.length !== 0
                  ? products.map((product: string, index: number) => (
                      <S.Prod
                        key={index}
                        onClick={() => searchProduct(product)}
                      >
                        {product}
                      </S.Prod>
                    ))
                  : null}
                <S.Prod onClick={() => searchProduct(search)}>
                  "{search}" 로 검색
                </S.Prod>
              </>
            )}
          </S.ProdList>
        )}
      </S.SearchWrapper>
      <S.Wrapper>
        <SearchImg onClick={() => searchProduct(search)} />
      </S.Wrapper>
    </S.Container>
  );
}

export default Search;
