import { Link } from 'react-router-dom';
import * as S from './Header.styled';
import Nav from './Nav/Nav';
import { ReactComponent as SearchImg } from '../../assets/svg/search.svg';

function Header() {
  return (
    <>
      <S.Container>
        <S.Logo>Mariage</S.Logo>
        <S.SearchBox>
          <S.Search type="text" />
          <S.SearchImg />
        </S.SearchBox>
        <S.Member>
          <a>로그인</a>
          <a>회원가입</a>
        </S.Member>
      </S.Container>
        <Nav />
    </>
  );
}

export default Header;
