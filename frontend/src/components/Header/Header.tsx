import Visual from '@/pages/Main/Visual/Visual';
import * as S from './Header.styled';

function Header() {
  return (
    <>
      <S.Container>
        <S.Logo>
          <h1>Mariage</h1>
        </S.Logo>
        <S.Nav>
          <span>국내</span>
          <span>해외</span>
        </S.Nav>
        <S.Search>검색</S.Search>
        <S.Profile>
          <span>로그인</span>
          <span>회원가입</span>
        </S.Profile>
      </S.Container>
      <Visual />
    </>
  );
}

export default Header;
