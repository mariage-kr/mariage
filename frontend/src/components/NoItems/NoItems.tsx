import * as S from './NoItems.styled';

import NoItem from 'components/Animation/NoItems';

function NoItems() {
  return (
    <S.Container>
      <NoItem />
      <S.textWrap>
        <p>조회하신 상품의 정보가 없습니다.</p>
      </S.textWrap>
    </S.Container>
  );
}

export default NoItems;
