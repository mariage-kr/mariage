type SignupUserType = {
  name: string;
  email: string;
  password: string;
  nickname: string;
  birth: string;
};

type LoginUserType = {
  email: string;
  password: string;
};

type UserInfoType = {
  nickname: string;
  email: string;
  imagePath: string;
  birth: string;
};

export { SignupUserType, LoginUserType, UserInfoType };
