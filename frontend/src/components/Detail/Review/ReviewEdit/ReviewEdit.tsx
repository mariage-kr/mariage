import { useState } from 'react';

import StarRate from '@/components/StarRate/Common/StarRate';

import FoodCategory from './FoodContent/FoodCategory';
import FoodImg from './FoodContent/FoodImg';
import HashTag from './HashTag/HashTag';

import * as S from './ReviewEdit.styled';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';

type PropsType = {
  id: number;
  name: string;
  level: number;
  country: string;
  countryId: number;
  onClickToggleModal: () => void;
};

function ReviewEdit({
  id,
  name,
  level,
  country,
  countryId,
  onClickToggleModal,
}: PropsType) {
  const [content, setContent] = useState();
  const [category, setCategory] = useState<string | null>(null);

  const handleClickButton = (e: any) => {
    const { name } = e.target;
    setContent(name);
  };

  const btnData = [
    { id: 1, name: 'FoodCategory', text: '음식 카테고리' },
    { id: 2, name: 'FoodImg', text: '음식 사진 추가' },
  ];

  const selectComponent = {
    FoodCategory: (
      <FoodCategory
        category={category}
        changeCategory={(category: string) => setCategory(category)}
      />
    ),
    FoodImg: <FoodImg />,
  };

  return (
    <S.Container>
      <S.Title>리뷰 작성</S.Title>
      <S.TitleInfo>술과 안주에 대한 평가를 남겨주세요</S.TitleInfo>
      <S.Wrapper>
        <S.Top>
          <S.DrinkInfo>
            <S.Country css={S.country_left}>
              <CountryFlagImg id={countryId} />
            </S.Country>
            <S.Country css={S.country_right}>{country}</S.Country>
            <S.NameLevel>
              {name} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ABV <S.ABV>{level}</S.ABV>%
            </S.NameLevel>
          </S.DrinkInfo>
          <S.DrinkStarRate>
            <StarRate />
          </S.DrinkStarRate>
          <S.InputReview placeholder="** 술과 안주에 대한 리뷰를 적어주세요. **" />
          <S.PairingText>궁합 음식 별점</S.PairingText>
          <S.PairingStarRate>
            <StarRate />
          </S.PairingStarRate>
        </S.Top>

        <S.Bottom>
          <S.BtnWrapper>
            {btnData.map(data => {
              return (
                <S.Btn
                  onClick={handleClickButton}
                  name={data.name}
                  key={data.id}
                >
                  {data.text}
                </S.Btn>
              );
            })}
          </S.BtnWrapper>
          {category !== null && (
            <S.FoodCategoryPrint>
              선택한 카테고리:{' '}
              <S.FoodCategorySpan>{category}</S.FoodCategorySpan>
            </S.FoodCategoryPrint>
          )}
          {content && <S.FoodContent>{selectComponent[content]}</S.FoodContent>}

          <S.HashTag>
            <S.HashTagTitle>#해시태그</S.HashTagTitle>
            <HashTag />
          </S.HashTag>
          <S.FinalBtn>
            <S.Cancel>
              <S.CancelBtn onClick={onClickToggleModal}>취소</S.CancelBtn>
            </S.Cancel>
            <S.Submit>
              <S.SubmitBtn>적용</S.SubmitBtn>
            </S.Submit>
          </S.FinalBtn>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewEdit;
