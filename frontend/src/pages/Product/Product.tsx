import { useEffect, useState } from 'react';

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

  const upperCategory = queryParam.get('upper');
  const lowerCategory = queryParam.get('lower');
  const minRate = queryParam.get('minRate');
  const maxRate = queryParam.get('maxRate');
  const minLevel = queryParam.get('minLevel');
  const maxLevel = queryParam.get('maxLevel');

  const [sort, setSort] = useState<string>(SORT.FILTER.RATE);

  const changeSort = (option: string) => {
    setSort(option);
  };

  const fetchProducts = () => {
    setLoading(true);
    if (!minRate || !maxRate || !minLevel || !maxLevel) {
      return;
    }
    const minRateNumber = Number.parseInt(minRate);
    const maxRateNumber = Number.parseInt(maxRate);
    const minLevelNumber = Number.parseInt(minLevel);
    const maxLevelNumber = Number.parseInt(maxLevel);
    requestProducts({
      pageSize: PAGING.PAGE_SIZE,
      pageNumber,
      sort,
      upperCategory,
      lowerCategory,
      minRate: minRateNumber,
      maxRate: maxRateNumber,
      minLevel: minLevelNumber,
      maxLevel: maxLevelNumber,
    })
      .then(data => {
        console.log(data);
        setProducts(data);
      })
      .finally(() => {
        setLoading(false);
      });
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <S.Container>
      <S.Aside>
        <Filter count={products.totalCount} />
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
