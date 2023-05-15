export interface SignupUser {
  name: string;
  email: string;
  password: string;
  nickname: string;
  birth: string;
}

export interface LoginUser {
  email: string;
  password: string;
}

export interface Token {
  accessToken: string;
  refreshToken: string;
}
