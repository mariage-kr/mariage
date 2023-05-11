import * as S from './Admin.styled';

function Admin() {
  return (
    <S.Container>
      <S.Header>제품 등록 페이지</S.Header>
      <S.Wrapper>
        <S.Label>제품 이름</S.Label>
        <S.Input type={'text'} title={'제품 이름'}></S.Input>
      </S.Wrapper>
      <S.Wrapper>
        <S.Label>알코올 도수</S.Label>
        <S.Input type={'number'} title={'알코올 도수'}></S.Input>
      </S.Wrapper>
      <S.Wrapper>
        <S.Label>국가</S.Label>
        <label>
          <S.Select>
            <option>국가</option>
          </S.Select>
        </label>
        <S.Text>선택된 국가 카테고리</S.Text>
      </S.Wrapper>
      <S.Wrapper>
        <S.Label>상위 카테고리</S.Label>
        <label>
          <S.Select>
            <option>상위 카테고리</option>
          </S.Select>
        </label>
        <S.Text>선택된 상위 카테고리</S.Text>
      </S.Wrapper>
      <S.Wrapper>
        <S.Label>하위 카테고리</S.Label>
        <label>
          <S.Select>
            <option>하위 카테고리</option>
          </S.Select>
        </label>
        <S.Text>선택된 하위 카테고리</S.Text>
      </S.Wrapper>
      <S.Wrapper>
        <S.Label>제품 설명</S.Label>
        <S.TextArea title={'제품 설명'}></S.TextArea>
        <S.Text>제품의 총 글자수</S.Text>
      </S.Wrapper>
      <S.Wrapper>
        <S.Label>제품 이미지</S.Label>
      </S.Wrapper>
    </S.Container>
  );
}

export default Admin;
