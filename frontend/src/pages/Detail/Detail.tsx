import ProductContent from './ProductContent/ProductContent';
import Pairing from './Pairing/Pairing';
import Review from './Review/Review';
import * as S from './Detail.styled';

function Detail() {
  return (
    <S.Container>
      <ProductContent />
      <Pairing />
      <Review />
    </S.Container>
  );
}

export default Detail;
