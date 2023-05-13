import React, { useCallback, useEffect, useState } from 'react';

import {
  requestCountry,
  requestDrinkLowerCategory,
} from '@/apis/request/category';
import { requestSaveImage } from '@/apis/request/storage';
import { requestProductInfo, requestSaveProduct } from '@/apis/request/product';
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
import useSearchParam from '@/hooks/useSearchParam';

type DrinkCategoryResponseType = {
  category: DrinkRegionCategoryType[];
};

type ImageIdType = {
  imageId: number;
};

function Admin() {
  /* 쿼리스트링 */

  const { value: productId, setValue: setProductId } = useSearchParam(null);

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

  /* 제품 정보 요청 */
  const getProductInfo = async () => {
    await requestProductInfo(productId!)
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        console.error(error);
      });
  };

  /* 제품 등록/수정 요청 */
  const uploadImage = async () => {
    const data: ImageIdType = await requestSaveImage(image!);
    return data.imageId;
  };

  const saveProduct = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const imageId = await uploadImage();
    if (!imageId) {
      alert('사진이 정상적으로 저장되지 않았습니다.\n다시한번 시도해주세요.');
      return;
    }
    await requestSaveProduct({
      name,
      level,
      info,
      country,
      upperCategory,
      lowerCategory,
      imageId,
    })
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        setErrorMessage(error.response.data.message);
        console.log(error);
      });
  };

  /* useEffect */
  useEffect(() => {
    getCountryCategory();
    getDrinkCategory();
    setProductId('id');
  }, []);

  useEffect(() => {
    if (productId !== null && productId !== undefined) {
      getProductInfo();
    }
  }, [productId]);

  useEffect(() => {
    if (drinkCategoryResponse) {
      setDrinkRegionCategory(drinkCategoryResponse.category[0]);
    }
  }, [drinkCategoryResponse]);

  useEffect(() => {
    if (drinkCategoryResponse && country) {
      const foundRegionCategory = drinkCategoryResponse.category.find(
        (category: DrinkRegionCategoryType) =>
          category.value === (country === 'KOREA' ? 'LOCAL' : 'FOREIGN'),
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

  useEffect(() => {
    if (
      name === '' ||
      info === '' ||
      country === '' ||
      upperCategory === '' ||
      lowerCategory === '' ||
      image === null
    ) {
      setIsValid(false);
    } else {
      setIsValid(true);
    }
  }, [name, level, info, image, country, upperCategory, lowerCategory]);

  return (
    <S.Container>
      <S.Header>제품 관리 페이지</S.Header>
      <S.Form onSubmit={saveProduct}>
        {errorMessage && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
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
              <option key={category.id} value={category.value}>
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
        {isValid ? (
          <S.Button type={'submit'} isValid={isValid}>
            등록하기
          </S.Button>
        ) : (
          <S.Button isValid={isValid} disabled>
            등록하기
          </S.Button>
        )}
      </S.Form>
    </S.Container>
  );
}

export default Admin;
