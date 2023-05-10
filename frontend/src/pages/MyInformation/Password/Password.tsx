import { useState, FormEvent } from 'react';
import * as S from './Password.styled';
import axios from 'axios';

function Password() {
  const [Password, setPassword] = useState('');
  const [Newpassword, setNewPassword] = useState('');
  const [Checkpassword, setCheckPassword] = useState('');

  const handleChangePassword = () => {
    axios
      .post('/api/changePassword', {
        Password,
        Newpassword,
        Checkpassword,
      })
      .then(response => {
        setPassword('');
        setNewPassword('');
        setCheckPassword('');
      })
      .catch(error => {
        console.error(error);
      });
  };
  return (
    <S.Container>
      <S.Label>현재 비밀번호</S.Label>
      <S.Input
        type="password"
        name="Password"
        id="Password"
        placeholder="현재 비밀번호를 입력해주세요."
        onChange={e => setPassword(e.target.value)}
      />
      <S.Label>새로운 비밀번호</S.Label>
      <S.Input
        type="password"
        name="Newpassword"
        id="Newpassword"
        placeholder="새로운 비밀번호를 입력해주세요."
        onChange={e => setNewPassword(e.target.value)}
      />
      <S.Label>비밀번호 확인</S.Label>
      <S.Input
        type="password"
        name="Checkpassword"
        id="Checkpassword"
        placeholder="확인을 위해 비밀번호를 다시 입력해주세요."
        onChange={e => setCheckPassword(e.target.value)}
      />
      <S.Btn type="submit" onClick={handleChangePassword}>
        비밀번호 변경
      </S.Btn>
    </S.Container>
  );
}

export default Password;
