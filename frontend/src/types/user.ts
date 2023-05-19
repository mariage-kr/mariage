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

type UserProfileType = {
  nickname: string;
  email: string;
  imagePath: string;
  birth: string;
};

type UserInfoType = {
  id: number;
  nickname: string;
};

export { SignupUserType, LoginUserType, UserProfileType, UserInfoType };
