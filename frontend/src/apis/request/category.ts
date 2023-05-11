import { axios } from '../axios';
import { CategoryType } from '@/types/category';
import { API_PATH } from '@/constants/path';

interface requestDataType {
  category: CategoryType[];
}

function requestDrinkUpperCategory() {
  return axios
    .get<requestDataType>(API_PATH.CATEGORY.DRINK.UPPER)
    .then(response => {
      return response.data.category;
    });
}

function requestDrinkLowerCategory() {
  return axios.get(API_PATH.CATEGORY.DRINK.LOWER);
}

export { requestDrinkUpperCategory, requestDrinkLowerCategory };
