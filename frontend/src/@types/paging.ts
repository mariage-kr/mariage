type PagingType<T> = {
  contents: T[];
  pageNumber: number;
  totalCount: number;
  pageSize: number;
  totalPages: number;
  firstPage: boolean;
  lastPage: boolean;
};

export { PagingType };
