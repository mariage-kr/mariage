import { BROWSER_PATH } from '@/constants/path';

import * as S from './Profile.styled';

function Profile() {
  const isLogin: boolean = window.sessionStorage.getItem('isLogin') === 'true';

  console.log(isLogin);

  if (isLogin) {
    return (
      <S.Container>
        <S.StyledLink to={BROWSER_PATH.LOGIN}>로그인</S.StyledLink>
        <S.TextButton>로그아웃</S.TextButton>
      </S.Container>
    );
  }

  return (
    <S.Container>
      <S.StyledLink to={BROWSER_PATH.LOGIN}>로그인</S.StyledLink>
      <S.StyledLink to={BROWSER_PATH.SIGN_UP}>회원가입</S.StyledLink>
    </S.Container>
  );
}

export default Profile;
