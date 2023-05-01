import { API_PATH } from '../../constants/path';
import { SignupUser } from '../../types/user';
import { axios } from '../axios';

const requestSignup = (userData: SignupUser) => {
  return axios.post(API_PATH.AUTH.SIGNUP, userData);
};

export { requestSignup };
