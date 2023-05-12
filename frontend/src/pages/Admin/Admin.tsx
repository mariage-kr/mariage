import { useCallback, useEffect, useState } from 'react';

import useInput from '@/hooks/useInput';

import * as S from './Admin.styled';
import { requestDrinkLowerCategory } from '@/apis/request/category';
import useSelect from '@/hooks/useSelect';
import {
  DrinkRegionCategoryType,
  DrinkUpperCategoryType,
  DrinkLowerCategoryType,
} from '@/types/category';

type CountryType = {
  id: number;
  name: string;
  flag: string;
};

type DrinkCategoryResponseType = {
  category: DrinkRegionCategoryType[];
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
  const { value: upperCategory, setValue: setUpperCategory } =
    useSelect<string>('');
  const { value: lowerCategory, setValue: setLowerCategory } =
    useSelect<string>('');

  /* 검증 변수 */
  const [isValid, setIsValid] = useState<boolean>(false);
  const [errorMessage, setErrorMessage] = useState<string>('');

  /* 카테고리 데이터 요청 */
  /* TODO: 나라 카테고리 데이터 요청 함수 필요 */
  const getCountryCategory = useCallback(() => {}, []);

  const getDrinkCategory = useCallback(() => {
    requestDrinkLowerCategory()
      .then(response => {
        setDrinkCategoryResponse(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  /* useEffect */
  useEffect(() => {
    getCountryCategory();
    getDrinkCategory();
  }, []);

  useEffect(() => {
    /*  */
  }, [country]);

  useEffect(() => {
    if (drinkCategoryResponse) {
      setDrinkRegionCategory(drinkCategoryResponse.category[0]);
    }
  }, [drinkCategoryResponse]);

  useEffect(() => {
    const index: number = 0;

    if (drinkRegionCategory) {
      setDrinkUpperCategory(drinkRegionCategory.categories[0]);
    }
  }, [drinkRegionCategory]);

  return (
    <S.Container>
      <S.Header>제품 관리 페이지</S.Header>
      <S.Form onSubmit={() => console.log('run')}>
        {isValid && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
        <S.Label>제품 이름</S.Label>
        <S.Input type={'text'} value={name} onChange={setName}></S.Input>
        <S.Label>알코올 도수</S.Label>
        <S.Input type={'number'} value={level}></S.Input>
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
        </label>
        <S.Label>상위 카테고리</S.Label>
        <label>
          <S.Select onChange={setUpperCategory}>
            <option selected disabled>
              주류의 상위 카테고리를 선택하세요.
            </option>
            {drinkRegionCategory?.categories.map(
              (category: DrinkUpperCategoryType, index: number) => (
                <option key={index} value={category.name}>
                  {category.value}
                </option>
              ),
            )}
          </S.Select>
        </label>
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
                    <option key={index} value={category.name}>
                      {category.value}
                    </option>
                  ),
                )}
              </S.Select>
            </label>
          </>
        )}
        <S.Label>이미지</S.Label>
        <S.Button type={'submit'}>등록하기</S.Button>
      </S.Form>
    </S.Container>
  );
}

export default Admin;
