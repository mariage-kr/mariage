import { axios, axiosWithAccessToken } from '../axios';
import { API_PATH } from '@/constants/path';
import { LoginUser } from '@/types/user';

const requestLogin = (userData: LoginUser) => {
  return axios.post(API_PATH.AUTH.LOGIN, userData);
};

const requestLogout = () => {
  console.log('RUN REQUEST_LOGOUT');
  return axiosWithAccessToken.delete(API_PATH.AUTH.LOGOUT);
};

export { requestLogin, requestLogout };
