import { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

import { Token } from '@/@types/token';
import { requestLogout, requestReissue } from '@/apis/request/auth';
import { requestUserInfo } from '@/apis/request/member';
import { BROWSER_PATH } from '@/constants/path';
import useAuth from '@/hooks/useAuth';
import useUserInfo from '@/hooks/useUserInfo';
import { isLoginProvider } from '@/utils/auth';

import * as S from './Profile.styled';

function User() {
  const { accessToken, refreshToken, setAuth, resetAuth, removeIsLogin } =
    useAuth();
  const { key } = useLocation();
  const navigate = useNavigate();

  const { userInfo, setUserInfo, resetUserInfo } = useUserInfo();
  const [isLogin, setIsLogin] = useState<boolean>(isLoginProvider.get());

  const handlerIsLogin = () => {
    setIsLogin(isLoginProvider.get());
  };

  const logout = () => {
    requestLogout()
      .then(() => {
        resetAuth();
        handlerIsLogin();
        navigate(BROWSER_PATH.BASE);
      })
      .finally(() => {
        resetAuth();
        window.location.reload();
      });
  };

  useEffect(() => {
    handlerIsLogin();

    if (!isLoginProvider.get() || !accessToken || !refreshToken) {
      resetUserInfo();
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
        <S.Wrapper>
          <S.Wrap>
            <S.StyledLink to={`${BROWSER_PATH.REVIEW}/${userInfo?.id}`}>
              리뷰
            </S.StyledLink>
          </S.Wrap>
          <S.Wrap>
            <S.StyledLink to={BROWSER_PATH.MY}>
              {userInfo?.nickname}님
            </S.StyledLink>
          </S.Wrap>
          <S.Wrap>
            <S.TextButton onClick={logout}>로그아웃</S.TextButton>
          </S.Wrap>
        </S.Wrapper>
      </S.Container>
    );
  }

  return (
    <S.Container>
      <S.Wrapper2>
        <S.Wrap>
          <S.StyledLink to={BROWSER_PATH.LOGIN}>로그인</S.StyledLink>
        </S.Wrap>
        <S.Wrap>
          <S.StyledLink to={BROWSER_PATH.SIGN_UP}>회원가입</S.StyledLink>
        </S.Wrap>
      </S.Wrapper2>
    </S.Container>
  );
}

export default User;
