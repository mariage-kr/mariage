import { useEffect, useState, useRef } from 'react';

import Filter from '@/components/Product/Filter/Filter';
import Option from '@/components/Product/Option/Option';
import ProductCard from '@/components/Product/ProductCard/ProductCard';
import NoItems from '@/components/NoItems/NoItems';
import DataLoading from '@/components/Animation/DataLoading';

import { PagingType } from '@/@types/paging';
import { ProductsType } from '@/@types/product';
import { requestProducts } from '@/apis/request/product';
import { PAGING } from '@/constants/rule';
import useIntersectionObserver from '@/hooks/useIntersectionObserver';

import * as S from './Product.styled';
import useSnack from '@/hooks/useSnack';

function Product() {
  const queryParam = new URLSearchParams(location.search);
  const { infoSnackbar } = useSnack();

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
  const querySort = queryParam.get('sort');
  const queryMinRate = queryParam.get('minRate');
  const queryMaxRate = queryParam.get('maxRate');
  const queryMinLevel = queryParam.get('minLevel');
  const queryMaxLevel = queryParam.get('maxLevel');

  const fetchProducts = async () => {
    if (hasMore === false) {
      infoSnackbar('제품이 더 이상 존재하지 않습니다.');
      return;
    }
    setLoading(true);
    await requestProducts({
      pageSize: PAGING.PAGE_SIZE,
      pageNumber,
      sort: querySort!,
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

  const target = useRef(null);

  const [observe, unobserve] = useIntersectionObserver(() => {
    setPageNumber(prev => prev + 1);
  });

  useEffect(() => {
    if (loading) {
      unobserve(target.current);
    } else {
      observe(target.current);
    }
  }, [loading]);

  useEffect(() => {
    fetchProducts();
  }, [pageNumber]);

  useEffect(() => {
    const toTop = () => {
      window.scroll({
        top: 0,
      });
    };

    toTop();
  }, []);

  return (
    <S.Container>
      <S.Aside>
        <Filter
          count={products.totalCount}
          upperCategory={queryUpperCategory}
          lowerCategory={queryLowerCategory}
          search={querySearch}
        />
      </S.Aside>
      <S.Contents>
        <S.ContentHeaderWrapper>
          {querySearch ? (
            <S.Count>
              "{querySearch}"의 검색 결과는{' '}
              <S.Color>{products.totalCount}개</S.Color> 입니다.
            </S.Count>
          ) : (
            <S.Count>
              조건에 맞는 상품 개수는 <S.Color>{products.totalCount}개</S.Color>{' '}
              입니다.
            </S.Count>
          )}
          <Option
            minRate={queryMinRate!}
            maxRate={queryMaxRate!}
            minLevel={queryMinLevel!}
            maxLevel={queryMaxLevel!}
            sort={querySort!}
            search={querySearch}
            upperCategory={queryUpperCategory}
            lowerCategory={queryLowerCategory}
          />
        </S.ContentHeaderWrapper>
        <S.ContentWrapper>
          {products.totalCount === 0 ? (
            <NoItems />
          ) : (
            products.contents.map((product: ProductsType) => {
              return <ProductCard key={product.id} {...product} />;
            })
          )}
          <S.Target ref={target} />
        </S.ContentWrapper>
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
