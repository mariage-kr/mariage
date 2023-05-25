import { isBoolean } from './boolean';

const isLoginProvider = {
  get: () => {
    return isBoolean(sessionStorage.getItem('isLogin'));
    // return sessionStorage.getItem('isLogin') ?? '';
  },
  set: (isLogin: string) => {
    sessionStorage.setItem('isLogin', isLogin);
  },
  remove: () => {
    sessionStorage.removeItem('isLogin');
  },
};

export { isLoginProvider };
