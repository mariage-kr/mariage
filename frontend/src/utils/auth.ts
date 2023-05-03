const isLoginProvider = {
  get: () => {
    return sessionStorage.getItem('isLogin') ?? '';
  },
  set: (isLogin: string) => {
    sessionStorage.setItem('isLogin', isLogin);
  },
  remove: () => {
    sessionStorage.removeItem('isLogin');
  },
};

export { isLoginProvider };
