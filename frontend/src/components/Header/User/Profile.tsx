import { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

import { requestLogout, requestReissue } from '@/apis/request/auth';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './Profile.styled';
import useNickname from '@/hooks/useNickname';
import useAuth from '@/hooks/useAuth';

function User() {
  const { accessToken, refreshToken, setAuth, resetAuth } = useAuth();
  const { key } = useLocation();
  const navigate = useNavigate();

  const { value: nickname, setValue: setNickname } = useNickname();
  const [isLogin, setIsLogin] = useState<boolean>(false);

  const handlerIsLogin = () => {
    setIsLogin(window.sessionStorage.getItem('isLogin') === 'true');
  };

  const logout = () => {
    requestLogout()
      .then(() => {
        handlerIsLogin();
        resetAuth();
        navigate(BROWSER_PATH.BASE);
      })
      .finally(() => {
        window.location.reload();
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

    if (!isLogin && !accessToken && !refreshToken) {
      return;
    }

    const reissueToken = () => {
      requestReissue({ accessToken, refreshToken })
        .then(response => {
          setAuth({ ...response.data });
        })
        .catch(() => {
          resetAuth();
        });
    };

    reissueToken();
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
