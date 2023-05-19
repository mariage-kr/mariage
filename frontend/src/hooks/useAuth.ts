import { useRecoilState } from 'recoil';

import { accessTokenState, refreshTokenState } from 'store/status';

import { Token } from 'types/token';

const useAuth = () => {
  const [accessToken, setAccessToken] = useRecoilState(accessTokenState);
  const [refreshToken, setRefreshToken] = useRecoilState(refreshTokenState);

  const setAuth = async ({
    accessToken: newAccessToken,
    refreshToken: newRefreshToken,
  }: Token) => {
    window.sessionStorage.setItem('isLogin', 'true');
    setAccessToken(newAccessToken);
    setRefreshToken(newRefreshToken);
    window.location.reload();
  };

  const resetAuth = () => {
    removeIsLogin();
    setAccessToken('');
    setRefreshToken('');
  };

  const removeIsLogin = () => {
    window.sessionStorage.removeItem('isLogin');
  };

  return {
    accessToken,
    setAccessToken,
    refreshToken,
    setAuth,
    resetAuth,
    removeIsLogin,
  };
};

export default useAuth;
