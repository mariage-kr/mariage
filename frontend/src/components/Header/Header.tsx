import { useEffect } from 'react';

import Dropdown from './Dropdown/Dropdown';
import User from './User/Profile';
import Search from './Search/Search';

import { BROWSER_PATH } from '@/constants/path';
import { useDrinkUpperCategory } from '@/hooks/useCategory';
import { CategoryType } from '@/@types/category';

import * as S from './Header.styled';

function Header() {
  const { value: category, setValue: setCategory } = useDrinkUpperCategory();

  useEffect(() => {
    setCategory;
  }, []);

  const reload = () => {
    if (location.pathname === BROWSER_PATH.BASE) {
      location.reload();
    }
  };

  return (
    <S.Container>
      <S.Logo>
        <S.StyledLink to={BROWSER_PATH.BASE} onClick={reload}>
          <S.Header>Mariage</S.Header>
        </S.StyledLink>
      </S.Logo>
      <S.Nav>
        {category.map((category: CategoryType, index: number) => {
          return (
            <Dropdown
              value={category.value}
              region={category.region}
              categories={category.categories}
              key={index}
            />
          );
        })}
      </S.Nav>
      <S.SearchArea>
        <Search />
      </S.SearchArea>
      <S.UserArea>
        <User />
      </S.UserArea>
    </S.Container>
  );
}

export default Header;
