import { useRecoilState } from 'recoil';

import { SnackbarInfo } from '@/@types/common';
import { SNACKBAR } from '@/constants/snackbar';
import { snackbarState } from '@/store/status';

function useSnack() {
  const [snackbar, setSnackbar] = useRecoilState<SnackbarInfo>(snackbarState);

  const loginSnackbar = () => {
    setSnackbar({
      option: SNACKBAR.OPTION.LOGIN,
      message: SNACKBAR.OPTION.LOGIN,
    });
  };

  const reviewSnackbar = () => {
    setSnackbar({
      option: SNACKBAR.OPTION.REVIEW,
      message: SNACKBAR.OPTION.REVIEW,
    });
  };

  const errorSnackbar = (message: string) => {
    setSnackbar({
      option: SNACKBAR.OPTION.ERROR,
      message: message,
    });
  };

  const infoSnackbar = (message: string) => {
    setSnackbar({
      option: SNACKBAR.OPTION.INFO,
      message: message,
    });
  };

  return {
    snackbar,
    setSnackbar,
    loginSnackbar,
    reviewSnackbar,
    errorSnackbar,
    infoSnackbar,
  };
}

export default useSnack;
