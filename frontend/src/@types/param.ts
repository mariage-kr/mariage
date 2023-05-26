type ProductFIlterParam = {
  pageSize: number;
  pageNumber: number;
  sort: string;
  upperCategory: string | null;
  lowerCategory: string | null;
  minRate: number;
  maxRate: number;
  minLevel: number;
  maxLevel: number;
};

export { ProductFIlterParam };
