import { CategoriesType, CategoryType } from '@/types/category';

import * as S from './Dropdown.styled';

function Dropdown({ data }: CategoriesType | any) {
  return (
    <S.Container>
      <S.Dropdown>
        <S.DropBtn>
          <span css={S.UnderBar}>{data.region}</span>
        </S.DropBtn>
        <S.DropContent>
          {data.categories.map((category: CategoriesType, index: number) => {
            return <S.DropList key={index}>{category.value}</S.DropList>;
          })}
        </S.DropContent>
      </S.Dropdown>
    </S.Container>
  );
}

export default Dropdown;
