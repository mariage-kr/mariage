/* 메인 검색 필터 */
interface CategoryType {
  region: string;
  categories: DrinkLowerCategoryType[];
}

/**
 * 주류의 지역별 카테고리
 * @property {string} region - 지역의 이름
 * @property {string} value - 지역의 데이터
 * @property {LowerCategoryType[]} drinkUpperCategory - 해당 지역의 주류의 하위 카테고리
 */
interface DrinkRegionCategoryType {
  region: string;
  value: string;
  categories: DrinkUpperCategoryType[];
}

/**
 * 주류의 상위 카테고리
 * @property {string} name - 주류의 상위 카테고리 데이터
 * @property {string} value - 주류의 상위 카테고리 이름
 * @property {CategoryType[]} drinkLowerCategory - 해당 주류의 하위 카테고리
 */
interface DrinkUpperCategoryType {
  name: string;
  value: string;
  subCategories: DrinkLowerCategoryType[];
}

/**
 * 주류의 하위 카테고리
 * @property {string} value - 주류의 이름
 * @property {string} name - 주류의 데이터
 */
interface DrinkLowerCategoryType {
  value: string;
  name: string;
}

/**
 * @property {number} id - 국가의 식별 번호
 * @property {string} name - 국가 이름
 * @property {string} flag - 국가의 데이터
 */
interface CountryType {
  id: number;
  name: string;
  value: string;
}

export {
  CategoryType,
  DrinkRegionCategoryType,
  DrinkUpperCategoryType,
  DrinkLowerCategoryType,
  CountryType,
};
