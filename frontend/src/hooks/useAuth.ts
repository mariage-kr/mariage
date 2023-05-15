import { useRecoilState } from 'recoil';

import {
  accessTokenState,
  isLoginState,
  refreshTokenState,
} from '@/store/status';

import { Token } from '@/@types/user';

const useAuth = () => {
  const [accessToken, setAccessToken] = useRecoilState(accessTokenState);
  const [refreshToken, setRefreshToken] = useRecoilState(refreshTokenState);

  const setAuth = ({ accessToken, refreshToken }: Token) => {
    window.sessionStorage.setItem('isLogin', 'true');
    setAccessToken(accessToken);
    setRefreshToken(refreshToken);
  };

  const resetAuth = () => {
    window.sessionStorage.removeItem('isLogin');
    setAccessToken('');
    setRefreshToken('');
  };

  return {
    accessToken,
    setAccessToken,
    refreshToken,
    setAuth,
    resetAuth,
  };
};

export default useAuth;
