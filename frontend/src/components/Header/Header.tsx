import { Link } from 'react-router-dom';
import * as S from './Header.styled';
import Nav from './Nav/Nav';
import { ReactComponent as SearchImg } from '../../assets/svg/search.svg';

function Header() {
  return (
    <>
      <S.Container>
        <S.Block></S.Block>
        <S.Logo>
          <Link to="/" css={S.styledLink}>
            Mariage
          </Link>
        </S.Logo>
        <S.SearchBox>
          <S.Search type="text" />
          <S.SearchImg />
        </S.SearchBox>
        <S.Member>
          <Link to="/" css={S.styledLink}>
            로그인
          </Link>
          <Link to="/" css={S.styledLink}>
            회원가입
          </Link>
        </S.Member>
        <S.Block></S.Block>
        <Nav />
      </S.Container>
    </>
  );
}

export default Header;
