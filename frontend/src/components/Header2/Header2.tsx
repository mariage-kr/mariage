import { useState } from 'react';
import { Link } from 'react-router-dom';
import * as S from './Header2.styled';
import Nav from './Nav/Nav2';
import Depth from './Nav/Depth';
import Search from './Search/Search';

function Header2() {
  const [showDropdown, setShowDropdown] = useState(false);

  const handleShowDropdown = () => {
    setShowDropdown(true);
  };

  const handleHideDropdown = () => {
    setShowDropdown(false);
  };

  return (
    <>
      <S.Container>
        <S.Block />
        <S.Logo>
          <Link to="/" css={S.styledLink}>
            Mariage
          </Link>
        </S.Logo>
        <Nav
          onMouseEnter={handleShowDropdown}
          onMouseLeave={handleHideDropdown}
          handleMouseOver={handleShowDropdown}
          showDropdown={showDropdown}
        />
        <Search />
        <S.Member>
          <Link to="/" css={S.styledLink}>
            로그인
          </Link>
          <Link to="/" css={S.styledLink}>
            회원가입
          </Link>
        </S.Member>
        <S.Block />
      </S.Container>
    </>
  );
}

export default Header2;
