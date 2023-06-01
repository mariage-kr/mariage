import { useState, useEffect } from 'react';
import { useRecoilValue } from 'recoil';

import LogoIcon from '@/assets/png/footericon.png';
import MembersInfo from './MembersInfo/MembersInfo';
import DrinkInfo from './Drink/DrinkInfo';
import User from '../Header/User/Profile';
import * as S from './Footer.styled';
import gitHub from '@/assets/png/github-mark.png';

import { BROWSER_PATH } from '@/constants/path';
import { useDrinkUpperCategory } from '@/hooks/useCategory';
import { CategoryType } from '@/@types/category';
import { isLoginProvider } from '@/utils/auth';

function Footer() {
  const { value: category, setValue: setCategory } = useDrinkUpperCategory();

  const isLogin = isLoginProvider;

  useEffect(() => {
    setCategory;
  }, []);

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

  useEffect(() => {
    window.addEventListener('scroll', handleScroll);
    return () => window.removeEventListener('scroll', handleScroll);
  }, []);

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
        <S.ContentWrapper>
          {category.map((category: CategoryType, index: number) => {
            return (
              <DrinkInfo
                value={category.value}
                region={category.region}
                categories={category.categories}
                key={index}
              />
            );
          })}
          <S.Mark src={gitHub} />
        </S.ContentWrapper>
        {/* <MembersInfo /> */}
      </S.Container>
      <S.TextContainer>
        <S.FooterText>
          Copyright © 2023 Mariage. All rights reserved.
        </S.FooterText>
        <S.UserArea>
          <User />
        </S.UserArea>
      </S.TextContainer>
    </>
  );
}

export default Footer;
