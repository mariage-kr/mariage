import { axios } from '../axios';
import { API_PATH } from '@/constants/path';

function requestDrinkUpperCategory() {
  return axios.get(API_PATH.CATEGORY.DRINK.UPPER);
}

export { requestDrinkUpperCategory };
