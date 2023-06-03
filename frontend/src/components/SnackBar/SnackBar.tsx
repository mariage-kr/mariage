import { useState } from 'react';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './SnackBar.styled';

function Snackbar() {
  const [option, setOption] = useState<string>('review');
  /* UseEffect */

  /* TODO: 로그인 관련 */
  if (option === 'login') {
    return (
      <S.Container>
        <S.Text>로그인이 필요한 기능입니다.</S.Text>
        <S.LinkText to={BROWSER_PATH.LOGIN}>로그인 하러가기⏎</S.LinkText>
      </S.Container>
    );
  }

  /* TODO: 새로운 리뷰 관련 */
  if (option === 'review') {
    return (
      <S.Container>
        <S.Text>새로운 리뷰가 작성되었습니다.</S.Text>
        <S.BtnText
          onClick={() => {
            window.location.reload();
          }}
        >
          새로고침⏎
        </S.BtnText>
      </S.Container>
    );
  }
  /* TODO: 오류 관련 */
  return (
    <S.Container>
      <S.Text>에러..</S.Text>
    </S.Container>
  );
}

export default Snackbar;
