import { BROWSER_PATH } from '@/constants/path';
import LogoIcon from '@/assets/png/footericon.png';
import * as S from './Footer.styled';

function Footer() {
  return (
    <>
      <S.Container>
        <S.StyledLink to={BROWSER_PATH.BASE}>
          <S.FLogo>
            <S.LogoText>Mariage</S.LogoText>
            <S.Icon><S.IconImg src={LogoIcon}/></S.Icon>
          </S.FLogo>
        </S.StyledLink>
        <S.Member>
          김미림 김아민 김정욱 <br /> 박혜리 신수민
        </S.Member>
      </S.Container>
    </>
  );
}

export default Footer;
