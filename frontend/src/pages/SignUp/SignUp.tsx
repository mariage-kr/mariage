import useInput from '../../hooks/useInput';

import * as S from './SignUp.styled';

function SignUp() {
  const { value: name, setValue: setName } = useInput();
  const { value: email, setValue: setEmail } = useInput();
  const { value: password, setValue: setPassword } = useInput();
  const { value: confirmPassword, setValue: setConfirmPassword } = useInput();
  const { value: nickname, setValue: setNickname } = useInput();
  const { value: birth, setValue: setBirth } = useInput();

  return (
    <S.Container>
      <S.Header>회원가입</S.Header>
      <S.Wrapper>
        <S.Label>이름</S.Label>
        <S.Input type={'text'} value={name} onChange={setName} required />
        <S.Label>이메일</S.Label>
        <S.Input type={'text'} value={email} onChange={setEmail} required />
        <S.Label>비밀번호</S.Label>
        <S.Input
          type={'password'}
          value={password}
          onChange={setPassword}
          required
        />
        <S.Label>비밀번호 확인</S.Label>
        <S.Input
          type={'password'}
          value={confirmPassword}
          onChange={setConfirmPassword}
          required
        />
        <S.Label>닉네임</S.Label>
        <S.Input
          type={'text'}
          value={nickname}
          onChange={setNickname}
          required
        />
        <S.Label>생년월일</S.Label>
        <S.Input type={'date'} value={birth} onChange={setBirth} required />
        <S.Button>가입하기</S.Button>
      </S.Wrapper>
    </S.Container>
  );
}

export default SignUp;
