const API_PATH = {
  AUTH: {
    LOGIN: '/api/auth/login',
    LOGOUT: '/api/user/auth/logout',
  },
  CATEGORY: {
    DRINK: {
      UPPER: '/api/categories/upper',
      LOWER: '/api/categories/lower',
    },
  },
  MEMBER: {
    SIGNUP: '/api/members/signup',
    NICKNAME: '/api/user/members/nickname',
  },
};

const BROWSER_PATH = {
  BASE: '/',
  ADMIN: '/admin',
  DETAIL: '/detail',
  LOGIN: '/login',
  MY: '/my',
  PRODUCT: '/product',
  SIGN_UP: '/signup',
  TEST: '/test' /* prod 때는 삭제 */,
};

export { API_PATH, BROWSER_PATH };
