import {
  HeaderRegionCategoryType,
  HeaderUpperCategoryType,
} from '@/@types/category';
import * as S from './Dropdown.styled';

function Dropdown({ region, value, categories }: HeaderRegionCategoryType) {
  return (
    <S.Container>
      <S.Dropdown>
        <S.DropBtn>
          <span css={S.UnderBar}>{region}</span>
        </S.DropBtn>
        <S.DropContent>
          {categories.map(
            (category: HeaderUpperCategoryType, index: number) => {
              return <S.DropList key={index}>{category.name}</S.DropList>;
            },
          )}
        </S.DropContent>
      </S.Dropdown>
    </S.Container>
  );
}

export default Dropdown;
