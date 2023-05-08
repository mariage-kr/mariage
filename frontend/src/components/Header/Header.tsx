import Dropdown from './Dropdown/Dropdown';
import Profile from './Profile/Profile';

import { BROWSER_PATH } from '@/constants/path';

import * as S from './Header.styled';

import categoryData from './category.json';
import Search from './Search/Search';

function Header() {
  const data = categoryData;

  return (
    <S.Container>
      <S.Logo>
        <S.StyledLink to={BROWSER_PATH.BASE}>
          <S.Header>Mariage</S.Header>
        </S.StyledLink>
      </S.Logo>
      <S.Nav>
        {data.category.map((category, index) => {
          return <Dropdown key={index} data={category} />;
        })}
      </S.Nav>
      <Search />
      <Profile />
    </S.Container>
  );
}

export default Header;
