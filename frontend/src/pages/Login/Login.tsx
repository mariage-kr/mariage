import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { requestLogin } from '@/apis/request/auth';
import { Token } from '@/types/user';
import useAuth from '@/hooks/useAuth';
import useInput from '@/hooks/useInput';

import * as S from './Login.styled';
import { BROWSER_PATH } from '@/constants/path';

function Login() {
  const navigate = useNavigate();

  const { setLogin, setAuth } = useAuth();

  const [isValid, setIsValid] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');

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
        // navigate(-1);
      })
      .catch(error => {
        setIsValid(true);
        setErrorMessage(error.response.data.message);
      });
  };

  return (
    <S.Container>
      <S.StyledLink to={BROWSER_PATH.BASE}>
        <S.Header>Mariage</S.Header>
      </S.StyledLink>
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
        {isValid && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
        <S.Button type={'submit'}>로그인</S.Button>
      </S.Form>
    </S.Container>
  );
}

export default Login;
