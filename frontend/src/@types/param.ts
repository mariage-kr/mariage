type ProductFIlterParam = {
  pageSize: number;
  pageNumber: number;
  sort: string;
  querySearch: string | null;
  queryUpperCategory: string | null;
  queryLowerCategory: string | null;
  queryMinRate: string | null;
  queryMaxRate: string | null;
  queryMinLevel: string | null;
  queryMaxLevel: string | null;
};

export { ProductFIlterParam };
