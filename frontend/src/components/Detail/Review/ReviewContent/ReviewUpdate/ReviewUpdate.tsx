import { useState } from 'react';

import HashTag from '@/components/Detail/Review/ReviewEdit/HashTag/HashTag';
import FoodImg from '@/components/Detail/Review/ReviewEdit/FoodContent/FoodImg';
import FoodCategory from '@/components/Detail/Review/ReviewEdit/FoodContent/FoodCategory';
import StarRate from '@/components/StarRate/Common/StarRate';

import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import { requestSaveReview } from '@/apis/request/review';
import useImage from '@/hooks/useImage';
import useInput from '@/hooks/useInput';
import { deleteImage, saveImage } from '@/utils/image';

import * as S from './ReviewUpdate.styled';
import useFoodCategory from '@/hooks/useFoodCategory';

type PropsType = {
  id: number;
  name: string;
  level: number;
  country: string;
  countryId: number;
  onClickReviewUpdate: () => void;
};

function ReviewUpdate({
  id,
  name,
  level,
  country,
  countryId,
  onClickReviewUpdate,
}: PropsType) {
  /* 버튼 옵션 선택 */
  const [option, setOption] = useState();

  /* 음식 카테고리 */
  const { foodCategory: category } = useFoodCategory();

  const btnData = [
    { id: 1, name: 'FoodCategory', text: '음식 카테고리' },
    { id: 2, name: 'FoodImg', text: '음식 사진 추가' },
  ];

  const handleClickButton = (e: any) => {
    const { name } = e.target;
    setOption(name);
  };

  /* 저장할 데이터 */
  const {
    value: image,
    setValue: setImage,
    preview,
  } = useImage<File | null>(null);
  const [foodCategory, setFoodCategory] = useState<string | null>(null);
  const [productRate, setProductRate] = useState<number | null>(null);
  const { value: content, setValue: setContent } = useInput<string>('');
  const [foodRate, setFoodRate] = useState<number | null>(null);
  const [hashtags, setHashtags] = useState<string[]>([]);

  const [foodCategoryName, setFoodCategoryName] = useState<string | null>(null);

  const changeProductRate = (value: number) => {
    setProductRate(value);
  };

  const changeFoodRate = (value: number) => {
    setFoodRate(value);
  };

  const saveReview = async () => {
    if (productRate === null) {
      return;
    }

    const productId: number = id;
    const foodImageId: number | null = await saveImage(image);

    requestSaveReview({
      productId,
      productRate,
      content,
      foodRate,
      foodCategory,
      foodImageId,
      hashtags,
    })
      .then(data => {
        window.location.reload();
        console.log(data.reviewId);
      })
      .catch(() => {
        if (foodImageId) {
          deleteImage(foodImageId);
        }
      });
  };

  const selectComponent = {
    FoodCategory: (
      <FoodCategory
        selectCategory={foodCategory}
        changeCategory={(category: string) => setFoodCategory(category)}
        changeCategoryName={(name: string) => setFoodCategoryName(name)}
        category={category.category}
      />
    ),
    FoodImg: <FoodImg onChange={setImage} preview={preview} />,
  };

  return (
    <S.Container>
      <S.Title>리뷰 수정</S.Title>
      <S.TitleInfo>술과 안주에 대한 평가를 수정해주세요</S.TitleInfo>
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
            <StarRate
              onChange={rate => changeProductRate(rate)}
              rate={productRate}
            />
          </S.DrinkStarRate>
          <S.InputReview
            value={content}
            onChange={setContent}
          />
        </S.Top>

        <S.Bottom>
          <S.BtnWrapper>
            {btnData.map(data => {
              return (
                <S.Btn
                  onClick={handleClickButton}
                  name={data.name}
                  key={data.id}
                  valid={data.name === option}
                >
                  {data.text}
                </S.Btn>
              );
            })}
          </S.BtnWrapper>
          {foodCategoryName !== null && (
            <S.FoodCategoryPrint>
              선택한 카테고리 :{' '}
              <S.FoodCategorySpan>{foodCategoryName}</S.FoodCategorySpan>
            </S.FoodCategoryPrint>
          )}
          {option && <S.FoodContent>{selectComponent[option]}</S.FoodContent>}
          
          <S.Pairing>
            <S.PairingText>궁합 음식 별점<S.PairingOption>&nbsp;(선택)</S.PairingOption></S.PairingText>
            <S.PairingStarRate>
              <StarRate onChange={rate => changeFoodRate(rate)} rate={foodRate} />
            </S.PairingStarRate>
          </S.Pairing>
          
          <S.HashTag>
            <S.HashTagTitle>#해시태그</S.HashTagTitle>
            <HashTag hashTags={hashtags} setHashTags={setHashtags} />
          </S.HashTag>
          <S.FinalBtn>
            <S.Cancel>
              <S.CancelBtn onClick={onClickReviewUpdate}>취소</S.CancelBtn>
            </S.Cancel>
            <S.Submit>
              <S.SubmitBtn onClick={saveReview}>적용</S.SubmitBtn>
            </S.Submit>
          </S.FinalBtn>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewUpdate;
