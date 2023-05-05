import * as S from './Header.styled';

import Dropdown from './Dropdown/Dropdown';

import categoryData from './category.json';

function Header() {
  const data = categoryData;

  return (
    <S.Container>
      <S.Logo>
        <h1>Mariage</h1>
      </S.Logo>
      <S.Nav>
        {data.category.map((category, index) => {
          return <Dropdown key={index} data={category} />;
        })}
      </S.Nav>
      <S.Search>
        <S.Input></S.Input>
      </S.Search>
      <S.Profile>
        <span>로그인</span>
        <span>회원가입</span>
      </S.Profile>
    </S.Container>
  );
}

export default Header;
