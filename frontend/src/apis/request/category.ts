import { axios } from '../axios';
import { CategoryType } from '@/types/category';
import { API_PATH } from '@/constants/path';

type requestCategoryType = {
  category: CategoryType[];
};

function requestDrinkUpperCategory() {
  return axios.get(API_PATH.CATEGORY.DRINK.UPPER);
}

function requestDrinkUpperCategoryQuery() {
  return axios
    .get<requestCategoryType>(API_PATH.CATEGORY.DRINK.UPPER)
    .then(response => {
      return response.data;
    });
}

export { requestDrinkUpperCategory, requestDrinkUpperCategoryQuery };
