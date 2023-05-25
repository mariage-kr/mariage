import { useEffect, useState } from 'react';

import Filter from '@/components/Product/Filter/Filter';
import Option from '@/components/Product/Option/Option';
import ProductCard from '@/components/Product/ProductCard/ProductCard';
import NoItems from '@/components/NoItems/NoItems';

import { PagingType } from '@/@types/paging';
import { ProductInfoType } from '@/@types/product';
import { useProductCategory } from '@/hooks/useProductCategory';
import useSearchParam from '@/hooks/useSearchParam';

import * as S from './Product.styled';

/* 추후 AXIOS로 데이터 출력 */
import data from './data.json';
import nullData from './nullData.json';

function Product() {
  /* 위의 데이터는 데이터가 존재할 경우이며 아래는 데이터가 없을 경우입니다. */
  const products: PagingType<ProductInfoType> = data;
  // const products: PagingType<ProductInfoType> = nullData;

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
    return products.content.length === 0;
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
          products.content.map((product: ProductInfoType) => {
            return <ProductCard key={product.id} {...product} />;
          })
        )}
      </S.Contents>
    </S.Container>
  );
}

export default Product;
