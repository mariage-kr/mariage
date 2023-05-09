import { useCallback, useEffect, useState } from 'react';

import Dropdown from './Dropdown/Dropdown';
import Profile from './Profile/Profile';
import Search from './Search/Search';

import { requestDrinkUpperCategory } from '@/apis/request/category';
import { BROWSER_PATH } from '@/constants/path';
import { CategoryType } from '@/types/category';

import * as S from './Header.styled';

function Header() {
  const [category, setCategory] = useState<CategoryType[]>([]);

  const requestCategory = useCallback(async () => {
    await requestDrinkUpperCategory()
      .then(response => {
        setCategory(response.data.category);
      })
      .catch(error => {});
  }, [category]);

  useEffect(() => {
    requestCategory();
  }, []);

  console.log(category);

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
