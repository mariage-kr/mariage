const MEMBER_RULE = {
  NAME: {
    MIN_LENGTH: 2,
    MAX_LENGTH: 30,
  },
  PASSWORD: {
    MIN_LENGTH: 8,
    MAX_LENGTH: 16,
  },
  NICKNAME: {
    MIN_LENGTH: 2,
    MAX_LENGTH: 12,
  },
};

const PAGING = {
  PAGE_SIZE: 20,
};

const PARAM = {
  RATE: {
    MIN: 0,
    MAX: 5,
  },
  LEVEL: {
    MIN: 0,
    MAX: 70,
  },
};

const RECOMMEND_PRODUCT_SIZE = 20;

export { MEMBER_RULE, PAGING, RECOMMEND_PRODUCT_SIZE, PARAM };
