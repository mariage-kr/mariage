import ProductContent from './ProductContent/ProductContent'
import Pairing from './Pairing/Pairing';
import * as S from './Detail.styled';

function Detail() {
  return (
    <S.Container>
      <ProductContent/>
      <Pairing/>
    </S.Container>
  );
}

export default Detail;
