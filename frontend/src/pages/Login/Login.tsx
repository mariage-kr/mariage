import { useLocation } from 'react-router-dom';

import { requestLogin } from '@/apis/request/auth';
import { Token } from '@/types/user';
import useAuth from '@/hooks/useAuth';
import useInput from '@/hooks/useInput';

import * as S from './Login.styled';

function Login() {
  const location = useLocation();

  const { setLogin, setAuth } = useAuth();

  const { value: email, setValue: setEmail } = useInput('');
  const { value: password, setValue: setPassword } = useInput('');

  const login = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    requestLogin({ email, password })
      .then(response => {
        const token: Token = {
          accessToken: response.data.accessToken,
          refreshToken: response.data.refreshToken,
        };
        setLogin(true);
        setAuth(token);
      })
      .catch(error => {
        console.error(error);
      });
  };

  return (
    <S.Container>
      <S.Header>로그인 페이지</S.Header>
      <S.Form onSubmit={login}>
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
