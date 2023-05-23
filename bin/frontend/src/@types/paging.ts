type PagingType<T> = {
  content: T[];
  pageNumber: number;
  totalCount: number;
  pageSize: number;
  totalPages: number;
  isFirstPage: boolean;
  isLastPage: boolean;
};

export { PagingType };
