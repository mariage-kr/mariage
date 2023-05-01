import * as S from './SignUp.styled';
import useInput from '../../hooks/useInput';

function SignUp() {
  const { value: email, setValue: setEmail } = useInput();

  return (
    <div>
      <h1>회원가입 페이지</h1>
      <S.Input type={'text'} value={email} onChange={setEmail} required />
      <p>{email}</p>
    </div>
  );
}

export default SignUp;
