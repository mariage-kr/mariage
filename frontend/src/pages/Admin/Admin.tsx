import { useEffect, useState } from 'react';

import {
  requestCountry,
  requestDrinkLowerCategory,
} from '@/apis/request/category';
import { requestSaveImage } from '@/apis/request/storage';
import {
  requestProductInfo,
  requestSaveProduct,
  requestUpdateProduct,
} from '@/apis/request/product';

import { COUNTRY_TYPE } from '@/constants/category';

import useInput from '@/hooks/useInput';
import useSelect from '@/hooks/useSelect';
import useImage from '@/hooks/useImage';
import useSearchParam from '@/hooks/useSearchParam';
import useLevel from '@/hooks/useLevel';

import { ImageIdType } from '@/@types/id';
import { ProductModifyInfoType } from '@/@types/product';
import {
  DrinkCategoryResponseType,
  DrinkRegionCategoryType,
  DrinkUpperCategoryType,
  DrinkLowerCategoryType,
  CountryType,
} from '@/@types/category';

import * as S from './Admin.styled';

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
  const {
    value: name,
    setValue: setName,
    defaultData: defaultName,
  } = useInput<string>('');
  const {
    value: info,
    setValue: setInfo,
    defaultData: defaultInfo,
  } = useInput<string>('');
  const {
    value: country,
    setValue: setCountry,
    defaultValue: defaultCountry,
  } = useSelect<string>('');
  const {
    value: upperCategory,
    setValue: setUpperCategory,
    resetValue: resetUpperCategory,
    defaultValue: defaultUpperCategory,
  } = useSelect<string>('');
  const {
    value: lowerCategory,
    setValue: setLowerCategory,
    resetValue: resetLowerCategory,
    defaultValue: defaultLowerCategory,
  } = useSelect<string>('');
  const {
    value: image,
    setValue: setImage,
    preview: previewImage,
  } = useImage<File | null>(null);
  const { level, setLevel, inputLevel } = useLevel<number>(0);

  /* 불러온 이미지 */
  const [imageUrl, setImageUrl] = useState<string | null>(null);
  const [imageId, setImageId] = useState<number | null>(null);

  /* 검증 변수 */
  const [isValid, setIsValid] = useState<boolean>(false);
  const [errorMessage, setErrorMessage] = useState<string>('');

  /* 카테고리 데이터 요청 */
  const getCountryCategory = async () => {
    await requestCountry().then(response => {
      setCountryCategory(response.data.country);
    });
  };

  const getDrinkCategory = async () => {
    await requestDrinkLowerCategory()
      .then(response => {
        setDrinkCategoryResponse(response.data);
      })
      .catch(error => {
        setErrorMessage(error.response.data.message);
      });
  };

  /* 제품 정보 요청 */
  const getProductInfo = async () => {
    await requestProductInfo(parseInt(productId!))
      .then(response => {
        const data: ProductModifyInfoType = response.data;
        console.log(response);
        defaultName(data.name);
        defaultInfo(data.info);
        defaultCountry(data.country);
        defaultUpperCategory(data.upperCategory);
        defaultLowerCategory(data.lowerCategory);
        setLevel(data.level);
        setImageUrl(data.imageUrl);
        setImageId(data.imageId);
      })
      .catch(error => {
        // console.log(error);
        setErrorMessage(error.response.data.message);
      });
  };

  /* 제품 등록, 수정 요청 */
  const uploadImage = async (): Promise<number> => {
    const data: ImageIdType = await requestSaveImage(image!);
    return data.imageId;
  };

  const saveProduct = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const imageId: number = await uploadImage();
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
        /* TODO: 추후 제품의 상세 페이지로 이동 */
        console.log(response);
      })
      .catch(error => {
        if (error.response.status === 400) {
          setErrorMessage(error.response.data.message);
        }
      });
  };

  const updateProduct = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const newImageId: number = await uploadImage();
    const id: number = parseInt(productId!);
    if (!imageId) {
      return;
    }

    await requestUpdateProduct({
      id,
      name,
      info,
      level,
      country,
      upperCategory,
      lowerCategory,
      imageId,
      newImageId,
    })
      .then(response => {
        /* TODO: 추후 제품의 상세 페이지로 이동 */
        console.log(response);
      })
      .catch(error => {
        if (error.response.status === 400) {
          setErrorMessage(error.response.data.message);
        }
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
          category.value ===
          (country === COUNTRY_TYPE.KOREA
            ? COUNTRY_TYPE.REGION.LOCAL
            : COUNTRY_TYPE.REGION.FOREIGN),
      );
      setDrinkRegionCategory(foundRegionCategory);
    }
    resetUpperCategory();
    resetLowerCategory();
  }, [country]);

  useEffect(() => {
    if (drinkRegionCategory && upperCategory) {
      const foundUpperCategory = drinkRegionCategory.categories.find(
        (category: DrinkUpperCategoryType) => category.value === upperCategory,
      );
      setDrinkUpperCategory(foundUpperCategory);
    }

    resetLowerCategory();
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
      {productId === null ? (
        <S.Header>제품 등록 페이지</S.Header>
      ) : (
        <S.Header>제품 수정 페이지</S.Header>
      )}
      <S.Form onSubmit={productId === null ? saveProduct : updateProduct}>
        {errorMessage && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
        <S.Label>제품 이름</S.Label>
        <S.Input type={'text'} value={name} onChange={setName} />
        <S.Label>알코올 도수</S.Label>
        <S.Input
          type={'number'}
          value={level}
          onChange={inputLevel}
          max={100}
          min={0}
        />
        <S.Label>제품 설명</S.Label>
        <S.TextArea onChange={setInfo} value={info} />
        <S.Count>글자 수 : {info.length}</S.Count>
        <S.Label>국가</S.Label>
        <label>
          <S.Select onChange={setCountry}>
            <option selected disabled>
              주류의 생산 국가를 선택하세요.
            </option>
            {countryCategory.map((category: CountryType) => (
              <option
                key={category.id}
                value={category.value}
                selected={category.value === country}
              >
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
        {imageUrl && (
          <>
            <S.Image src={imageUrl} alt=""></S.Image>
            <S.Label>수정할 이미지</S.Label>
          </>
        )}
        <S.Input type={'file'} title={'이미지 업로드'} onChange={setImage} />
        {previewImage && <S.Image src={previewImage} alt="미리보기" />}
        {isValid ? (
          <S.Button type={'submit'} isValid={isValid}>
            확인
          </S.Button>
        ) : (
          <S.Button isValid={isValid} disabled>
            확인
          </S.Button>
        )}
      </S.Form>
    </S.Container>
  );
}

export default Admin;
