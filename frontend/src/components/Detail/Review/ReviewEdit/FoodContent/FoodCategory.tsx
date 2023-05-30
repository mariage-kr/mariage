import { FoodCategoryType } from '@/@types/category';
import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';

import * as S from './FoodCategory.styled';

type FunctionProps = {
  selectCategory: string | null;
  changeCategory: (category: string) => void;
  changeCategoryName: (category: string) => void;
  category: FoodCategoryType[];
};

function FoodCategory({
  selectCategory,
  changeCategory,
  changeCategoryName,
  category,
}: FunctionProps) {
  const handleRadioBtn = (e: React.ChangeEvent<HTMLInputElement>) => {
    const selectedValue = parseInt(e.target.value);
    const selectedCategory = category.find(
      (category: FoodCategoryType) => category.id === selectedValue,
    )!.value;
    const selectedCategoryName = category.find(
      (category: FoodCategoryType) => category.id === selectedValue,
    )!.name;
    changeCategory(selectedCategory);
    changeCategoryName(selectedCategoryName);
  };

  return (
    <S.Container>
      <S.Wrapper>
        {category.map((category: FoodCategoryType) => (
          <S.FoodRadioBtn>
            <S.BtnLabel key={category.id}>
              <S.Btn
                type="radio"
                key={category.id}
                value={category.id}
                checked={selectCategory === category.value}
                onChange={handleRadioBtn}
              />
              <S.Label>
                <S.ImgText css={S.btnImg}>
                  <FoodCategoryImg id={category.id} />
                </S.ImgText>
                <S.ImgText css={S.btnText}>{category.name}</S.ImgText>
              </S.Label>
            </S.BtnLabel>
          </S.FoodRadioBtn>
        ))}
      </S.Wrapper>
    </S.Container>
  );
}

export default FoodCategory;
