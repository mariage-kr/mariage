import { axios } from '../axios';
import { API_PATH } from '@/constants/path';
import { LoginUser } from '@/types/user';

const requestLogin = (userData: LoginUser) => {
  return axios.post(API_PATH.AUTH.LOGIN, userData);
};

export { requestLogin };
