import { axios, axiosWithAccessToken } from '../axios';
import { API_PATH } from '@/constants/path';
import { SignupUserType } from '@/@types/user';

const requestSignup = (userData: SignupUserType) => {
  return axios.post(API_PATH.MEMBER.SIGNUP, userData);
};

const requestUserNickname = () => {
  return axiosWithAccessToken.get(API_PATH.MEMBER.INFO);
};

const requestUserInfo = () => {
  return axiosWithAccessToken.get(API_PATH.MEMBER.INFO);
};

const requestUserProfile = () => {
  return axiosWithAccessToken.get(API_PATH.MEMBER.PROFILE);
};

const requestUpdateImage = (file: FormData) => {
  return axiosWithAccessToken.post(API_PATH.MEMBER.IMAGE, file, {
    headers: {
      'Content-Type': 'multipart/form-data',
  }});
};

const requestDeleteImage = () => {
  return axiosWithAccessToken.patch(API_PATH.MEMBER.IMAGE);
};

const requestUpdateNickname = (nickname: string) => {
  return axiosWithAccessToken.patch(API_PATH.MEMBER.NICKNAME, nickname);
};

const requestUpdatePassword = (password: string, newPassword: string) => {
  return axiosWithAccessToken.patch(API_PATH.MEMBER.PASSWORD, {password, newPassword})
}

const requestReviewProfile = (memberId: number) => {
  return axios.get(`/api/review/${memberId}`)
}


export {
  requestSignup,
  requestUserNickname,
  requestUserInfo,
  requestUserProfile,
  requestUpdateImage,
  requestDeleteImage,
  requestUpdateNickname,
  requestUpdatePassword,
  requestReviewProfile
};
