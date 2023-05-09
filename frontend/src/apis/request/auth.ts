import { axios, axiosWithAccessToken } from '../axios';
import { API_PATH } from '@/constants/path';
import { LoginUser } from '@/types/user';

const requestLogin = (userData: LoginUser) => {
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

export { requestLogin, requestAxiosLogout, requestLogout };
