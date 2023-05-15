import { useState, useEffect } from 'react';

import useInput from '@/hooks/useInput';
import { checkValidPassword } from '@/pages/SignUp/Validate';
import { MEMBER_RULE } from '@/constants/rule';

import * as S from './Password.styled';

function Password() {
  const { value: password, setValue: setPassword } = useInput<string>('');
  const { value: newPassword, setValue: setNewPassword } = useInput<string>('');
  const { value: confirmPassword, setValue: setConfirmPassword } =
    useInput<string>('');
  const [isValidConfirmPassword, setIsValidConfirmPassword] =
    useState<boolean>(true);
  const [isValidPassword, setIsValidPassword] = useState<boolean>(true);

  const isNull = (): boolean => {
    return !(isValidPassword && isValidConfirmPassword);
  };

  useEffect(() => {
    setIsValidPassword(!checkValidPassword(newPassword));
    setIsValidConfirmPassword(newPassword !== confirmPassword);
  }, [newPassword, confirmPassword]);

  const handleChangePassword = () => {
    if (isNull()) {
      return;
    }
  };

  return (
    <S.Container>
      <S.Label>현재 비밀번호</S.Label>
      <S.Input
        type="password"
        name="password"
        id="password"
        value={password}
        placeholder="현재 비밀번호를 입력해주세요."
        onChange={setPassword}
      />
      <S.Label>새로운 비밀번호</S.Label>
      <S.Input
        type="password"
        name="newPassword"
        id="newPassword"
        placeholder="새로운 비밀번호를 입력해주세요."
        onChange={setNewPassword}
      />
      <S.InfoMessage isValid={isValidPassword}>
        {MEMBER_RULE.PASSWORD.MIN_LENGTH} ~ {MEMBER_RULE.PASSWORD.MAX_LENGTH}
        자이며 영어, 숫자, 특수문자가 포함되어야 합니다.
      </S.InfoMessage>
      <S.Label>비밀번호 확인</S.Label>
      <S.Input
        type="password"
        name="confirmPassword"
        id="confirmPassword"
        placeholder="확인을 위해 비밀번호를 다시 입력해주세요."
        onChange={setConfirmPassword}
      />
      <S.InfoMessage isValid={isValidConfirmPassword}>
        비밀번호가 일치하지 않습니다.
      </S.InfoMessage>
      <S.Btn type="submit" onClick={handleChangePassword}>
        비밀번호 변경
      </S.Btn>
    </S.Container>
  );
}

export default Password;
