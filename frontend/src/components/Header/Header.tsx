import { useEffect } from 'react';

import Dropdown from './Dropdown/Dropdown';
import Profile from './Profile/Profile';
import Search from './Search/Search';

import { BROWSER_PATH } from '@/constants/path';
import { useDrinkUpperCategory } from '@/hooks/useCategory';
import { CategoryType } from '@/types/category';

import * as S from './Header.styled';

function Header() {
  const { value: category, setValue: setCategory } = useDrinkUpperCategory();

  useEffect(() => {
    setCategory();
  }, []);

  return (
    <S.Container>
      <S.Logo>
        <S.StyledLink to={BROWSER_PATH.BASE}>
          <S.Header>Mariage</S.Header>
        </S.StyledLink>
      </S.Logo>
      <S.Nav>
        {category.map((category: CategoryType, index: number) => {
          return <Dropdown data={category} key={index} />;
        })}
      </S.Nav>
      <Search />
      <Profile />
    </S.Container>
  );
}

export default Header;
