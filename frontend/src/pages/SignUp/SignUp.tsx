import { useNavigate } from 'react-router-dom';

import { requestSignup } from '../../apis/request/auth';
import useInput from '../../hooks/useInput';

import * as S from './SignUp.styled';
import { BROWSER_PATH } from '../../constants/path';
import { useEffect, useState } from 'react';
import { MEMBER_RULE } from '../../constants/rule';
import {
  checkValidEmail,
  checkValidName,
  checkValidPassword,
} from './Validate';

function SignUp() {
  const navigate = useNavigate();

  const { value: name, setValue: setName } = useInput('');
  const { value: email, setValue: setEmail } = useInput('');
  const { value: password, setValue: setPassword } = useInput('');
  const { value: confirmPassword, setValue: setConfirmPassword } = useInput('');
  const { value: nickname, setValue: setNickname } = useInput('');
  const { value: birth, setValue: setBirth } = useInput('');

  const [isValidName, setIsValidName] = useState(true);
  const [isValidEmail, setIsValidEmail] = useState(true);
  const [isValidPassword, setIsValidPassword] = useState(true);
  const [isValidConfirmPassword, setIsValidConfirmPassword] = useState(true);
  const [isValidNickname, setIsValidNickname] = useState(true);
  const [isValidBirth, setIsValidBirth] = useState(true);

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
    setIsValidBirth(birth.length === 0);
  }, [birth]);

  const signup = () => {
    const baseURL = process.env.BASE_URL;
    console.log(baseURL);
    requestSignup({ name, email, password, nickname, birth })
      .then(() => {
        console.log('su');
        navigate(BROWSER_PATH.LOGIN);
      })
      .catch(error => {
        console.error(error);
      });
  };

  return (
    <S.Container>
      <S.Header>회원가입</S.Header>
      <S.Wrapper>
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
          자 사이여야 합니다.
        </S.InfoMessage>
        <S.Label>생년월일</S.Label>
        <S.Input type={'date'} value={birth} onChange={setBirth} required />
        <S.InfoMessage isValid={isValidBirth}>
          생년월일은 공백일 수 없습니다.
        </S.InfoMessage>
        <S.Button type={'submit'} onClick={signup}>
          가입하기
        </S.Button>
      </S.Wrapper>
    </S.Container>
  );
}

export default SignUp;
