import { MEMBER_RULE } from '../../constants/rule';

interface isValidSignupDataProp {
  isValidName: boolean;
  isValidEmail: boolean;
  isValidPassword: boolean;
  isValidNickname: boolean;
}

const passwordRegExp = `^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{${MEMBER_RULE.PASSWORD.MIN_LENGTH},${MEMBER_RULE.PASSWORD.MAX_LENGTH}}$`;

const checkValidPassword = (password: string) => {
  const regex = new RegExp(passwordRegExp);

  return regex.test(password);
};

export { checkValidPassword };
