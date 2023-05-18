import { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

import { Token } from '@/@types/token';
import { requestLogout, requestReissue } from '@/apis/request/auth';
import { requestUserInfo } from '@/apis/request/member';
import { BROWSER_PATH } from '@/constants/path';
import useAuth from '@/hooks/useAuth';

import * as S from './Profile.styled';
import useUserInfo from '@/hooks/useUserInfo';

function User() {
  const { accessToken, refreshToken, setAuth, resetAuth, removeIsLogin } =
    useAuth();
  const { key } = useLocation();
  const navigate = useNavigate();

  const { userInfo, setUserInfo, resetUserInfo } = useUserInfo();
  const [isLogin, setIsLogin] = useState<boolean>(false);

  const handlerIsLogin = () => {
    setIsLogin(window.sessionStorage.getItem('isLogin') === 'true');
  };

  const logout = () => {
    requestLogout()
      .then(() => {
        resetAuth();
        handlerIsLogin();
        resetUserInfo();
        navigate(BROWSER_PATH.BASE);
      })
      .finally(() => {
        window.location.reload();
      });
  };

  useEffect(() => {
    handlerIsLogin();

    if (!isLogin || !accessToken || !refreshToken) {
      return;
    }

    const reissueToken = async () => {
      await requestReissue({ accessToken, refreshToken })
        .then(response => {
          const token: Token = {
            accessToken: response.data.accessToken,
            refreshToken: response.data.refreshToken,
          };
          setAuth({ ...token });
        })
        .catch(() => {
          removeIsLogin;
        });
    };

    const getUserInfo = async () => {
      await requestUserInfo()
        .then(response => {
          setUserInfo({ ...response.data });
        })
        .catch(() => {
          reissueToken();
        });
    };

    if (accessToken) {
      getUserInfo();
      return;
    }

    reissueToken();
  }, [key]);

  if (isLogin) {
    return (
      <S.Container>
        <S.StyledLink to={BROWSER_PATH.MY}>{userInfo?.nickname}님</S.StyledLink>
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
