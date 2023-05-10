import { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

import { requestLogout } from '@/apis/request/auth';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './Profile.styled';
import useNickname from '@/hooks/useNickname';

function User() {
  const { key } = useLocation();
  const navigate = useNavigate();

  const { value: nickname, setValue: setNickname } = useNickname();
  const [isLogin, setIsLogin] = useState<boolean>(false);

  const handlerIsLogin = () => {
    setIsLogin(window.sessionStorage.getItem('isLogin') === 'true');
  };

  const removeIsLogin = () => {
    window.sessionStorage.removeItem('isLogin');
    handlerIsLogin();
  };

  const logout = () => {
    requestLogout()
      .then(() => {
        removeIsLogin();
        navigate(BROWSER_PATH.BASE);
        window.location.reload();
      })
      .catch(error => {
        console.log(error);
      });
  };

  useEffect(() => {
    if (nickname) {
      return;
    }
    setNickname();
  }, []);

  useEffect(() => {
    handlerIsLogin();
  }, [key]);

  if (isLogin) {
    return (
      <S.Container>
        <S.StyledLink to={BROWSER_PATH.MY}>{nickname}님</S.StyledLink>
        <S.TextButton onClick={logout}>로그아웃</S.TextButton>
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

export default User;
