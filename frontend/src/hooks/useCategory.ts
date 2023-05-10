import { useCallback } from 'react';
import { useRecoilState } from 'recoil';
import { useQuery } from 'react-query';

import { drinkUpperCategoryState } from '@/store/status';
import { requestDrinkUpperCategory } from '@/apis/request/category';
import { QUERY_KEY } from '@/constants/key';

function useDrinkUpperCategory() {
  const [value, setValue] = useRecoilState(drinkUpperCategoryState);

  const requestCategory = useCallback(async () => {
    if (value.length !== 0) {
      return;
    }
    await requestDrinkUpperCategory()
      .then(response => {
        setValue(response.data.category);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return { value, setValue: requestCategory };
}

export { useDrinkUpperCategory };
