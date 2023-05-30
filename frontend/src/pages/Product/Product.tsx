import { useEffect, useState, useCallback } from 'react';

import Filter from '@/components/Product/Filter/Filter';
import Option from '@/components/Product/Option/Option';
import ProductCard from '@/components/Product/ProductCard/ProductCard';
import NoItems from '@/components/NoItems/NoItems';
import DataLoading from '@/components/Animation/DataLoading';

import { PagingType } from '@/@types/paging';
import { ProductsType } from '@/@types/product';
import { requestProducts } from '@/apis/request/product';
import { PAGING } from '@/constants/rule';
import { SORT } from '@/constants/option';

import * as S from './Product.styled';

function Product() {
  const queryParam = new URLSearchParams(location.search);

  const [products, setProducts] = useState<PagingType<ProductsType>>({
    contents: [],
    pageNumber: 1,
    totalCount: 0,
    totalPages: 0,
    pageSize: PAGING.PAGE_SIZE,
    firstPage: true,
    lastPage: false,
  });

  const [loading, setLoading] = useState<boolean>(false);
  const [pageNumber, setPageNumber] = useState<number>(1);
  const [hasMore, setHasMore] = useState<boolean>(true);

  const querySearch = queryParam.get('search');
  const queryUpperCategory = queryParam.get('upper');
  const queryLowerCategory = queryParam.get('lower');
  const queryMinRate = queryParam.get('minRate');
  const queryMaxRate = queryParam.get('maxRate');
  const queryMinLevel = queryParam.get('minLevel');
  const queryMaxLevel = queryParam.get('maxLevel');

  const [sort, setSort] = useState<string>(SORT.FILTER.RATE);

  const changeSort = (option: string) => {
    setSort(option);
  };

  /* TODO: 추후 무한스크롤로 적용 */
  const fetchProducts = () => {
    if (hasMore === false) {return}
    setLoading(true);
    requestProducts({
      pageSize: PAGING.PAGE_SIZE,
      pageNumber,
      sort,
      querySearch,
      queryUpperCategory,
      queryLowerCategory,
      queryMinRate,
      queryMaxRate,
      queryMinLevel,
      queryMaxLevel,
    })
    .then(data => {
      setProducts(prevProducts => ({
        ...data,
        contents: [...prevProducts.contents, ...data.contents],
      }));
      setHasMore(data.lastPage === false);
    })
    .catch(error => {
      console.error('Error fetching products:', error);
    })
    .finally(() => {
      setLoading(false);
    });
  };

  const infiniteScroll = useCallback(() => {
    if (
      window.innerHeight + document.documentElement.scrollTop ===
      document.documentElement.offsetHeight
    ) {
      setPageNumber(prevPageNumber => prevPageNumber + 1);
    }
  }, []);


  useEffect(() => {
    window.addEventListener('scroll', infiniteScroll);
    return () => window.removeEventListener('scroll', infiniteScroll);
  }, [infiniteScroll]);


  /* 정렬 옵션 수정 시 */
  useEffect(() => {
    fetchProducts();
  }, [sort, pageNumber]);

  return (
    <S.Container>
      <S.Aside>
        <Filter count={products.totalCount} search={querySearch} />
      </S.Aside>
      <S.Contents>
        <Option changeSort={changeSort} />
        {products.totalCount === 0 ? (
          <NoItems />
        ) : (
          products.contents.map((product: ProductsType) => {
            return <ProductCard key={product.id} {...product} />;
          })
        )}
        {loading && (
          <S.AniWrapper>
            <DataLoading />
          </S.AniWrapper>
        )}
      </S.Contents>
    </S.Container>
  );
}

export default Product;
