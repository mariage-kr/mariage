import { Categories } from '@/types/category';

import * as S from './Dropdown.styled';

type dataProps = {
  data: Categories;
};

function Dropdown({ data }: dataProps) {
  return (
    <S.Container>
      <S.Dropdown>
        <S.DropBtn>
          <span css={S.UnderBar}>{data.region}</span>
        </S.DropBtn>
        <S.DropContent>
          {data.categories.map((category, index) => {
            return <S.DropList key={index}>{category.value}</S.DropList>;
          })}
        </S.DropContent>
      </S.Dropdown>
    </S.Container>
  );
}

export default Dropdown;
