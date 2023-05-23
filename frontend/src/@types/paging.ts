type PagingType<T> = {
  content: T[];
  pageNumber: number;
  totalCount: number;
  pageSize: number;
  totalPages: number;
  firstPage: boolean;
  lastPage: boolean;
};

export { PagingType };
