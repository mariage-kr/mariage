import Filter from './Filter/Filter';
import Option from './Option/Option';
import * as S from './Product.styled';
import ProductCard from './ProductCard/ProductCard';

function Product() {
  return (
    <S.Container>
      <S.Aside>
        {/* TODO: name, total 속성 넣어주어야 함. */}
        <Filter />
      </S.Aside>
      <S.Contents>
        <Option />
        {/* TODO: map함수 써야함 */}
        <ProductCard />
      </S.Contents>
    </S.Container>
  );
}

export default Product;
