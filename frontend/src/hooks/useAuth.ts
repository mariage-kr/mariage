import { useRecoilState } from 'recoil';

import {
  accessTokenState,
  isLoginState,
  refreshTokenState,
} from '@/store/status';

import { Token } from '@/types/user';

const useAuth = () => {
  const [isLogin, setIsLogin] = useRecoilState(isLoginState);
  const [accessToken, setAccessToken] = useRecoilState(accessTokenState);
  const [refreshToken, setRefreshToken] = useRecoilState(refreshTokenState);

  const setLogin = (status: boolean) => {
    setIsLogin(status);
  };

  const setAuth = ({ accessToken, refreshToken }: Token) => {
    setAccessToken(accessToken);
    setRefreshToken(refreshToken);
  };

  const resetAuth = () => {
    setIsLogin(false);
    setAccessToken('');
    setRefreshToken('');
  };

  return {
    setLogin,
    accessToken,
    setAccessToken,
    refreshToken,
    setAuth,
    resetAuth,
  };
};

export default useAuth;
