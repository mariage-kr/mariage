import Dropdown from './Dropdown/Dropdown';

import { BROWSER_PATH } from '@/constants/path';

import * as S from './Header.styled';

import categoryData from './category.json';

function Header() {
  const data = categoryData;

  return (
    <S.Container>
      <S.Logo>
        <S.Header>Mariage</S.Header>
      </S.Logo>
      <S.Nav>
        {data.category.map((category, index) => {
          return <Dropdown key={index} data={category} />;
        })}
      </S.Nav>
      <S.Search>
        <S.Input placeholder="원하시는 주류를 검색하세요"></S.Input>
      </S.Search>
      <S.Profile>
        <S.StyledLink to={BROWSER_PATH.LOGIN}>로그인</S.StyledLink>
        <S.StyledLink to={BROWSER_PATH.SIGN_UP}>회원가입</S.StyledLink>
      </S.Profile>
    </S.Container>
  );
}

export default Header;
