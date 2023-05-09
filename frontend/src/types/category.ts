interface CategoryType {
  region: string;
  categories: CategoriesType[];
}

interface CategoriesType {
  value: string;
  name: string;
}

export { CategoryType, CategoriesType };
