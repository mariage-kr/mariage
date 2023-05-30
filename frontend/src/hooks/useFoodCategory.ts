import { useRecoilState } from 'recoil';
import { useQuery } from 'react-query';

import { FoodCategoryResponseType } from '@/@types/category';
import { requestFoodCategory } from '@/apis/request/category';
import { QUERY_KEY } from '@/constants/key';
import { foodCategoryState } from '@/store/status';

function useFoodCategory() {
  const [foodCategory, setFoodCategory] =
    useRecoilState<FoodCategoryResponseType>(foodCategoryState);

  const requestCategory = useQuery(
    QUERY_KEY.FOOD_CATEGORY,
    requestFoodCategory,
    {
      staleTime: 1000 * 60 * 60 * 60, // 1시간
      cacheTime: Infinity,
      onSuccess(data) {
        setFoodCategory(data);
      },
    },
  );

  return { foodCategory, setFoodCategory: requestCategory };
}

export default useFoodCategory;
