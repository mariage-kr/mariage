import { useRecoilState } from 'recoil';
import { useQuery } from 'react-query';

import { drinkUpperCategoryState } from '@/store/status';
import { requestDrinkUpperCategory } from '@/apis/request/category';
import { QUERY_KEY } from '@/constants/key';
import { CategoryType } from '@/@types/category';

function useDrinkUpperCategory() {
  const [value, setValue] = useRecoilState<CategoryType[]>(
    drinkUpperCategoryState,
  );

  const requestCategory = useQuery(
    QUERY_KEY.DRINK_UPPER_CATEGORY,
    requestDrinkUpperCategory,
    {
      staleTime: 1000 * 60 * 60 * 5,
      cacheTime: Infinity,
      onSuccess(data) {
        setValue(data);
      },
    },
  );

  return { value, setValue: requestCategory };
}

export { useDrinkUpperCategory };
