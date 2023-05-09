const API_PATH = {
  AUTH: {
    LOGIN: '/api/auth/login',
    LOGOUT: '/api/user/auth/logout',
  },
  MEMBER: {
    SIGNUP: '/api/members/signup',
  },
};

const BROWSER_PATH = {
  BASE: '/',
  DETAIL: '/detail',
  LOGIN: '/login',
  MY: '/my',
  PRODUCT: '/product',
  SIGN_UP: '/signup',
  TEST: '/test' /* prod 때는 삭제 */,
};

export { API_PATH, BROWSER_PATH };
