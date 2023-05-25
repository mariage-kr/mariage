import { useEffect, useState } from 'react';

import Filter from '@/components/Product/Filter/Filter';
import Option from '@/components/Product/Option/Option';
import ProductCard from '@/components/Product/ProductCard/ProductCard';
import NoItems from '@/components/NoItems/NoItems';

import { PagingType } from '@/@types/paging';
import { ProductsType } from '@/@types/product';
import { useProductCategory } from '@/hooks/useProductCategory';
import useSearchParam from '@/hooks/useSearchParam';

import * as S from './Product.styled';
import { PAGING } from '@/constants/rule';

function Product() {
  const [products, setProducts] = useState<PagingType<ProductsType>>({
    contents: [],
    pageNumber: 1,
    totalCount: 0,
    totalPages: 0,
    pageSize: PAGING.PAGE_SIZE,
    firstPage: true,
    lastPage: false,
  });

  const { value: category } = useProductCategory();
  const [pageNumber, setPageNumber] = useState<number>(0);

  const { value: upperCategory, setValue: setUpperCategory } = useSearchParam<
    string | null
  >(null);
  const { value: lowerCategory, setValue: setLowerCategory } =
    useSearchParam<String | null>(null);
  const { value: minRate, setValue: setMinRate } = useSearchParam<number>(0);
  const { value: maxRate, setValue: setMaxRate } = useSearchParam<number>(5);
  const { value: minLevel, setValue: setMinLevel } = useSearchParam<number>(0);
  const { value: maxLevel, setValue: setMaxLevel } = useSearchParam<number>(70);
  const [sort, setSort] = useState<string>('rate'); // rate, count

  const lengthIsZero = (): boolean => {
    return products.contents.length === 0;
  };

  const getParam = () => {
    setUpperCategory('upper');
    setLowerCategory('lower');
    setMinRate('minRate');
    setMaxRate('maxRate');
    setMinLevel('minLevel');
    setMaxLevel('maxLevel');
  };

  useEffect(() => {
    getParam();
  }, []);

  const changeSort = (option: string) => {
    setSort(option);
  };

  console.log(sort);

  return (
    <S.Container>
      <S.Aside>
        <Filter
          count={lengthIsZero() ? 0 : products.totalCount}
          categories={category}
        />
      </S.Aside>
      <S.Contents>
        <Option changeSort={changeSort} />
        {lengthIsZero() ? (
          <NoItems />
        ) : (
          products.contents.map((product: ProductsType) => {
            return <ProductCard key={product.id} {...product} />;
          })
        )}
      </S.Contents>
    </S.Container>
  );
}

export default Product;
