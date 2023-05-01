import { MEMBER_RULE } from '../../constants/rule';

interface isValidSignupDataProp {
  isValidName: boolean;
  isValidEmail: boolean;
  isValidPassword: boolean;
  isValidNickname: boolean;
}

const nameRegExp = `^[가-힣]{${MEMBER_RULE.NAME.MIN_LENGTH},${MEMBER_RULE.NAME.MAX_LENGTH}}$`;
const emailRegExp =
  "([!#-'*+/-9=?A-Z^-~-]+(.[!#-'*+/-9=?A-Z^-~-]+)*|\"([]!#-[^-~ \t]|(\\[\t -~]))+\")@([!#-'*+/-9=?A-Z^-~-]+(.[!#-'*+/-9=?A-Z^-~-]+)*|[[\t -Z^-~]*])";
const passwordRegExp = `^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{${MEMBER_RULE.PASSWORD.MIN_LENGTH},${MEMBER_RULE.PASSWORD.MAX_LENGTH}}$`;
const nicknameRegExp = `^[a-zA-Z가-힣0-9]{${MEMBER_RULE.NICKNAME.MIN_LENGTH},${MEMBER_RULE.NICKNAME.MAX_LENGTH}}$`;

const checkValidName = (name: string) => {
  const regex = new RegExp(nameRegExp);

  return regex.test(name);
};

const checkValidEmail = (email: string) => {
  const regex = new RegExp(emailRegExp);

  return regex.test(email);
};

const checkValidPassword = (password: string) => {
  const regex = new RegExp(passwordRegExp);

  return regex.test(password);
};

const checkValidNickname = (nickname: string) => {
  const regex = new RegExp(nicknameRegExp);

  return regex.test(nickname);
};

export {
  checkValidName,
  checkValidEmail,
  checkValidPassword,
  checkValidNickname,
};
