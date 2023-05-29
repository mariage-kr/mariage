import { axios } from '../axios';

import {
  CategoryType,
  DrinkRegionCategoryType,
  FoodCategoryResponseType,
} from '@/@types/category';
import { API_PATH } from '@/constants/path';

interface requestDataType {
  category: CategoryType[];
}

interface requestProductDataType {
  category: DrinkRegionCategoryType[];
}

function requestDrinkUpperCategory() {
  return axios
    .get<requestDataType>(API_PATH.CATEGORY.DRINK.UPPER)
    .then(response => {
      return response.data.category;
    });
}

function requestDrinkRegionCategory() {
  return axios
    .get<requestProductDataType>(API_PATH.CATEGORY.DRINK.LOWER)
    .then(response => {
      return response.data.category;
    });
}

function requestDrinkLowerCategory() {
  return axios.get(API_PATH.CATEGORY.DRINK.LOWER);
}

function requestFoodCategory() {
  return axios
    .get<FoodCategoryResponseType>(API_PATH.CATEGORY.FOOD)
    .then(response => {
      return response.data;
    });
}

function requestCountry() {
  return axios.get(API_PATH.CATEGORY.COUNTRY);
}

export {
  requestDrinkUpperCategory,
  requestDrinkLowerCategory,
  requestFoodCategory,
  requestCountry,
  requestDrinkRegionCategory,
};
