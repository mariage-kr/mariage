import { MEMBER_RULE } from '../../constants/rule';

interface isValidSignupDataProp {
  isValidName: boolean;
  isValidEmail: boolean;
  isValidPassword: boolean;
  isValidNickname: boolean;
}

const nameRegExp = `^[가-힣]{${MEMBER_RULE.NAME.MIN_LENGTH},${MEMBER_RULE.NAME.MAX_LENGTH}}$`;
const passwordRegExp = `^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{${MEMBER_RULE.PASSWORD.MIN_LENGTH},${MEMBER_RULE.PASSWORD.MAX_LENGTH}}$`;

const checkValidName = (name: string) => {
  const regex = new RegExp(nameRegExp);

  return regex.test(name);
};

const checkValidPassword = (password: string) => {
  const regex = new RegExp(passwordRegExp);

  return regex.test(password);
};

export { checkValidName, checkValidPassword };
