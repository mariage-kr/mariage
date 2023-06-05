import { useEffect, useState } from 'react';
import { useRecoilState } from 'recoil';

import { BROWSER_PATH } from '@/constants/path';
import { snackbarState } from '@/store/status';

import * as S from './SnackBar.styled';
import { SNACKBAR } from '@/constants/snackbar';

function Snackbar() {
  const [snackbarInfo, setSnackbarInfo] = useRecoilState(snackbarState);

  const [timer, setTimer] = useState<null | NodeJS.Timeout>(null);
  const [message, setMessage] = useState<null | string>(null);

  useEffect(() => {
    if (timer || snackbarInfo.message === '') {
      return;
    }

    setMessage(snackbarInfo.message);
    setSnackbarInfo({
      option: snackbarInfo.option,
      message: '',
    });

    const newTimer = setTimeout(() => {
      setTimer(null);
    }, 3000);

    setTimer(newTimer);
  }, [snackbarInfo]);

  if (timer === null) {
    return;
  }

  if (snackbarInfo.option === SNACKBAR.OPTION.LOGIN) {
    return (
      <S.Container>
        <S.Text>로그인이 필요한 기능입니다.</S.Text>
        <S.LinkText to={BROWSER_PATH.LOGIN}>로그인 하러가기⏎</S.LinkText>
      </S.Container>
    );
  }

  if (snackbarInfo.option === SNACKBAR.OPTION.REVIEW) {
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

  if (snackbarInfo.option === SNACKBAR.OPTION.ERROR) {
    return (
      <S.Container>
        <S.Text>{message}</S.Text>
      </S.Container>
    );
  }

  if (snackbarInfo.option === SNACKBAR.OPTION.INFO) {
    return (
      <S.Container option={SNACKBAR.OPTION.INFO}>
        <S.Text>{message}</S.Text>
      </S.Container>
    );
  }

  return;
}

export default Snackbar;
