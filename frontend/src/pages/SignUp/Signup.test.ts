import {
  checkValidName,
  checkValidEmail,
  checkValidPassword,
  checkValidNickname,
} from './Validate';

describe('회원가입 창의 입력값을 검증할 수 있다.', () => {
  it('입력한 이름이 적절하면 true를 반환한다.', () => {
    const 이름 = '마리';

    expect(checkValidName(이름)).toBe(true);
  });

  it('입력한 이름이 적절하지 않으면 false를 반환한다.', () => {
    const 짧은_이름 = '가';
    const 긴_이름 = '가'.repeat(31);
    const 한글이_아님 = 'abc';

    expect(checkValidName(짧은_이름)).toBe(false);
    expect(checkValidName(긴_이름)).toBe(false);
    expect(checkValidName(한글이_아님)).toBe(false);
  });

  it('입력한 이메일이 적절하면 true를 반환한다.', () => {
    const 이메일 = 'mari1234@gmail.com';

    expect(checkValidEmail(이메일)).toBe(true);
  });

  it('입력한 이메일이 적절하지 않으면 false를 반환한다.', () => {
    const 아이디_없음 = '@gmail.com';
    const 도메인주소_없음 = 'mari1234@';

    expect(checkValidEmail(아이디_없음)).toBe(false);
    expect(checkValidEmail(도메인주소_없음)).toBe(false);
  });

  it('입력한 패스워드가 적절하면 true를 반환한다.', () => {
    const 비밀번호 = 'abcd1234!@';

    expect(checkValidPassword(비밀번호)).toBe(true);
  });

  it('입력한 패스워드가 적절하지 않으면 false를 반환한다.', () => {
    const 짧은_비밀번호 = 'abc123!';
    const 긴_비밀번호 = 'abcdefg1234567!!!';
    const 숫자_없음 = 'abcdefg!!';
    const 영어_없음 = '1234567!!';
    const 특수문자_없음 = 'abcde12345';

    expect(checkValidPassword(짧은_비밀번호)).toBe(false);
    expect(checkValidPassword(긴_비밀번호)).toBe(false);
    expect(checkValidPassword(숫자_없음)).toBe(false);
    expect(checkValidPassword(영어_없음)).toBe(false);
    expect(checkValidPassword(특수문자_없음)).toBe(false);
  });

  it('입력한 닉네임이 적절하면 true를 반환한다.', () => {
    const 닉네임 = '마리';

    expect(checkValidNickname(닉네임)).toBe(true);
  });

  it('입력한 이메일이 적절하지 않으면 false를 반환한다.', () => {
    const 특수문자_있음 = '마리!';
    const 자음_있음 = 'ㅁ리';
    const 모음_있음 = 'ㅏ리';

    expect(checkValidNickname(특수문자_있음)).toBe(false);
    expect(checkValidNickname(자음_있음)).toBe(false);
    expect(checkValidNickname(모음_있음)).toBe(false);
  });
});
