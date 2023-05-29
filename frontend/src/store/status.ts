import { DefaultValue, atom, selector } from 'recoil';
import { recoilPersist } from 'recoil-persist';

import { accessTokenProvider, refreshTokenProvider } from '@/utils/token';
import { isLoginProvider } from '@/utils/auth';
import {
  CategoryType,
  DrinkRegionCategoryType,
  FoodCategoryResponseType,
  FoodCategoryType,
} from '@/@types/category';
import { RECOIL_KEY } from '@/constants/key';
import { UserInfoType } from '@/@types/user';

const { persistAtom } = recoilPersist();

const drinkUpperCategoryState = atom<CategoryType[]>({
  key: RECOIL_KEY.DRINK_UPPER_CATEGORY,
  default: [],
  effects_UNSTABLE: [persistAtom],
});

const productCategoryState = atom<DrinkRegionCategoryType[]>({
  key: RECOIL_KEY.PRODUCT_CATEGORY,
  default: [],
  effects_UNSTABLE: [persistAtom],
});

const userInfoState = atom<UserInfoType | undefined>({
  key: RECOIL_KEY.USER_INFO,
  default: undefined,
  effects_UNSTABLE: [persistAtom],
});

const foodCategoryState = atom<FoodCategoryResponseType>({
  key: RECOIL_KEY.FOOD_CATEGORY,
  default: undefined,
  effects_UNSTABLE: [persistAtom],
});

const isLoginState = selector<boolean>({
  key: 'isLogin',
  get: () => {
    return isLoginProvider.get();
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
  userInfoState,
  isLoginState,
  accessTokenState,
  refreshTokenState,
  productCategoryState,
  foodCategoryState,
};
