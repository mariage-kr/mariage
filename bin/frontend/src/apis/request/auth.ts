import { axios, axiosWithAccessToken } from '../axios';
import { API_PATH } from '@/constants/path';
import { Token } from '@/@types/token';
import { LoginUserType } from '@/@types/user';

const requestLogin = (userData: LoginUserType) => {
  return axios.post(API_PATH.AUTH.LOGIN, userData);
};

const requestAxiosLogout = (accessToken: string) => {
  return axios.delete(API_PATH.AUTH.LOGOUT, {
    headers: {
      Authorization: `Bearer ${accessToken}`,
    },
  });
};

const requestLogout = () => {
  return axiosWithAccessToken.delete(API_PATH.AUTH.LOGOUT);
};

const requestReissue = (Token: Token) => {
  return axios.post(API_PATH.AUTH.REISSUE, Token);
};

export { requestLogin, requestAxiosLogout, requestLogout, requestReissue };
