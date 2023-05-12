import React, { useCallback, useEffect, useState } from 'react';

import {
  requestCountry,
  requestDrinkLowerCategory,
} from '@/apis/request/category';
import { requestSaveImage } from '@/apis/request/storage';
import useInput from '@/hooks/useInput';
import useSelect from '@/hooks/useSelect';
import useImage from '@/hooks/useImage';
import {
  DrinkRegionCategoryType,
  DrinkUpperCategoryType,
  DrinkLowerCategoryType,
  CountryType,
} from '@/types/category';

import * as S from './Admin.styled';

type DrinkCategoryResponseType = {
  category: DrinkRegionCategoryType[];
};

type ImageIdType = {
  imageId: number;
};

function Admin() {
  /* 카테고리 데이터 */
  const [countryCategory, setCountryCategory] = useState<CountryType[]>([]);
  const [drinkCategoryResponse, setDrinkCategoryResponse] =
    useState<DrinkCategoryResponseType>();
  const [drinkRegionCategory, setDrinkRegionCategory] =
    useState<DrinkRegionCategoryType>();
  const [drinkUpperCategory, setDrinkUpperCategory] =
    useState<DrinkUpperCategoryType>();

  /* 사용자 입력 변수 */
  const { value: name, setValue: setName } = useInput<string>('');
  const { value: info, setValue: setInfo } = useInput<string>('');
  const [level, setLevel] = useState<number>(0);
  const { value: country, setValue: setCountry } = useSelect<string>('');
  const {
    value: upperCategory,
    setValue: setUpperCategory,
    defaultValue: defaultUpperCategory,
  } = useSelect<string>('');
  const {
    value: lowerCategory,
    setValue: setLowerCategory,
    defaultValue: defaultLowerCategory,
  } = useSelect<string>('');
  const {
    value: image,
    setValue: setImage,
    preview: previewImage,
  } = useImage<File | null>(null);

  /* 검증 변수 */
  const [isValid, setIsValid] = useState<boolean>(false);
  const [errorMessage, setErrorMessage] = useState<string>('');

  /* Input */
  const changeLevel = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { value } = e.target;

    const onlyNumber = parseFloat(value.replace(/[^\d.]/g, ''));
    const roundedNumber = Math.round(onlyNumber * 10) / 10;
    let finalNumber = isNaN(roundedNumber) ? 0 : roundedNumber;

    if (finalNumber > 100.0) {
      finalNumber = 100.0;
    }

    setLevel(finalNumber);
  };

  /* 카테고리 데이터 요청 */
  const getCountryCategory = useCallback(async () => {
    await requestCountry().then(response => {
      setCountryCategory(response.data.country);
    });
  }, []);

  const getDrinkCategory = useCallback(async () => {
    await requestDrinkLowerCategory()
      .then(response => {
        setDrinkCategoryResponse(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  /* 제품 등록/수정 요청 */
  const getModifyProductRequest = async () => {
    const data: ImageIdType = await requestSaveImage(image!);
    return data.imageId;
  };

  const requestProduct = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const imageId = await getModifyProductRequest();
  };

  /* useEffect */
  useEffect(() => {
    getCountryCategory();
    getDrinkCategory();
  }, []);

  useEffect(() => {
    if (drinkCategoryResponse) {
      setDrinkRegionCategory(drinkCategoryResponse.category[0]);
    }
  }, [drinkCategoryResponse]);

  useEffect(() => {
    if (drinkCategoryResponse && country) {
      const foundRegionCategory = drinkCategoryResponse.category.find(
        (category: DrinkRegionCategoryType) =>
          category.value === (country === 'korea' ? 'LOCAL' : 'FOREIGN'),
      );
      setDrinkRegionCategory(foundRegionCategory);
    }
    defaultUpperCategory();
    defaultLowerCategory();
  }, [country]);

  useEffect(() => {
    if (drinkRegionCategory && upperCategory) {
      const foundUpperCategory = drinkRegionCategory.categories.find(
        (category: DrinkUpperCategoryType) => category.value === upperCategory,
      );
      setDrinkUpperCategory(foundUpperCategory);
    }

    defaultLowerCategory();
  }, [upperCategory]);

  return (
    <S.Container>
      <S.Header>제품 관리 페이지</S.Header>
      <S.Form onSubmit={requestProduct}>
        {isValid && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
        <S.Label>제품 이름</S.Label>
        <S.Input type={'text'} value={name} onChange={setName}></S.Input>
        <S.Label>알코올 도수</S.Label>
        <S.Input
          type={'number'}
          value={level}
          onChange={changeLevel}
          max={100}
          min={0}
        ></S.Input>
        <S.Label>제품 설명</S.Label>
        <S.TextArea onChange={setInfo}></S.TextArea>
        <S.Count>글자 수 : {info.length}</S.Count>
        <S.Label>국가</S.Label>
        <label>
          <S.Select onChange={setCountry}>
            <option selected disabled>
              주류의 생산 국가를 선택하세요.
            </option>
            {countryCategory.map((category: CountryType) => (
              <option key={category.id} value={category.flag}>
                {category.name}
              </option>
            ))}
          </S.Select>
          <S.Info>선택된 국가 : [{country}]</S.Info>
        </label>
        {country && (
          <>
            <S.Label>상위 카테고리</S.Label>
            <label>
              <S.Select onChange={setUpperCategory}>
                <option selected disabled>
                  주류의 상위 카테고리를 선택하세요.
                </option>
                {drinkRegionCategory?.categories.map(
                  (category: DrinkUpperCategoryType, index: number) => (
                    <option key={index} value={category.value}>
                      {category.name}
                    </option>
                  ),
                )}
              </S.Select>
              <S.Info>선택된 상위 카테고리 : [{upperCategory}]</S.Info>
            </label>
          </>
        )}
        {upperCategory && (
          <>
            <S.Label>하위 카테고리</S.Label>
            <label>
              <S.Select onChange={setLowerCategory}>
                <option selected disabled>
                  주류의 하위 카테고리를 선택하세요.
                </option>
                {drinkUpperCategory?.subCategories.map(
                  (category: DrinkLowerCategoryType, index: number) => (
                    <option key={index} value={category.value}>
                      {category.name}
                    </option>
                  ),
                )}
              </S.Select>
            </label>
            <S.Info>선택된 하위 카테고리 : [{lowerCategory}]</S.Info>
          </>
        )}
        <S.Label>이미지</S.Label>
        <S.Input
          type={'file'}
          title={'이미지 업로드'}
          onChange={setImage}
        ></S.Input>
        {previewImage && <S.Image src={previewImage} alt="미리보기" />}
        <S.Button type={'submit'}>등록하기</S.Button>
      </S.Form>
    </S.Container>
  );
}

export default Admin;
