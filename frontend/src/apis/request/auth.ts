import { axios } from '../axios';
import { API_PATH } from '@/constants/path';
import { SignupUser } from '@/types/user';

const requestSignup = (userData: SignupUser) => {
  return axios.post(API_PATH.AUTH.SIGNUP, userData);
};

export { requestSignup };
