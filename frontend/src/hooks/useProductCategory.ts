import { useRecoilState } from 'recoil';
import { useQuery } from 'react-query';

import { productCategoryState } from 'store/status';
import { requestDrinkRegionCategory } from 'apis/request/category';
import { QUERY_KEY } from 'constants/key';
import { DrinkRegionCategoryType } from 'types/category';

function useProductCategory() {
  const [value, setValue] =
    useRecoilState<DrinkRegionCategoryType[]>(productCategoryState);

  const requestCategory = useQuery(
    QUERY_KEY.PRODUCT_CATEGORY,
    requestDrinkRegionCategory,
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

export { useProductCategory };
