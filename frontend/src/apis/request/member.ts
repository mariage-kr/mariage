import { axios } from '../axios';
import { API_PATH } from '@/constants/path';
import { SignupUser } from '@/types/user';

const requestSignup = (userData: SignupUser) => {
  return axios.post(API_PATH.MEMBER.SIGNUP, userData);
};

export { requestSignup };
