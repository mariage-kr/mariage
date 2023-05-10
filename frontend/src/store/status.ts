import { DefaultValue, atom, selector } from 'recoil';
import { recoilPersist } from 'recoil-persist';

import { accessTokenProvider, refreshTokenProvider } from '@/utils/token';
import { isLoginProvider } from '@/utils/auth';
import { isBoolean } from '@/utils/boolean';
import { CategoryType } from '@/types/category';

const { persistAtom } = recoilPersist();

const drinkUpperCategoryState = atom<CategoryType[]>({
  key: 'drinkUpperCategoryState',
  default: [],
  effects_UNSTABLE: [persistAtom],
});

const isLoginState = selector<boolean>({
  key: 'isLogin',
  get: () => {
    return isBoolean(isLoginProvider.get());
  },
  set: (_, isLogin) => {
    if (!isLogin) {
      isLoginProvider.remove();
    }

    if (!(isLogin instanceof DefaultValue)) {
      isLoginProvider.set(isLogin.toString());
    }
  },
});

const accessTokenState = selector<string>({
  key: 'accessToken',
  get: () => {
    return accessTokenProvider.get();
  },
  set: (_, accessToken) => {
    if (!accessToken) {
      accessTokenProvider.remove();
    }

    if (!(accessToken instanceof DefaultValue)) {
      accessTokenProvider.set(accessToken);
    }
  },
});

const refreshTokenState = selector<string>({
  key: 'refreshToken',
  get: () => {
    return refreshTokenProvider.get();
  },
  set: (_, refreshToken) => {
    if (!refreshToken) {
      refreshTokenProvider.remove();
    }

    if (!(refreshToken instanceof DefaultValue)) {
      refreshTokenProvider.set(refreshToken);
    }
  },
});

export {
  drinkUpperCategoryState,
  isLoginState,
  accessTokenState,
  refreshTokenState,
};
