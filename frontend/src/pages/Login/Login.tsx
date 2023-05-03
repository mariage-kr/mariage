import useInput from '@/hooks/useInput';

import * as S from './Login.styled';

function Login() {
  const { value: email, setValue: setEmail } = useInput('');
  const { value: password, setValue: setPassword } = useInput('');

  return (
    <S.Container>
      <S.Header>로그인 페이지</S.Header>
      <S.Form>
        <S.Label>이름</S.Label>
        <S.Input type={'text'} value={email} onChange={setEmail} required />
        <S.Label>비밀번호</S.Label>
        <S.Input
          type={'password'}
          value={password}
          onChange={setPassword}
          required
        />
        <S.Button type={'submit'}>로그인</S.Button>
      </S.Form>
    </S.Container>
  );
}

export default Login;
