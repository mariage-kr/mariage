import { checkValidName, checkValidPassword } from './Validate';

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
});
