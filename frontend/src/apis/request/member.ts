import { axios, axiosWithAccessToken } from '../axios';
import { API_PATH } from '@/constants/path';
import { SignupUser } from '@/@types/user';

const requestSignup = (userData: SignupUser) => {
  return axios.post(API_PATH.MEMBER.SIGNUP, userData);
};

const requestUserNickname = () => {
  return axiosWithAccessToken.get(API_PATH.MEMBER.NICKNAME);
};

const requestUserInfo = () => {
  return axiosWithAccessToken.get(API_PATH.MEMBER.MY.INFO);
};

const requestUpdateNickname = (nickname: string) => {
  return axiosWithAccessToken.patch(API_PATH.MEMBER.NICKNAME, nickname);
};

export {
  requestSignup,
  requestUserNickname,
  requestUserInfo,
  requestUpdateNickname,
};
