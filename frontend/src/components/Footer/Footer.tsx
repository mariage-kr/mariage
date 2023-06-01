import { useState, useEffect } from 'react';
import { useRecoilValue } from 'recoil';

import LogoIcon from '@/assets/png/footericon.png';
import gitHub from '@/assets/png/github-mark.png';
import * as S from './Footer.styled';

import { BROWSER_PATH } from '@/constants/path';

function Footer() {
  const [isMain, setIsMain] = useState(
    window.location.pathname === BROWSER_PATH.BASE,
  );

  const handleLogoClick = () => {
    if (isMain) {
      window.scroll({
        top: 0,
        behavior: 'smooth',
      });
    } else {
      window.location.href = BROWSER_PATH.BASE;
    }
  };

  const handleScroll = () => {
    setIsMain(window.scrollY === 0);
  };

  return (
    <>
      <S.Container>
        <S.StyledLink to={BROWSER_PATH.BASE} onClick={handleLogoClick}>
          <S.FLogo>
            <S.LogoText>Mariage</S.LogoText>
            <S.Icon>
              <S.IconImg src={LogoIcon} />
            </S.Icon>
          </S.FLogo>
        </S.StyledLink>
        <S.FooterText>
          Copyright © 2023 Mariage. All rights reserved.
        </S.FooterText>
        <S.Mark to="https://github.com/mariage-kr/mariage" target="_blank">
          <S.GitHubIcon src={gitHub} />
        </S.Mark>
      </S.Container>
    </>
  );
}

export default Footer;
