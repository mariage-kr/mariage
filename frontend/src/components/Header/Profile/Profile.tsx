import { BROWSER_PATH } from '@/constants/path';

import * as S from './Profile.styled';
import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

function Profile() {
  const { key } = useLocation();
  const [isLogin, setIsLogin] = useState<boolean>(false);

  const handlerIsLogin = () => {
    setIsLogin(window.sessionStorage.getItem('isLogin') === 'true');
  };

  const onClickLogout = () => {
    window.sessionStorage.removeItem('isLogin');
    handlerIsLogin();
  };

  useEffect(() => {
    handlerIsLogin();
  }, [key]);

  if (isLogin) {
    return (
      <S.Container>
        <S.StyledLink to={BROWSER_PATH.LOGIN}>로그인</S.StyledLink>
        <S.TextButton onClick={onClickLogout}>로그아웃</S.TextButton>
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
