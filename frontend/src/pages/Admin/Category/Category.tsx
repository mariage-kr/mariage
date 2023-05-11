import * as S from './Category.styled';

function Category() {
  return (
    <S.Container>
      <label>
        <S.Wrapper>
          <S.Text>국가</S.Text>
          <S.Select>
            <option>대한민국</option>
            <option>일본</option>
            <option>미국</option>
          </S.Select>
        </S.Wrapper>
        <S.Wrapper>
          <S.Text>상위 카테고리</S.Text>
          <S.Select>
            <option>소주</option>
            <option>맥주</option>
          </S.Select>
        </S.Wrapper>
        <S.Wrapper>
          <S.Text>하위 카테고리</S.Text>
          <S.Select>
            <option>증류식 소주</option>
            <option>희석식 소주</option>
          </S.Select>
        </S.Wrapper>
      </label>
    </S.Container>
  );
}

export default Category;
