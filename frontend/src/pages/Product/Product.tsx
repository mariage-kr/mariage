import ProductContent from '../Detail/ProductContent/ProductContent';
import Filter from './Filter/Filter';
import Option from './Option/Option';
import * as S from './Product.styled';
import ProductCard from './ProductCard/ProductCard';

function Product() {
  return (
    <S.Container>
      <S.Aside>
        <Filter />
      </S.Aside>
      <S.Contents>
        <Option />
        <ProductCard />
      </S.Contents>
    </S.Container>
  );
}

export default Product;
