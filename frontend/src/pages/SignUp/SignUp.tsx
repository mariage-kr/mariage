import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { requestSignup } from '@/apis/request/member';
import useInput from '@/hooks/useInput';
import { BROWSER_PATH } from '@/constants/path';
import { MEMBER_RULE } from '@/constants/rule';
import {
  checkValidEmail,
  checkValidName,
  checkValidNickname,
  checkValidPassword,
} from './Validate';

import * as S from './SignUp.styled';

function SignUp() {
  const navigate = useNavigate();

  const [errorMessage, setErrorMessage] = useState<string>('');
  const { value: name, setValue: setName } = useInput<string>('');
  const { value: email, setValue: setEmail } = useInput<string>('');
  const { value: password, setValue: setPassword } = useInput<string>('');
  const { value: confirmPassword, setValue: setConfirmPassword } =
    useInput<string>('');
  const { value: nickname, setValue: setNickname } = useInput<string>('');
  const { value: birth, setValue: setBirth } = useInput<string>('');

  const [isValid, setIsValid] = useState<boolean>(false);
  const [isValidName, setIsValidName] = useState<boolean>(true);
  const [isValidEmail, setIsValidEmail] = useState<boolean>(true);
  const [isValidPassword, setIsValidPassword] = useState<boolean>(true);
  const [isValidConfirmPassword, setIsValidConfirmPassword] =
    useState<boolean>(true);
  const [isValidNickname, setIsValidNickname] = useState<boolean>(true);
  const [isValidBirth, setIsValidBirth] = useState<boolean>(true);
  const [isValidNull, setIsValidNull] = useState<boolean>(true);

  const isNull = () => {
    if (
      isValidName ||
      isValidEmail ||
      isValidPassword ||
      isValidConfirmPassword ||
      isValidNickname ||
      isValidBirth
    ) {
      return true;
    }
    return false;
  };

  useEffect(() => {
    setIsValidName(!checkValidName(name));
  }, [name]);

  useEffect(() => {
    setIsValidPassword(!checkValidPassword(password));
    setIsValidConfirmPassword(password !== confirmPassword);
  }, [password, confirmPassword]);

  useEffect(() => {
    setIsValidEmail(!checkValidEmail(email));
  }, [email]);

  useEffect(() => {
    setIsValidNickname(!checkValidNickname(nickname));
  }, [nickname]);

  useEffect(() => {
    setIsValidBirth(birth.length === 0);
  }, [birth]);

  useEffect(() => {
    setIsValidNull(isNull());
  }, [isNull]);

  const signup = () => {
    requestSignup({ name, email, password, nickname, birth })
      .then(() => {
        navigate(BROWSER_PATH.LOGIN);
      })
      .catch(error => {
        setErrorMessage(error.response.data.message);
        setIsValid(true);
      });
  };

  return (
    <S.Container>
      <S.Header>회원가입</S.Header>
      <S.Form>
        {isValid && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
        <S.Label>이름</S.Label>
        <S.Input
          type={'text'}
          value={name}
          onChange={setName}
          maxLength={MEMBER_RULE.NAME.MAX_LENGTH}
          required
        />
        <S.InfoMessage isValid={isValidName}>
          {MEMBER_RULE.NAME.MIN_LENGTH} ~ {MEMBER_RULE.NAME.MAX_LENGTH}자의
          한글로 이루어져야 합니다.
        </S.InfoMessage>
        <S.Label>이메일</S.Label>
        <S.Input type={'text'} value={email} onChange={setEmail} required />
        <S.InfoMessage isValid={isValidEmail}>
          올바르지 않은 이메일 형식입니다.
        </S.InfoMessage>
        <S.Label>비밀번호</S.Label>
        <S.Input
          type={'password'}
          value={password}
          onChange={setPassword}
          maxLength={MEMBER_RULE.PASSWORD.MAX_LENGTH}
          required
        />
        <S.InfoMessage isValid={isValidPassword}>
          {MEMBER_RULE.PASSWORD.MIN_LENGTH} ~ {MEMBER_RULE.PASSWORD.MAX_LENGTH}
          자이며 영어, 숫자, 특수문자가 포함되어야 합니다.
        </S.InfoMessage>
        <S.Label>비밀번호 확인</S.Label>
        <S.Input
          type={'password'}
          value={confirmPassword}
          onChange={setConfirmPassword}
          maxLength={MEMBER_RULE.PASSWORD.MAX_LENGTH}
          required
        />
        <S.InfoMessage isValid={isValidConfirmPassword}>
          비밀번호가 일치하지 않습니다.
        </S.InfoMessage>
        <S.Label>닉네임</S.Label>
        <S.Input
          type={'text'}
          value={nickname}
          onChange={setNickname}
          maxLength={MEMBER_RULE.NICKNAME.MAX_LENGTH}
          required
        />
        <S.InfoMessage isValid={isValidNickname}>
          {MEMBER_RULE.NICKNAME.MIN_LENGTH} ~ {MEMBER_RULE.NICKNAME.MAX_LENGTH}
          자 사이이며 영어, 한글, 숫자로 구성됩니다.
        </S.InfoMessage>
        <S.Label>생년월일</S.Label>
        <S.Input type={'date'} value={birth} onChange={setBirth} required />
        <S.InfoMessage isValid={isValidBirth}>
          생년월일은 공백일 수 없습니다.
        </S.InfoMessage>
        {isValidNull ? (
          <S.DisableButton disabled>가입하기</S.DisableButton>
        ) : (
          <S.Button type={'button'} onClick={signup}>
            가입하기
          </S.Button>
        )}
      </S.Form>
    </S.Container>
  );
}

export default SignUp;
