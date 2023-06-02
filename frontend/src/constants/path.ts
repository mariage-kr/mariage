const API_PATH = {
  AUTH: {
    LOGIN: '/api/auth/login',
    LOGOUT: '/api/user/auth/logout',
    REISSUE: '/api/auth/reissue',
  },
  CATEGORY: {
    COUNTRY: '/api/country/find',
    DRINK: {
      UPPER: '/api/categories/upper',
      LOWER: '/api/categories/lower',
    },
    FOOD: '/api/categories/food',
  },
  MEMBER: {
    SIGNUP: '/api/members/signup',
    INFO: '/api/user/members/info',
    NICKNAME: '/api/user/members/nickname',
    PROFILE: '/api/user/members/profile',
    PASSWORD: '/api/user/members/password',
    IMAGE: '/api/user/members/image',
  },
  LIKE: '/api/user/review/like',
  PRODUCT: {
    SAVE: '/api/user/product/save',
    INFO: '/api/user/product/info',
    UPDATE: '/api/user/product/update',
    IMAGE: '/api/user/product/image',
    FILTER: '/api/product/find/filter',
    DETAIL: '/api/product/detail',
    RECOMMEND: {
      DATE: '/api/product/recommend/date',
      WEATHER: '/api/product/recommend/weather',
    },
  },
  REVIEW: {
    PRODUCT: '/api/review/product',
    SAVE: '/api/user/review/save',
    DELETE: '/api/user/review',
  },
  STORAGE: '/api/user/storage/image',
};

const BROWSER_PATH = {
  BASE: '/',
  ADMIN: '/admin',
  DETAIL: '/detail',
  LOGIN: '/login',
  MY: '/my',
  PRODUCT: '/product',
  SIGN_UP: '/signup',
  REVIEW: '/review',
  TEST: '/test' /* prod 때는 삭제 */,
};

export { API_PATH, BROWSER_PATH };
