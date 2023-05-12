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

function requestFoodCategory() {
  return axios.get(API_PATH.CATEGORY.FOOD);
}

function requestCountry() {
  return axios.get(API_PATH.CATEGORY.COUNTRY);
}

export {
  requestDrinkUpperCategory,
  requestDrinkLowerCategory,
  requestFoodCategory,
  requestCountry,
};
