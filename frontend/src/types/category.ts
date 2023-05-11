/* 메인 검색 필터 */
interface CategoryType {
  region: string;
  categories: CategoriesType[];
}

interface CategoriesType {
  value: string;
  name: string;
}

/* 제품 등록 */

interface UpperCategoryType {
  region: string; // example: "국내"
  regionValue: string; // example: "LOCAL"
  categories: LowerCategoryType[];
}

interface LowerCategoryType {
  name: string; // example: "LOCAL_SOJU"
  value: string; // example: "소주"
  subCategories: CategoriesType[];
}

export { CategoryType, CategoriesType, UpperCategoryType, LowerCategoryType };
