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
  PAGE_SIZE: 5,
};

export { MEMBER_RULE, PAGING };
